
package tr.gov.btk.primeikinci.test;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tr.gov.btk.primeikinci.dao.GirisDAO;
import tr.gov.btk.primeikinci.dto.Giris;


public class GirisDAOTest {
  
    public static void testGiriseYetkilimi() 
    {
        try {
            Giris giris=new Giris();
            
            giris.setAd("cumali");
            giris.setSifre("1234");
            
            boolean sonuc= GirisDAO.giriseYetkilimi(giris);
            
            if(sonuc)
            {
                System.out.println("Giris yapıldı");
            }
            else
            {
                System.out.println("Hatalı giriş");
            }
        } catch (SQLException ex) {
            Logger.getLogger(GirisDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GirisDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        testGiriseYetkilimi();
        
    }
}
