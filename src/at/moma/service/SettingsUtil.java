package at.moma.service;

public class SettingsUtil {

	private static String password;
	private static String username;

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
}
