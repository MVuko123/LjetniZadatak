package vuko.ljetnizadatak;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDPojeoPopio {
public static void create(PojeoPopio pojeoPopio) {
		
		try {
			PreparedStatement izraz = Baza.getVeza().prepareStatement("Insert into pojeoPopio " + " (naziv, cijena, kolicina)");
		izraz.setString(1, pojeoPopio.getNaziv());
		izraz.setFloat(2, pojeoPopio.getCijena());
		izraz.setFloat(3, pojeoPopio.getKolicina());
		
		izraz.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<PojeoPopio> read(){
		List<PojeoPopio> pojedenoPopijeno = new ArrayList<>();
		
		try {
			PreparedStatement izraz = Baza.getVeza().prepareStatement("select * from pojeoPopio order by kolicina");
		    ResultSet rs = izraz.executeQuery();
		    while(rs.next()) {
		    	pojedenoPopijeno.add(new PojeoPopio(rs.getInt("sifra"), rs.getString("naziv"), rs.getFloat("cijena"), rs.getFloat("kolicina")));
		    }
		    rs.close();
		    izraz.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pojedenoPopijeno;
		
	}
	
	public static void update(PojeoPopio pojeoPopio) {
		
		try {
			PreparedStatement izraz = Baza.getVeza().prepareStatement(
					"update hranaIPice set " + " naziv = ?," + " cijena = ?," + " kolicina = ?");
			izraz.setString(1, pojeoPopio.getNaziv());
			izraz.setFloat(2, pojeoPopio.getCijena());
			izraz.setFloat(3, pojeoPopio.getKolicina());
			
			izraz.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void delete(int sifra) {
		PreparedStatement izraz;
		
		try {
			izraz = Baza.getVeza().prepareStatement("delete from pojeoPopio " + " where sifra = ?");
		
		    izraz.setInt(1, sifra);
		    
		    izraz.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static PojeoPopio getPojeoPopio(int redniBroj) {
		int rb = 0;
		for(PojeoPopio p : read()) {
		  
			if(++rb == redniBroj) {
				return p;
			}
		}
		
		return null;
		
	}

}
