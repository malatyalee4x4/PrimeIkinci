
package tr.gov.btk.primeikinci.vt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class VTBaglanti {
    
    
    public static Connection BaglantiAc() throws ClassNotFoundException, SQLException
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.242:1521:orcl","kurs2", "kurs2");
        return conn;
    
    }
    public static void BaglantiKapat(Connection p_conn) throws SQLException
    {
        p_conn.close();
    }
}
