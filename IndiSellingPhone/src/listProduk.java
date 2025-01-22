import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class listProduk extends JPanel{
    koneksiDb conn = new koneksiDb();
    public listProduk(){
        this.setLayout(new GridLayout(0,3,40,25));
        //this.setLayout(new FlowLayout());
        //this.setSize(400,400);
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
        this.setLayout(new GridLayout(0,3,40,25));
        //this.setSize(400,400);
        ResultSet ress = conn.dataDariDB(query);
        try {
            int i = 0;
            while (ress.next()){
                this.add(new card(ress));
                System.out.println(ress.getString(7));
                i++;
            }
            if(i<4){
                for(int j = 0; j<3;j++){
                    this.add(new card());
                }
            }
        }catch (Exception e){

        }
    }
}
