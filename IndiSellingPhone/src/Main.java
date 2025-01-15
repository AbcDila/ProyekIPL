import javax.swing.*;
import java.sql.*;
public class Main extends JFrame {
    public Main(){
        new JFrame();
        this.setSize(1080,720);
        cart keranjang = new cart();
        this.add(keranjang);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new Main();
        System.out.println("Hello world!");
        koneksiDb conn = new koneksiDb();
    }
}