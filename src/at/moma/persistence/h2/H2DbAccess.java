package at.moma.persistence.h2;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import at.moma.persistence.IDbAccess;
import at.moma.service.SettingsUtil;

public class H2DbAccess implements IDbAccess {
	
	private static H2DbAccess instance = null;
	private static Logger log = Logger.getLogger(H2DbAccess.class);
	
	private String datenbank = "jdbc:h2:db" + File.separator + "database;CIPHER=AES";
	private String filePw = SettingsUtil.getPassword();
	private String userPw = filePw;
	private String username = SettingsUtil.getUsername();
	private Connection connection = null;
	
	public static synchronized H2DbAccess instance(){
		if(instance==null){
			instance = new H2DbAccess();
			log.info("create new instance");
		}
		log.debug("return instance");
		return instance;
	}
	
	private H2DbAccess(){};
    
	@Override
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		if(connection==null){
			connection = DriverManager.getConnection(datenbank, username, userPw + " " + filePw);
			log.info("establish connection to the H2 database: " + datenbank + "for user: " + username);
		}
		log.debug("get connection to h2 db");
		return connection;
	}

	@Override
	public void closeConnection() throws SQLException {
		if(connection!=null){
			connection.close();
			connection = null;
			log.info("connection closed");
		}
	}

}
