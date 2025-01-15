import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginForm extends JPanel {
    public LoginForm(JFrame parentFrame) {
        setLayout(new BorderLayout());

        // Panel untuk menampung komponen
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS)); // Menata komponen secara vertikal
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40)); // Menambahkan padding pada panel

        JLabel emailLabel = new JLabel("Email Address");
        JTextField emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(200, 30)); // Atur ukuran field

        JLabel passwordLabel = new JLabel("Password");
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200, 30)); // Atur ukuran field

        JButton loginButton = new JButton("Login");

        // Label untuk navigasi ke Register Form
        JLabel registerLabel = new JLabel("<html>Belum punya akun? <u>Daftar di sini</u></html>");
        registerLabel.setForeground(Color.BLUE);

        // Tambahkan Listener untuk navigasi ke RegisterForm
        registerLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Main.showRegisterForm(); // Navigasi ke form Register
            }
        });

        // Menambahkan komponen ke dalam formPanel
        formPanel.add(emailLabel);
        formPanel.add(emailField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);
        formPanel.add(Box.createVerticalStrut(10)); // Memberikan jarak antar komponen
        formPanel.add(loginButton);
        formPanel.add(registerLabel); // Menambahkan label navigasi ke RegisterForm

        // Tambahkan formPanel ke panel utama
        add(formPanel, BorderLayout.CENTER);

        // Tambahkan Listener untuk tombol Login
        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            if (authenticateUser(email, password)) {
                JOptionPane.showMessageDialog(this, "Login Berhasil!");
            } else {
                JOptionPane.showMessageDialog(this, "Email atau Password salah!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private boolean authenticateUser(String email, String password) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM users WHERE email = ? AND password = MD5(?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);

            System.out.println("Query: " + query); // Debugging query
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("User found: " + rs.getString("email")); // Debugging result
                return true; // User found
            } else {
                System.out.println("User not found"); // Debugging result
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
