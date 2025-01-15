import java.sql.*;

public class koneksiDb {
    public koneksiDb(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db_gadget_market","root","");
            Statement stmt=con.createStatement();
            ResultSet res=stmt.executeQuery("select * from provinces");
            while (res.next()){
                System.out.println(res.getInt(1)+"  "+res.getString(2)+"  ");
            }
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }
    public ResultSet dataDariDB(String query){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db_gadget_market", "root", "");
            Statement statement = conn.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
