import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class HeaderPanel extends JPanel {
    public HeaderPanel(ActionListener onLoginClick, ActionListener onRegisterClick, ActionListener produkListener) {
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        setBackground(new Color(173, 216, 230)); // Warna biru muda

        // Logo
        JLabel logo = new JLabel("IC");
        logo.setFont(new Font("Arial", Font.BOLD, 24));
        logo.setHorizontalAlignment(SwingConstants.LEFT);
        add(logo, BorderLayout.WEST);

        // Menu Navigasi
        JPanel menuPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        menuPanel.setOpaque(false); // Transparan
        JButton homeButton = new JButton("Home");
        JButton produkButton = new JButton("Produk");
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");
        add(menuPanel, BorderLayout.CENTER);

        loginButton.addActionListener(onLoginClick);
        registerButton.addActionListener(onRegisterClick);
        produkButton.addActionListener(produkListener);

        add(homeButton);
        add(produkButton);
        add(loginButton);
        add(registerButton);


        // Bagian kanan (Search, Favorit, dll.)
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.setOpaque(false); // Transparan
        rightPanel.add(new JTextField("Search...", 15));
        rightPanel.add(new JLabel("❤ Favorites"));
        rightPanel.add(new JLabel("🛒 Orders"));
        add(rightPanel, BorderLayout.EAST);
    }
}
