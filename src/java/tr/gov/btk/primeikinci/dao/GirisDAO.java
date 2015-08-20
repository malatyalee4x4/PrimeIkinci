
package tr.gov.btk.primeikinci.dao;

import java.sql.*;


import tr.gov.btk.primeikinci.dto.Giris;
import tr.gov.btk.primeikinci.vt.VTBaglanti;

public class GirisDAO {
  
    public static boolean giriseYetkilimi(Giris p_giris) throws SQLException, ClassNotFoundException
    {
        String vtSifre=null;
        Connection conn= VTBaglanti.BaglantiAc();
        PreparedStatement ps=conn.prepareStatement("select sifre from giris where ad=?");
        ps.setString(1, p_giris.getAd());
        ResultSet rs=ps.executeQuery();
        
        while(rs.next())
        {
            vtSifre=rs.getString("sifre");
        }
        rs.close();
        VTBaglanti.BaglantiKapat(conn);
        if(vtSifre!=null && vtSifre.equals(p_giris.getSifre()))
        {
            return true;
        }
        else{
            return false;
        }
        
    }
}
