import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionListener;

public class RegisterForm extends JPanel {
    public RegisterForm(JFrame parentFrame, ActionListener onRegisterSuccess, ActionListener onBackToLogin) {
        setLayout(new BorderLayout());

        // Panel Judul
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel titleLabel = new JLabel("indi cell");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titlePanel.add(titleLabel);

        // Panel Form
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel usernameLabel = new JLabel("Username");
        JTextField usernameField = new JTextField();

        JLabel emailLabel = new JLabel("Email");
        JTextField emailField = new JTextField();

        JLabel passwordLabel = new JLabel("Password");
        JPasswordField passwordField = new JPasswordField();

        JButton registerButton = new JButton("Register");
        JLabel loginLabel = new JLabel("<html><u>Login</u></html>");
        loginLabel.setForeground(Color.BLUE);

        loginLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onBackToLogin.actionPerformed(null); // Gunakan ActionListener untuk kembali ke login
            }
        });

        // Tambahkan komponen ke formPanel
        formPanel.add(usernameLabel);
        formPanel.add(usernameField);
        formPanel.add(emailLabel);
        formPanel.add(emailField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);
        formPanel.add(new JLabel()); // Spacer
        formPanel.add(registerButton);

        // Tambahkan label login
        JPanel footerPanel = new JPanel();
        footerPanel.add(loginLabel);

        // Tambahkan panel ke RegisterForm
        add(titlePanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);

        // Listener untuk tombol Register
        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            // Validasi input
            if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Registrasi user ke database
            if (registerUser(username, email, password)) {
                JOptionPane.showMessageDialog(this, "Registrasi Berhasil!");
                // Navigasi ke login menggunakan ActionListener
                onRegisterSuccess.actionPerformed(e);
            }
        });
    }

    private boolean registerUser(String username, String email, String password) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO users (username, email, password) VALUES (?, ?, MD5(?))";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, password);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0; // Kembalikan true jika registrasi berhasil
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false; // Kembalikan false jika terjadi error
        }
    }
}
