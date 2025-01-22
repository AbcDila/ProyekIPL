import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Indi Cell");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 768);
        setResizable(false);
        setLayout(new CardLayout());

        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();

        // Panel utama
        HomePanel homePanel = new HomePanel(
                e -> cardLayout.show(getContentPane(), "LoginPanel"), // Ke LoginPanel
                e -> cardLayout.show(getContentPane(), "RegisterPanel"), // Ke RegisterPanel
                e -> cardLayout.show(getContentPane(), "PanelEtalase") // Ke RegisterPanel
        );

        LoginForm loginForm = new LoginForm(
                e -> cardLayout.show(getContentPane(), "HomePanel"), // Login berhasil
                e -> cardLayout.show(getContentPane(), "HomePanel"), // Kembali ke HomePanel
                e -> cardLayout.show(getContentPane(), "RegisterPanel") // Ke RegisterForm
        );

        RegisterForm registerForm = new RegisterForm(
                this, // JFrame parentFrame
                e -> cardLayout.show(getContentPane(), "LoginPanel"), // Pindah ke LoginPanel
                e -> cardLayout.show(getContentPane(), "HomePanel")  // Pindah ke HomePanel
        );
        Etalase panelEtalase = new Etalase(this);


        // Tambahkan panel ke CardLayout
        getContentPane().add(homePanel, "HomePanel");
        getContentPane().add(loginForm, "LoginPanel");
        getContentPane().add(registerForm, "RegisterPanel");
        getContentPane().add(panelEtalase, "PanelEtalase");

        // Tampilkan HomePanel saat aplikasi dijalankan
        cardLayout.show(getContentPane(), "HomePanel");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
