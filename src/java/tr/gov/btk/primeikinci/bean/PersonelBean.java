
package tr.gov.btk.primeikinci.bean;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import tr.gov.btk.primeikinci.dao.PersonelDAO;
import tr.gov.btk.primeikinci.dto.Personel;

@ManagedBean
@ViewScoped
public class PersonelBean {
    
    private Personel personel;

    public PersonelBean() {
        personel =new Personel();
    }

    public Personel getPersonel() {
        return personel;
    }

    public void setPersonel(Personel personel) {
        this.personel = personel;
    }
    
    public List<Personel> getPersonelListe()
    {
        try {
            List personelListe=PersonelDAO.listelePersonel();
            return personelListe;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PersonelBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(PersonelBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
