
package tr.gov.btk.primeikinci.test;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tr.gov.btk.primeikinci.dao.PersonelDAO;
import tr.gov.btk.primeikinci.dto.Personel;


public class PersonelDAOTest {
    
    public static void testListelePersonel()
    {
        try {
            List<Personel> personelListe=PersonelDAO.listelePersonel();
            for (Personel personel : personelListe) {
                System.out.println(personel.getNo()+" " +personel.getAd());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PersonelDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PersonelDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void TestEklePersonel()
    {
        try {
            Personel per1= new Personel();
            per1.setNo(1);
            per1.setAd("Hikmet");
            per1.setSoyad("Karaman");
            per1.setEposta("ccc@ccc.com");
            per1.setMaas(1234.56);
            per1.setDogtar(new java.util.Date());
            
            boolean sonuc=PersonelDAO.EklePersonel(per1);
            
            if(sonuc)
            {
                System.out.println("Personel eklendi");
            }
            else
            {
                System.out.println("Hata oluştu");
            }
                
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        testListelePersonel();
    }
    
}
