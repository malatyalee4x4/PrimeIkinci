/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.btk.primeikinci.dao;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tr.gov.btk.primeikinci.dto.Personel;
import tr.gov.btk.primeikinci.util.Cevir;
import tr.gov.btk.primeikinci.vt.VTBaglanti;

/**
 *
 * @author cumali.gurgun
 */
public class PersonelDAO {
    
    public static List<Personel> listelePersonel() throws ClassNotFoundException, SQLException
    {
        Connection conn= VTBaglanti.BaglantiAc();
        
        ArrayList<Personel> personelListe=new ArrayList<Personel>();
        Personel personel;
        PreparedStatement ps=conn.prepareStatement("select no,ad,soyad,maas,dogtar from personel");
        
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            personel= new Personel();
            personel.setNo(rs.getInt("no"));
            personel.setAd(rs.getString("ad"));
            personel.setSoyad(rs.getString("soyad"));
            personel.setMaas(rs.getDouble("maas"));
            personel.setDogtar(Cevir.sqlToUtilDate(rs.getDate("dogtar")));
            
            personelListe.add(personel);
        }
        rs.close();
        VTBaglanti.BaglantiKapat(conn);
        return personelListe;
    }
    
    public static boolean EklePersonel(Personel p_kisi) throws SQLException, ClassNotFoundException
    {
        Connection conn=VTBaglanti.BaglantiAc();
        
        PreparedStatement ps=conn.prepareStatement("insert into personel values(?,?,?,?,?,?)");
        ps.setInt(1, p_kisi.getNo());
        ps.setString(2, p_kisi.getAd());
        ps.setString(3, p_kisi.getSoyad());
        ps.setDouble(4, p_kisi.getMaas());
        ps.setString(5,p_kisi.getEposta());
        ps.setDate(6,Cevir.utilDateToSqlDate(p_kisi.getDogtar()));
        
        
        int sayi=ps.executeUpdate();
        if(sayi>0)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
    
}
