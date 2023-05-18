
package DBImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import exceptions.ServerException;

/**
 * The DBConnectionController class is responsible for managing the database
 * connection.
 */
public class DBConnectionController {
	private ResourceBundle configFile;
	private String url;
	private String user;
	private String pass;

	/**
	 * Constructs a new DBConnectionController object.
	 */
	public DBConnectionController() {
		configFile = ResourceBundle.getBundle("model.config");
		url = configFile.getString("URL");
		user = configFile.getString("USER");
		pass = configFile.getString("PASSWORD");
	}

	/**
	 * Opens a new database connection.
	 *
	 * @return the opened Connection object
	 * @throws ServerException if an error occurs while opening the connection
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
	 * Closes the database connection and the PreparedStatement.
	 *
	 * @param stmt the PreparedStatement to close
	 * @param con  the Connection to close
	 * @throws ServerException if an error occurs while closing the connection
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
