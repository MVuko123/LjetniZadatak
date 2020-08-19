package vuko.ljetnizadatak;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class CRUDKupac {
	
	public static void create(Kupac kupac) {
		
		try {
			PreparedStatement izraz = Baza.getVeza().
					prepareStatement("Insert into kupac " + 
			" (ime ,prezime, dob ,spol)" + " values ( ?, ? ,? ,?)");
			izraz.setString(1, kupac.getIme());
			izraz.setString(2, kupac.getPrezime());
			izraz.setString(3, kupac.getSpol());
			izraz.setInt(4, kupac.getDob());
			
			izraz.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<Kupac> read() {
		
		List<Kupac> kupci = new ArrayList<>();
		try {
			PreparedStatement izraz = Baza.getVeza().prepareStatement("select * from kupac order by prezime");
		    ResultSet rs = izraz.executeQuery();
		    while(rs.next()) {
		    	kupci.add(new Kupac(rs.getInt("sifra"), rs.getString("ime"), rs.getString("prezime"), rs.getString("spol"), rs.getInt("dob")));
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kupci;
	}
	
	public static void update(Kupac kupac) {
		try {
			PreparedStatement izraz = Baza.getVeza().prepareStatement(
					"update kupac set " + " ime=?, " + " prezime=?, " + " spol=?, " + " dob=? " + " where sifra=? ");
			izraz.setString(1, kupac.getIme());
			izraz.setString(2, kupac.getPrezime());
			izraz.setString(3, kupac.getSpol());
			izraz.setInt(4, kupac.getDob());
			
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
					" delete from kupac  " + "where sifra = ?");
		    izraz.setInt(1, sifra);
		    
		    izraz.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
	
	
	
	public static Kupac getKupac(int redniBroj) {
		int rb = 0;
		for(Kupac k : read()) {
			if(++rb == redniBroj) {
				return k;
			}
		}
		return null;
		
	}
	

}
