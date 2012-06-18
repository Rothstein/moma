package at.moma.test;

import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;

import at.moma.persistence.h2.H2DbAccess;

public class TestInitializer {
	
	private static String datenbank = "jdbc:h2:db" + File.separator + "testDatabase;CIPHER=AES";
	private static String filePw = "test";
	private static String userPw = filePw;
	private static String username = "test";

	public static void init() throws SQLException{
		H2DbAccess access = H2DbAccess.instance();
		access.setConnection(DriverManager.getConnection(datenbank, username, userPw + " " + filePw));
	}
}
