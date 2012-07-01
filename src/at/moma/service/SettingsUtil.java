package at.moma.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import at.moma.persistence.dao.FileDao;
import at.moma.persistence.dao.IFileDao;

public class SettingsUtil {

	private static String language = "en";
	private static String password;
	private static String username;
	private static String defaultUsername;
	private static IFileDao fileDao = new FileDao("config/settings");
	
	public static void readSettings() throws FileNotFoundException, IOException{
		setLanguage(fileDao.getValue("language"));
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		SettingsUtil.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		SettingsUtil.password = password;
	}

	public static String getLanguage() {
		return language;
	}

	public static void setLanguage(String language) throws IOException {
		SettingsUtil.language = language;
		fileDao.setValue("language", language);
	}

	public static String getDefaultUsername() {
		return defaultUsername;
	}

	public static void setDefaultUsername(String defaultUsername) throws IOException {
		SettingsUtil.defaultUsername = defaultUsername;
		fileDao.setValue("defaultUsername", defaultUsername);
	}
}
