package vuko.ljetnizadatak;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CRUDHranaIPice {
     
	public static void create(HranaIPice hranaIPice) {
		
		try {
			PreparedStatement izraz = Baza.getVeza().prepareStatement("Insert into hranaIPice " + " (naziv, cijena)");
		izraz.setString(1, hranaIPice.getNaziv());
		izraz.setFloat(2, hranaIPice.getCijena());
		
		izraz.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<HranaIPice> read(){
		List<HranaIPice> hranaIPica = new ArrayList<>();
		
		try {
			PreparedStatement izraz = Baza.getVeza().prepareStatement("select * from hranaIPice order by cijena");
		    ResultSet rs = izraz.executeQuery();
		    while(rs.next()) {
		    	hranaIPica.add(new HranaIPice(rs.getInt("sifra"), rs.getString("naziv"), rs.getFloat("cijena")));
		    }
		    rs.close();
		    izraz.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hranaIPica;
		
	}
	
	public static void update(HranaIPice hranaIPice) {
		
		try {
			PreparedStatement izraz = Baza.getVeza().prepareStatement(
					"update hranaIPice set " + " naziv = ?," + " cijena = ?");
			izraz.setString(1, hranaIPice.getNaziv());
			izraz.setFloat(2, hranaIPice.getCijena());
			
			izraz.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void delete(int sifra) {
		PreparedStatement izraz;
		
		try {
			izraz = Baza.getVeza().prepareStatement("delete from hranaIPice " + " where sifra = ?");
		
		    izraz.setInt(1, sifra);
		    
		    izraz.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static HranaIPice getHranaIPice(int redniBroj) {
		int rb = 0;
		for(HranaIPice h : read()) {
		  
			if(++rb == redniBroj) {
				return h;
			}
		}
		
		return null;
		
	}
}
