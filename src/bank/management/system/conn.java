
package bank.management.system;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class conn {
            Connection c;
        Statement s;
    public conn(){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagement", "root", "K@rthik2005");

            s=c.createStatement();
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error connecting to database:");
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
 

}
