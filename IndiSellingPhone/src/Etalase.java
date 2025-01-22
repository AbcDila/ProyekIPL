import javax.swing.*;
import java.awt.*;

import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;

public class Etalase extends JPanel {
    JScrollPane scrollPane;
    MainFrame frame;

    public void gantiList(String query){
        if (this != null){
            //Etalase eta2 = new Etalase(query);
            listProduk list = new listProduk(query);
            /*scrollPane.removeAll();
            scrollPane.add();
            scrollPane.revalidate();
            scrollPane.repaint();*/
            this.remove(scrollPane);
            scrollPane = new JScrollPane (list,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.setMinimumSize(new Dimension(160, 200));
            scrollPane.setViewportView(list);
            scrollPane.setHorizontalScrollBar(null);
            scrollPane.getVerticalScrollBar().setUnitIncrement(50);

            this.add(scrollPane, BorderLayout.CENTER);
            this.revalidate();
            this.repaint();
        }
    }
    public Etalase(MainFrame frame){
        this.frame = frame;
        Filter filter = new Filter();
        this.setSize(1080,720);
        //this.setResizable(false);
        cart keranjang = new cart();
        this.setLayout(new BorderLayout());

        Label coba = new Label("List Produk");
        coba.setAlignment(Label.CENTER);
        JPanel panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        panel.add(coba);

        this.add(panel, BorderLayout.PAGE_START);
        this.add(new FilterPanel(this), BorderLayout.LINE_START);
        this.add(new JPanel(), BorderLayout.LINE_END);
        listProduk A = new listProduk();
        scrollPane = new JScrollPane (A,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setMinimumSize(new Dimension(160, 200));
        scrollPane.setViewportView(A);
        scrollPane.setHorizontalScrollBar(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(50);
        System.out.println(A.getX());
        this.add(scrollPane, BorderLayout.CENTER);
        this.setVisible(true);

    }
    public Etalase(String query){
        Filter filter = new Filter();
        new JFrame();
        this.setSize(1080,720);
        //this.setResizable(false);
        cart keranjang = new cart();
        this.setLayout(new BorderLayout());

        Label coba = new Label("List Produk");
        coba.setAlignment(Label.CENTER);
        JPanel panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        panel.add(coba);

        this.add(panel, BorderLayout.PAGE_START);
        this.add(new FilterPanel(this), BorderLayout.LINE_START);
        this.add(new JPanel(), BorderLayout.LINE_END);
        listProduk A = new listProduk(query);
        JScrollPane scrollPane = new JScrollPane (A);
        scrollPane.getVerticalScrollBar().setUnitIncrement(50);
        System.out.println(A.getX());
        this.add(scrollPane, BorderLayout.CENTER);
        this.setVisible(true);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /*public static void main(String[] args) {
        new Etalase();
        System.out.println("Hello world!");
        koneksiDb conn = new koneksiDb();
    }*/

}