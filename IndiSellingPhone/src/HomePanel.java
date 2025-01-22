import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class HomePanel extends JPanel {
    public HomePanel(ActionListener onLoginClick, ActionListener onRegisterClick, ActionListener produkListener) {
        setLayout(new BorderLayout());

        // Tambahkan Header
        HeaderPanel headerPanel = new HeaderPanel(onLoginClick, onRegisterClick, produkListener);
        add(headerPanel, BorderLayout.NORTH);

        // Tambahkan Sidebar
        SidebarPanel sidebarPanel = new SidebarPanel();
        add(sidebarPanel, BorderLayout.WEST);

        // Tambahkan Konten
        ContentPanel contentPanel = new ContentPanel();
        add(contentPanel, BorderLayout.CENTER);
    }
}
