package vuko.ljetnizadatak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//POJO

public class Baza {

	private static Connection veza;

	public static Connection getVeza() {
		if (veza == null) {
			try {
				Class.forName("org.mariadb.jdbc.Driver");
				veza = DriverManager.getConnection("jdbc:mariadb://localhost/edunovajp22", "edunova", "edunova");
			} catch (ClassNotFoundException | SQLException e) {

			}
		}
		return veza;
	}
	
	public static void zatvoriVezu() {
		try {
			veza.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
