package at.moma.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.*;

import at.moma.persistence.IDbAccess;
import at.moma.persistence.h2.H2DbAccess;
/**
 * This class contains the main class.
 * 
 * @author stefan
 *
 */
public class Moma {

	private static Level logLevel = Level.INFO;
	private static Logger log = Logger.getRootLogger();
	
	/**
	 * configures the logger
	 * 
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		configureLogger();
		log.info("Logger set up");
		
		IDbAccess dbAccess = H2DbAccess.instance();
		Connection con = dbAccess.getConnection();
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
