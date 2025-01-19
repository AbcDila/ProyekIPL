import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FilterPanel extends JPanel {
    Etalase eta;
    public FilterPanel(Etalase eta){
        this.eta = eta;
        Filter aksi = new Filter();
        new JPanel();
        JPanel panel1 = new JPanel(new GridLayout(0,1,10,10));
        JPanel labelPanel = new JPanel();
        JLabel labelFilter = new JLabel("Filter Harga");
        labelFilter.setHorizontalAlignment(JLabel.CENTER);
        labelPanel.add(labelFilter);

        this.setPreferredSize(new Dimension(200,100));
        JRadioButton radio1 = new JRadioButton("< 1.000.000");
        JRadioButton radio2 = new JRadioButton("  1.000.001 - 5.000.000");
        JRadioButton radio3 = new JRadioButton("> 5.000.000");
        ButtonGroup G = new ButtonGroup();
        radio1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aksi.kurangDari(eta);
            }
        });
        radio2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aksi.Antara(eta);
            }
        });
        radio3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aksi.lebihDari(eta);
            }
        });
        G.add(radio1);
        G.add(radio2);
        G.add(radio3);

        this.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel1.add(radio1);
        panel1.add(radio2);
        panel1.add(radio3);
        this.add(labelPanel);
        this.add(panel1);
    }
}
