
package tr.gov.btk.primeikinci.bean;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import tr.gov.btk.primeikinci.dao.GirisDAO;
import tr.gov.btk.primeikinci.dto.Giris;

@ManagedBean
@RequestScoped
public class GirisBean {
    
    
    private Giris giris;

    public GirisBean() {
        giris=new Giris();
    }

    public Giris getGiris() {
        return giris;
    }

    public void setGiris(Giris giris) {
        this.giris = giris;
    }
    
    public String girisKontrol()
    {
        try {
            boolean sonuc=GirisDAO.giriseYetkilimi(giris);
            
            if(sonuc)
            {
                return "menu.xhtml";
            }
            else
            {
                return "Giris.xhtml";
            }
        } catch (SQLException ex) {
            Logger.getLogger(GirisBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GirisBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
}
