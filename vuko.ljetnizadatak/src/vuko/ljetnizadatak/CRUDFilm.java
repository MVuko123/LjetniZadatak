package vuko.ljetnizadatak;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDFilm {
	
	public static void create(Film film) {
		
		try {
			PreparedStatement izraz = Baza.getVeza().prepareStatement("Insert into film " + " (naziv, redatelj, godina, ocjena)");
		izraz.setString(1, film.getNaziv());
		izraz.setString(2, film.getRedatelj());
		izraz.setInt(3, film.getGodina());
		izraz.setFloat(4, film.getOcjena());
		
		izraz.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<Film> read(){
		List<Film> filmovi = new ArrayList<>();
			
		try {
			PreparedStatement izraz = Baza.getVeza().prepareStatement(" select * from film order by ocjena");
		    ResultSet rs = izraz.executeQuery();
		    while(rs.next()) {
		    	filmovi.add(new Film(rs.getInt("sifra"), rs.getString("naziv"), rs.getString("redatelj"), rs.getInt("godina"), rs.getFloat("ocjena")));
		    }
		    rs.close();
		    izraz.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filmovi;
	}
	
	public static void update(Film film) {
		try {
			PreparedStatement izraz = Baza.getVeza().prepareStatement("update film set " + " naziv = ?," + " redatelj = ?," + " godina = ?," + " ocjena = ?");
			izraz.setString(1, film.getNaziv());
			izraz.setString(2, film.getRedatelj());
			izraz.setInt(3, film.getGodina());
			izraz.setFloat(4, film.getOcjena());
			
			izraz.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void delete(int sifra) {
		PreparedStatement izraz;
		
		try {
			izraz = Baza.getVeza().prepareStatement("delete from film " + " where sifra = ?");
		
		    izraz.setInt(1, sifra);
		    
		    izraz.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Film getFilm(int redniBroj) {
		int rb = 0;
		for(Film f : read()) {
			if(++rb == redniBroj) {
				return f;
			}
		}
		return null;
	}

}
