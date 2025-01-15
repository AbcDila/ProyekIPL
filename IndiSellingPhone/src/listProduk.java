import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class listProduk extends JPanel {
    koneksiDb conn = new koneksiDb();
    public listProduk(){
        new JPanel();
            this.setLayout(new GridLayout(0,3,40,25));
        this.setSize(400,400);
        String query = "select * from product";
        ResultSet ress = conn.dataDariDB(query);
        try {
            while (ress.next()){
                this.add(new card(ress));
            }
        }catch (Exception e){

        }
    }
    public listProduk(String query){
        new JPanel();
        this.setLayout(new GridLayout(0,3,40,25));
        this.setSize(400,400);
        ResultSet ress = conn.dataDariDB(query);
        try {
            while (ress.next()){
                this.add(new card(ress));
                System.out.println(ress.getString(7));
            }
        }catch (Exception e){

        }
    }
}
