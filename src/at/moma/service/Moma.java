package at.moma.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.*;

import at.moma.persistence.DbAccessException;
import at.moma.persistence.DbAccessFactory;
import at.moma.persistence.IDbAccess;
/**
 * This class contains the main class.
 * 
 * @author stefan
 *
 */
public class Moma {

	private static Level logLevel = Level.DEBUG;
	private static Logger log = Logger.getRootLogger();
	
	/**
	 * configures the logger
	 * 
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		//configure logger
		configureLogger();
		log.info("Logger set up");
		
		//read the application configuration
		log.info("Configure application");
		SettingsUtil.readSettings();
		
		//TODO: Login oder neuen Benutzer anlegen
		
		MessageService mService = MessageService.instance();
		System.out.println(mService.getMessage("username"));
		System.out.println(mService.getMessage("passwort"));
		
		SettingsUtil.setLanguage("en");
		
		//user PW
		SettingsUtil.setPassword("test");
		SettingsUtil.setUsername("test");
		//TODO: http://www.h2database.com/html/advanced.html#passwords
		
		//connect db and close db
		IDbAccess dbAccess = null;
		try {
			dbAccess = DbAccessFactory.getDbAccess("h2");
		} catch (DbAccessException e) {
			e.printStackTrace();
		}
		Connection con = dbAccess.getConnection();
		dbAccess.closeConnection();
	}
	
	/**
	 * configures the Logger
	 */
	private static void configureLogger(){
		Layout layout = new PatternLayout("%d{ISO8601} %-5p [%t] %c: %m%n");
		Appender appender = new ConsoleAppender(layout);
		log.addAppender(appender);
		log.setLevel(logLevel);
	}
}
