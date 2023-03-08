/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arheoloskanalazista.a8;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Korisnik
 */
public class DatabaseProxy {
    private static final String URLBAZE ="jdbc:ucanaccess://src\\antikviteti\\ArheoloskaNalazista.accdb";
    private static Connection c;
    
    public static void konektujSe(){
        try {
            c = DriverManager.getConnection(URLBAZE);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<TipoviDO> getTipovi(){
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM TipAntikviteta");
            ArrayList<TipoviDO> tipovi = new ArrayList<>();
            while(rs.next()){
                TipoviDO tip = new TipoviDO();
                tip.ID = rs.getInt("TipID");
                tip.Tip  = rs.getString("Tip");
                tip.putanja = rs.getString("Slika");
                tipovi.add(tip);
            }
            return tipovi;
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseProxy.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }       
      
    }
    
}
