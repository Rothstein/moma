package at.moma.persistence;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDbAccess {

	/**
	 * This method returns a connection object to a database.
	 * 
	 * @return Connection
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Connection getConnection() throws SQLException, ClassNotFoundException;
	
	/**
	 * This method coloses all connections to the database.
	 * @throws SQLException 
	 */
	public void closeConnection() throws SQLException;
}
