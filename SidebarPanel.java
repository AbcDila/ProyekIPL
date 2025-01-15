import javax.swing.*;
import java.awt.*;

public class SidebarPanel extends JPanel {
    public SidebarPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(224, 224, 224)); // Warna abu-abu muda

        // Tambahkan tombol kategori
        JButton kategori1 = new JButton("Handphone Jelek");
        JButton kategori2 = new JButton("Handphone Bagus");

        add(Box.createVerticalStrut(20)); // Jarak atas
        add(kategori1);
        add(Box.createVerticalStrut(10)); // Jarak antar tombol
        add(kategori2);
    }
}
