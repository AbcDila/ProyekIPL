import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegisterForm extends JPanel {
    public RegisterForm(ActionListener onRegisterSuccess, ActionListener onBackToHome) {
        setLayout(new BorderLayout());

        // Form Register
        JLabel nameLabel = new JLabel("Name");
        JTextField nameField = new JTextField();
        JLabel emailLabel = new JLabel("Email");
        JTextField emailField = new JTextField();
        JLabel passwordLabel = new JLabel("Password");
        JPasswordField passwordField = new JPasswordField();
        JButton registerButton = new JButton("Register");
        JButton backButton = new JButton("Back");

        // Tambahkan listener
        registerButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            // Simulasi registrasi
            if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Registrasi Berhasil!");
                onRegisterSuccess.actionPerformed(e); // Navigasi ke HomePanel
            } else {
                JOptionPane.showMessageDialog(this, "Lengkapi semua data!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        backButton.addActionListener(onBackToHome); // Kembali ke HomePanel

        // Layout form
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(emailLabel);
        formPanel.add(emailField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);
        formPanel.add(registerButton);
        formPanel.add(backButton);

        add(formPanel, BorderLayout.CENTER);
    }
}
