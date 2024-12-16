package electricity.billing.system;
import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    
    Conn(){
        try {
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebilling", "root", "@iri^niarobi");
        s = c.createStatement();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
