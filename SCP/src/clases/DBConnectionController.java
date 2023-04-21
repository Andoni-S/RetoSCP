package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import exceptions.CreateException;

public class DBConnectionController {
	
	private ResourceBundle configFile;
	private String url;
	private String user;
	private String pass;

	
	public DBConnectionController(){
		configFile = ResourceBundle.getBundle("model.config");
		url = configFile.getString("URL");
		user = configFile.getString("USER");
		pass = configFile.getString("PASSWORD");
	}
	
	public Connection openConnection() /*throws SQLException*/ {
		Connection con= null;
		try {
			con = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
		//System.out.println("Error al intentar abrir la BD");
		//Gestión de la excepción
		//throw new CreateException(e.getMessage());
		}
		return con;
	}
	public void closeConnection(PreparedStatement stmt, Connection con) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
