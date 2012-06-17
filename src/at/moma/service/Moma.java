package at.moma.service;

import org.apache.log4j.*;
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
	 */
	public static void main(String[] args) {
		configureLogger();
		log.info("Logger set up");
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
