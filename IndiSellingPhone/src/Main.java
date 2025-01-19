import javax.swing.*;
import javax.swing.plaf.PanelUI;
import java.awt.*;
import java.sql.*;
public class Main extends JFrame {
    static Etalase panelEtalase;
    public Main(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new JFrame();
        this.setSize(1080,720);
        this.setResizable(false);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        koneksiDb conn = new koneksiDb();
        Main FramePan = new Main();
        panelEtalase = new Etalase(FramePan);
        FramePan.add(panelEtalase);
        System.out.println("Hello world!");
        FramePan.setVisible(true);
    }
    public void gantiFilter(){

    }
}