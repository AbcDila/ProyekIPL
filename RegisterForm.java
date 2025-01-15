import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterForm extends JPanel {
    public RegisterForm(JFrame parentFrame) {
        setLayout(new BorderLayout());

        // Panel Judul
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel titleLabel = new JLabel("indi cell");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titlePanel.add(titleLabel);

        // Panel Form
        JPanel formPanel = new JPanel(new GridLayout(7, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel usernameLabel = new JLabel("Username");
        JTextField usernameField = new JTextField();

        JLabel firstNameLabel = new JLabel("First Name");
        JTextField firstNameField = new JTextField();

        JLabel lastNameLabel = new JLabel("Last Name");
        JTextField lastNameField = new JTextField();

        JLabel emailLabel = new JLabel("Email");
        JTextField emailField = new JTextField();

        JLabel passwordLabel = new JLabel("Password");
        JPasswordField passwordField = new JPasswordField();

        JLabel confirmPasswordLabel = new JLabel("Konfirmasi Password");
        JPasswordField confirmPasswordField = new JPasswordField();

        JButton registerButton = new JButton("Register");
        JLabel loginLabel = new JLabel("<html><u>Login</u></html>");
        loginLabel.setForeground(Color.BLUE);

        // Tambahkan Listener untuk navigasi ke Login
        loginLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Main.showLoginForm(); // Navigasi ke form Login
            }
        });

        // Tambahkan komponen ke formPanel
        formPanel.add(usernameLabel);
        formPanel.add(usernameField);
        formPanel.add(firstNameLabel);
        formPanel.add(firstNameField);
        formPanel.add(lastNameLabel);
        formPanel.add(lastNameField);
        formPanel.add(emailLabel);
        formPanel.add(emailField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);
        formPanel.add(confirmPasswordLabel);
        formPanel.add(confirmPasswordField);
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
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            // Validasi input
            if (username.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "Password dan Konfirmasi Password tidak cocok!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Registrasi user ke database
            registerUser(username, firstName, lastName, email, password);
        });
    }

    private void registerUser(String username, String firstName, String lastName, String email, String password) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            // Perhatikan: user_id tidak perlu disertakan dalam query karena akan auto-increment
            String query = "INSERT INTO users (username, first_name, last_name, email, password) VALUES (?, ?, ?, ?, MD5(?))";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.setString(4, email);
            ps.setString(5, password);

            int rowsAffected = ps.executeUpdate();

            System.out.println("Rows affected: " + rowsAffected); // Debugging: cek hasil query

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Registrasi Berhasil!");
                Main.showLoginForm(); // Navigasi ke form Login setelah registrasi
            } else {
                JOptionPane.showMessageDialog(this, "Registrasi Gagal!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
