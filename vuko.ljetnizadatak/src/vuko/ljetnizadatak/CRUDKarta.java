package vuko.ljetnizadatak;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CRUDKarta {

public static void create(Karta karta) {
	
	try {
		PreparedStatement izraz = Baza.getVeza()
				.prepareStatement("Insert into karta " + " (cijena, kupac, projekcija, sjedalo, red) " + " values (?,?,?,?,?) ");
	    izraz.setFloat(1, karta.getCijena());
	    izraz.setInt(2, karta.getKupac());
	    izraz.setInt(3, karta.getProjekcija());
	    izraz.setInt(4, karta.getSjedalo());
	    izraz.setString(5, karta.getRed());
	    
	    izraz.executeUpdate();  
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
 }

   public static List<Karta> read(){
	   List<Karta> karte = new ArrayList<>();
	   try {
		PreparedStatement izraz = Baza.getVeza().prepareStatement("select * from karta order by kupac");
        ResultSet rs = izraz.executeQuery();
        while(rs.next()) {
        	karte.add(new Karta(rs.getInt("sifra"), rs.getFloat("cijena"), rs.getInt("kupac"), rs.getInt("projekcija"), rs.getInt("sjedalo"), rs.getString("red")));
        }
        rs.close();
        izraz.close();
	   } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return karte;
	   
   }
   
   public static void update(Karta karta) {
	   try {
		PreparedStatement izraz = Baza.getVeza().prepareStatement(
				   "update karta set " + "cijena = ?" + " kupac = ?" + " projekcija = ?" + " sjedalo = ?" + " red = ?");
		 izraz.setFloat(1, karta.getCijena());
		    izraz.setInt(2, karta.getKupac());
		    izraz.setInt(3, karta.getProjekcija());
		    izraz.setInt(4, karta.getSjedalo());
		    izraz.setString(5, karta.getRed());
		    
		    izraz.executeUpdate();  
	   } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   
   public static void delete(int sifra) {
	   PreparedStatement izraz;
	   
	   try {
		izraz = Baza.getVeza().prepareStatement(
				   " delete from osoba " + " where sifra = ?");
       izraz.setInt(1, sifra);
       
       izraz.executeUpdate();
	   } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   public static Karta getKarta(int redniBroj) {
	  int rb = 0;
	  for(Karta k : read()) {
		  if(++rb == redniBroj) {
			  return k;
		  }
	  }
	   
	   return null;
	   
   }
}

