import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginForm extends JPanel {
    public LoginForm(ActionListener onLoginSuccess, ActionListener onBackToHome, ActionListener onNavigateToRegister) {
        setLayout(new BorderLayout());

        // Form Login
        JLabel emailLabel = new JLabel("Email");
        JTextField emailField = new JTextField();
        JLabel passwordLabel = new JLabel("Password");
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JButton backButton = new JButton("Back");

        // Tambahkan listener untuk tombol login
        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            // Validasi login dari database
            if (authenticateUser(email, password)) {
                JOptionPane.showMessageDialog(this, "Login Berhasil!");
                onLoginSuccess.actionPerformed(e); // Navigasi ke HomePanel
            } else {
                JOptionPane.showMessageDialog(this, "Email atau Password salah!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Tambahkan listener untuk tombol kembali
        backButton.addActionListener(onBackToHome); // Kembali ke HomePanel

        // Layout form
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.add(emailLabel);
        formPanel.add(emailField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);
        formPanel.add(loginButton);
        formPanel.add(backButton);

        // Tambahkan hyperlink untuk navigasi ke RegisterForm
        JLabel registerLabel = new JLabel("<html><u>Belum punya akun? Registrasi di sini</u></html>");
        registerLabel.setForeground(Color.BLUE);
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onNavigateToRegister.actionPerformed(null); // Navigasi ke RegisterForm
            }
        });

        // Tambahkan komponen ke panel utama
        add(formPanel, BorderLayout.CENTER);
        add(registerLabel, BorderLayout.SOUTH); // Letakkan teks di bawah form
    }

    /**
     * Metode untuk memvalidasi pengguna berdasarkan data di database.
     */
    private boolean authenticateUser(String email, String password) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            // Query untuk memeriksa email dan password
            String query = "SELECT * FROM users WHERE email = ? AND password = MD5(?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            return rs.next(); // Jika ada hasil, berarti login berhasil
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
