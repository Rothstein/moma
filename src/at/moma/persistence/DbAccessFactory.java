package at.moma.persistence;

import org.apache.log4j.Logger;

import at.moma.persistence.h2.H2DbAccess;

public class DbAccessFactory {
	
	private static Logger log = Logger.getLogger(DbAccessFactory.class);
	
	/**
	 * This method returns IDbAccess objects specified by their name.
	 * 
	 * @param db
	 * @return IDbAccess
	 * @throws DbAccessException
	 */
	public static IDbAccess getDbAccess(String db) throws DbAccessException{
		if(db.equals("h2")){
			log.debug("return a concrete IDbAccess object for a " + db + " database");
			return H2DbAccess.instance();
		}
		log.debug("there is no implementation for a " + db + " database");
		throw new DbAccessException("database: " + db + " not available");
	}
}
