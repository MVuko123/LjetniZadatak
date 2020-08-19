package vuko.ljetnizadatak;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CRUDProjekcija {
	
	public static void create(Projekcija projekcija) {
		
		try {
			PreparedStatement izraz = Baza.getVeza().prepareStatement("Insert into projekcija " + " (film, datum)" + "values (?,?)");
		    izraz.setInt(1, projekcija.getFilm());
		    izraz.setFloat(2, projekcija.getDatum());
		    
		   izraz.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static List<Projekcija> read(){
		List<Projekcija> projekcije = new ArrayList<>();
		
		try {
			PreparedStatement izraz = Baza.getVeza().prepareStatement("select * from projekcija order by datum");
		
		    ResultSet rs= izraz.executeQuery();
		while(rs.next()) {
			projekcije.add(new Projekcija(rs.getInt("sifra"), rs.getInt("film"), rs.getFloat("datum")));
		}
		rs.close();
		izraz.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return projekcije;
	}
	
	public static void update(Projekcija projekcija) {
		
		try {
			PreparedStatement izraz = Baza.getVeza().prepareStatement(
					"update projekcija set " + " film = ?, " + " datum = ?");
			izraz.setInt(1, projekcija.getFilm());
		    izraz.setFloat(2, projekcija.getDatum());
		    
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
					" delete from projekcija " + " where sifra = ?");
		izraz.setInt(1, sifra);
		
		izraz.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Projekcija getProjekcija(int redniBroj) {
		int rb = 0;
		for(Projekcija p : read()) {
			if(++rb == redniBroj) {
				return p;
			}
		}
		return null;
	}

}
