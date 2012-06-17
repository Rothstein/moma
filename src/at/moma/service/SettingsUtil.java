package at.moma.service;

public class SettingsUtil {

	private static String filePw;

	public static String getFilePw() {
		return filePw;
	}

	public static void setFilePw(String filePw) {
		SettingsUtil.filePw = filePw;
	}
}
