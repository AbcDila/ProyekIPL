import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DetailProduct extends JFrame {
    int pk;
    public DetailProduct() throws SQLException {
        pk =1;
        koneksiDb con = new koneksiDb();
        ResultSet data = con.dataDariDB("select * from product where product_id = "+pk);
        JPanel pNav = new JPanel(new FlowLayout(FlowLayout.LEFT, 10,10));
        JPanel pDetail = new JPanel(new GridLayout(7, 1));
        JPanel pCart = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel utama = new JPanel(new BorderLayout(50,50));
        ImageIcon icon = null;
        JLabel gambar = new JLabel();
        JLabel jdl = new JLabel("IndiSellingPhone");
        JButton home = new JButton("Home");
        JButton lProduk = new JButton("Produk");
        JButton lChart = new JButton("Keranjang");
        JButton cart = new JButton("Add to Cart");
        JButton checkout = new JButton("Checkout");
        JTextField qty = new JTextField("1");
        JLabel nama = new JLabel();
        JLabel harga = new JLabel();
        JLabel deskripsi = new JLabel();
        JLabel kategori = new JLabel();
        while (data.next()){
            icon = new ImageIcon("D:/ProyekIPL/IndiSellingPhone/src/images/"+data.getString("gambar"));
            nama.setText(data.getString("name"));
            harga.setText(data.getString("price"));
            deskripsi.setText(data.getString("description"));
            int i = data.getInt("category_id");
            if (i==1){
                kategori.setText("Categories: Handphone Bagus");
            } else if (i==2) {
                kategori.setText("Categories: Handphone Jelek");
            }

        }
        gambar.setIcon(icon);
        cart.setBackground(Color.black);
        cart.setForeground(Color.white);
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.white);
        home.setBorder(null);
        home.setBackground(new Color(128, 196, 233));
        lProduk.setBorder(null);
        lProduk.setBackground(new Color(128, 196, 233));
        lChart.setBorder(null);
        lChart.setBackground(new Color(128, 196, 233));
        pNav.add(jdl);
        pNav.add(home);
        pNav.add(lProduk);
        pNav.add(lChart);
        pNav.setBackground(new Color(128, 196, 233));
        pCart.add(qty);
        pCart.add(cart);
        pCart.setBackground(Color.white);
        pDetail.add(nama);
        pDetail.add(harga);
        pDetail.add(deskripsi);
        pDetail.add(pCart);
        pDetail.add(kategori);
        pDetail.add(checkout);
        pDetail.setBackground(Color.white);
        utama.setBackground(Color.white);
        utama.add(pNav, BorderLayout.NORTH);
        utama.add(gambar, BorderLayout.WEST);
        utama.add(pDetail, BorderLayout.CENTER);
        this.add(utama);
        this.setSize(1080,720);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        checkout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Checkout(1);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    public static void main(String[] args) throws SQLException {
        new DetailProduct();
    }
}
