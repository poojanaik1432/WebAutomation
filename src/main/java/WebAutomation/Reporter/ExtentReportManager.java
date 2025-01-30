package WebAutomation.Reporter;

import com.aventstack.extentreports.ExtentTest;

public class ExtentReportManager {

	private ExtentReportManager() {
	}

	private static final ThreadLocal<ExtentTest> EXTENT_TEST = new ThreadLocal<>();

	public static ExtentTest getExtentTest() {
		return EXTENT_TEST.get();
	}

	public static void setExtentTest(ExtentTest extentTest) {
		EXTENT_TEST.set(extentTest);
	}

	public static void unload() {
		EXTENT_TEST.remove();
	}

	public static void consolePrint(String message) {
		System.out.println(message);
	}

}
