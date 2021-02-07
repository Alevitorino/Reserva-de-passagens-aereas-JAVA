package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexoes {
	public Connection getConnection() {
		try {	
			return DriverManager.getConnection("jdbc:mysql://localhost/reservadepassagens", "root", "");
		} catch	(SQLException e) {
			throw new RuntimeException();
			}
		}
}
