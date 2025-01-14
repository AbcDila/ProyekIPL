import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class koneksiDb {
    public koneksiDb(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("MASUK");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db_gadget_market","root","");
            Statement stmt=con.createStatement();
            System.out.println("okeh iso");
            ResultSet res=stmt.executeQuery("select * from provinces");
            while (res.next()){
                System.out.println(res.getInt(1)+"  "+res.getString(2)+"  ");
            }
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            System.out.println("HAHAHAHAHA CACAD");
        }
    }
}
