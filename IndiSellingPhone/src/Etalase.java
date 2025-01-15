import javax.swing.*;
import java.awt.*;

import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;

public class Etalase extends JFrame {
    JScrollPane scrollPane;

    public void gantiList(String query){
        new Etalase(query);
    }
    public Etalase(){
        Filter filter = new Filter();
        new JFrame();
        this.setSize(1080,720);
        this.setResizable(false);
        cart keranjang = new cart();
        this.setLayout(new BorderLayout());

        Label coba = new Label("Hayolooo");
        Label coba1 = new Label("Hayolooo");
        coba1.setSize(300,30);
        coba1.setBackground(Color.CYAN);
        coba.setAlignment(Label.CENTER);
        JPanel panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        panel.add(coba);

        this.add(panel, BorderLayout.PAGE_START);
        this.add(new FilterPanel(), BorderLayout.LINE_START);
        this.add(new JPanel(), BorderLayout.LINE_END);
        listProduk A = new listProduk();
        JScrollPane scrollPane = new JScrollPane (A);
        scrollPane.getVerticalScrollBar().setUnitIncrement(50);
        System.out.println(A.getX());
        this.add(scrollPane, BorderLayout.CENTER);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public Etalase(String query){
        Filter filter = new Filter();
        new JFrame();
        this.setSize(1080,720);
        this.setResizable(false);
        cart keranjang = new cart();
        this.setLayout(new BorderLayout());

        Label coba = new Label("Hayolooo");
        Label coba1 = new Label("Hayolooo");
        coba1.setSize(300,30);
        coba1.setBackground(Color.CYAN);
        coba.setAlignment(Label.CENTER);
        JPanel panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        panel.add(coba);

        this.add(panel, BorderLayout.PAGE_START);
        this.add(new FilterPanel(), BorderLayout.LINE_START);
        this.add(new JPanel(), BorderLayout.LINE_END);
        listProduk A = new listProduk(query);
        JScrollPane scrollPane = new JScrollPane (A);
        scrollPane.getVerticalScrollBar().setUnitIncrement(50);
        System.out.println(A.getX());
        this.add(scrollPane, BorderLayout.CENTER);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Etalase();
        System.out.println("Hello world!");
        koneksiDb conn = new koneksiDb();
    }

}