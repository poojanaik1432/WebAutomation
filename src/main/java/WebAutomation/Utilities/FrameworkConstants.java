package WebAutomation.Utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class FrameworkConstants {

	private FrameworkConstants() {
	}

	/* CONSTANTS DEFINED FOR GETTING FILES FROM RESOURCES FOLDER */
	private static final String BASE_PATH = System.getProperty("user.dir");
	private static final String EXTENT_REPORT_FOLDER_PATH = BASE_PATH + "/test-output/extentReport/";
	private static String extentReportFilePath = "";

	/*
	 * METHOD TO CREATE EXTENT REPORT HTML FILE.
	 */
	public static String getExtentReportFolderPath() {

		/* GETS THE CURRENT DATE AND TIME FROM DATEUTIL CLASS FROM UTIL PACKAGE */
		String newDateTimeFormat = getCurrentDateTime();
		return EXTENT_REPORT_FOLDER_PATH + "/extent_report.html";
		//return EXTENT_REPORT_FOLDER_PATH + newDateTimeFormat + "/extent_report.html";
	}

	/* METHOD TO RETURN EXTENT REPORT FILE PATH. */
	public static String getExtentReportFilePath() {
		if (extentReportFilePath.isEmpty()) {
			extentReportFilePath = getExtentReportFolderPath();
		}
		return extentReportFilePath;
	}

	public static String getCurrentDateTime() {
		String timeInMillis = String.valueOf(System.currentTimeMillis());
		long x = Long.parseLong(timeInMillis);

		Date date = new Date(x);
		DateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss_aa");
		String newDateTimeFormat = formatter.format(date);
		return newDateTimeFormat;

	}

}
