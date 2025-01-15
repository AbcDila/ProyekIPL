import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Checkout extends JFrame {
    Checkout(int i) throws SQLException {
        koneksiDb con = new koneksiDb();
        ResultSet dProv = con.dataDariDB("select * from provinces");
        ResultSet dKota = con.dataDariDB("select * from city");
        ResultSet data = con.dataDariDB("select * from product where product_id = "+i);
        //con.insertData("insert into orders");
        JPanel kiri = new JPanel(new GridLayout(13,1));
        JPanel kanan = new JPanel(new GridLayout(13,1));
        JPanel namaLengkap = new JPanel(new GridLayout(2,2));
        JPanel kotaPos = new JPanel(new GridLayout(2,2));
        JPanel produkD = new JPanel(new GridLayout(1,2));
        JPanel taxD = new JPanel(new GridLayout(1,2));
        JPanel shippingD = new JPanel(new GridLayout(1,2));
        JPanel totalD = new JPanel(new GridLayout(1,2));
        JScrollPane sp = new JScrollPane();
        JLabel billing = new JLabel("BILLING DETAILS");
        JLabel namaDepan  = new JLabel("Nama Depan");
        JLabel namaBelakang = new JLabel("Nama Belakang");
        JLabel alamat = new JLabel("Alamat");
        JLabel provinsi = new JLabel("Provinsi");
        JLabel kota = new JLabel("Kota");
        JLabel kodePos = new JLabel("Kode Pos");
        JLabel pesanan = new JLabel("PESANAN ANDA");
        JLabel produk = new JLabel("");
        JLabel total = new JLabel("");
        JLabel tax = new JLabel("TAX");
        JLabel tax1 = new JLabel("");
        JLabel subtotal = new JLabel("");
        JLabel shipping = new JLabel("SHIPPING COST");
        JLabel orderTotal = new JLabel("ORDER TOTAL");
        JTextField name1 = new JTextField();
        JTextField name2 = new JTextField();
        JTextField alamat1 = new JTextField();
        JTextField kodePos1 = new JTextField();
        JComboBox<Object> prov = new JComboBox<>();
        JComboBox kota1 = new JComboBox<>();
        JComboBox shipCost = new JComboBox<>();
        JButton mp = new JButton("Metode Pembayaran");
        JButton ck = new JButton("Buat Pesanan");
        while (dProv.next()){
            prov.addItem(dProv.getString(2));
        }
        while (dKota.next()){
            kota1.addItem(dKota.getString(2));
        }
        billing.setFont(new Font("Monospaced",Font.BOLD, 20 ));
        pesanan.setFont(new Font("Monospaced",Font.BOLD, 20 ));
        prov.setBackground(Color.lightGray);
        kota1.setBackground(Color.lightGray);
        kodePos1.setBackground(Color.lightGray);
        mp.setBackground(Color.BLACK);
        mp.setForeground(Color.white);
        ck.setBackground(Color.red);
        ck.setForeground(Color.white);
        namaLengkap.add(namaDepan);
        namaLengkap.add(namaBelakang);
        namaLengkap.add(name1);
        namaLengkap.add(name2);
        namaLengkap.setBackground(Color.white);
        kotaPos.add(kota);
        kotaPos.add(kodePos);
        kotaPos.add(kota1);
        kotaPos.add(kodePos1);
        kotaPos.setBackground(Color.white);
        kiri.add(billing);
        kiri.add(namaLengkap);
        kiri.add(alamat);
        kiri.add(alamat1);
        kiri.add(provinsi);
        kiri.add(prov);
        kiri.add(kotaPos);
        kiri.setBackground(Color.white);
        while (data.next()){
            produk.setText(data.getString("name"));
            subtotal.setText("Rp."+data.getInt("price"));
            int t = data.getInt("price")*2/100;
            tax1.setText("Rp."+t);
            int ot;
            if (shipCost.getSelectedIndex()==0){
                ot = data.getInt("price")+t+15000;
                total.setText("Rp."+ot);
            } else if (shipCost.getSelectedIndex()==1) {
                ot = data.getInt("price")+t+20000;
                total.setText("Rp."+ot);
            }
        }
        produkD.add(produk);
        produkD.add(subtotal);
        taxD.add(tax);
        taxD.add(tax1);
        shipCost.addItem("15000");
        shipCost.addItem("20000");
        shippingD.add(shipping);
        shippingD.add(shipCost);
        totalD.add(orderTotal);
        totalD.add(total);
        kanan.add(pesanan);
        kanan.add(produkD);
        kanan.add(taxD);
        kanan.add(shippingD);
        kanan.add(totalD);
        kanan.add(mp);
        kanan.add(ck);

        this.setLayout(new GridLayout());
        this.add(kiri);
        this.add(kanan);
        this.setVisible(true);
        this.setSize(1080,720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        ck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ck, "Pesanan Berhasil Dibuat");
                try {
                    new DetailProduct();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
