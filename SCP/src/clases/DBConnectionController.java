package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import exceptions.ServerException;

/**
 * This class is used to connect with the database
 */
public class DBConnectionController {
	private ResourceBundle configFile;
	private String url;
	private String user;
	private String pass;

	/**
	 * Constructs a new DBConnectionController object. Initializes the configuration
	 * file and retrieves the connection details from the file.
	 */

	public DBConnectionController() {
		configFile = ResourceBundle.getBundle("model.config");
		url = configFile.getString("URL");
		user = configFile.getString("USER");
		pass = configFile.getString("PASSWORD");
	}

	/**
	 * Opens a connection to the database.
	 *
	 * @return The opened database connection.
	 * @throws ServerException if an error occurs while establishing the connection.
	 */

	public Connection openConnection() throws ServerException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			throw new ServerException(e.getMessage());
		}
		return con;
	}

	/**
	 * Closes the provided prepared statement and database connection.
	 *
	 * @param stmt The prepared statement to close.
	 * @param con  The database connection to close.
	 * @throws ServerException if an error occurs while closing the statement or
	 *                         connection.
	 */

	public void closeConnection(PreparedStatement stmt, Connection con) throws ServerException {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				throw new ServerException(e.getMessage());
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				throw new ServerException(e.getMessage());
			}
		}
	}
}
