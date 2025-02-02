import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.ResultSet;

public class card extends JPanel {
    public card(ResultSet setData){
        new JPanel();
        this.setBackground(new Color(204,229,255));
        try {
            BufferedImage pic = ImageIO.read(new File("src/gambar/"+setData.getString(8)));
            int key = setData.getInt("product_id");
            JLabel picLabel = new JLabel(new ImageIcon(pic));
            JLabel labelHP = new JLabel(setData.getString(7));
            JLabel hargaHP = new JLabel("("+setData.getString(6)+")");
            this.add(picLabel);
            this.add(labelHP);
            this.add(hargaHP);
            this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            this.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        new DetailProduct(key);
                    }catch (Exception a){
                        System.out.println(a.getLocalizedMessage());
                    }

                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }

        this.setBorder(BorderFactory.createEmptyBorder(25,10,10,10));
    }
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(250,275);
    }
    public  card(){
        this.add(new JLabel());
    }

}
