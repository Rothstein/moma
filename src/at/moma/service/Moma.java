package at.moma.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.*;

import at.moma.persistence.DbAccessException;
import at.moma.persistence.DbAccessFactory;
import at.moma.persistence.IDbAccess;
import at.moma.persistence.dao.FileDao;
import at.moma.persistence.dao.IFileDao;
import at.moma.persistence.h2.H2DbAccess;
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
		configureLogger();
		log.info("Logger set up");
		
		IFileDao fileDao = new FileDao("config/settings");
		System.out.println(fileDao.getValue("language"));
		System.out.println(fileDao.getValue("version"));
		fileDao.setValue("version", "0.1");
		fileDao.setValue("language", "en");
		
		//user PW
		SettingsUtil.setPassword("test");
		SettingsUtil.setUsername("test");
		//TODO: http://www.h2database.com/html/advanced.html#passwords
		
		//connect db and close db
		IDbAccess dbAccess = null;
		try {
			dbAccess = DbAccessFactory.getDbAccess("h2");
		} catch (DbAccessException e) {
			// TODO Auto-generated catch block
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
