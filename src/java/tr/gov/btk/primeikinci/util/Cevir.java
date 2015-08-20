
package tr.gov.btk.primeikinci.util;

/**
 *
 * @author cumali.gurgun
 */
public class Cevir {
    public static java.sql.Date utilDateToSqlDate(java.util.Date p_tarih)
    {
        return new java.sql.Date(p_tarih.getTime());
    }
    
    public static java.util.Date sqlToUtilDate(java.sql.Date p_tarih)
    {
        return new java.util.Date(p_tarih.getTime());
    }
}
