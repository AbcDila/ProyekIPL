import javax.swing.*;
import java.awt.*;

public class ContentPanel extends JPanel {
    public ContentPanel() {
        setLayout(new GridLayout(1, 2, 10, 10)); // Grid dengan 2 kolom
        setBackground(Color.WHITE);

        // Contoh produk
        JLabel produk1 = new JLabel(new ImageIcon("path/to/image1.png")); // Ganti dengan path gambar
        JLabel produk2 = new JLabel(new ImageIcon("path/to/image2.png")); // Ganti dengan path gambar

        add(produk1);
        add(produk2);
    }
}
