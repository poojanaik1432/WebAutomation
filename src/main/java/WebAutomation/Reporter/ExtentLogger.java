package WebAutomation.Reporter;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Consumer;

import WebAutomation.Reporter.LogType;

public final class ExtentLogger {

	private static final Consumer<String> LOG = ExtentReportManager::consolePrint;

	/* LOGS MESSAGES ONLY TO EXTENT REPORT */
	private static final Consumer<String> PASS_EXTENT = message -> ExtentReportManager.getExtentTest().pass(message);
	private static final Consumer<String> FAIL_EXTENT = message -> ExtentReportManager.getExtentTest().fail(message);
	private static final Consumer<String> SKIP_EXTENT = message -> ExtentReportManager.getExtentTest().skip(message);
	private static final Consumer<String> INFO_EXTENT = message -> ExtentReportManager.getExtentTest().info(message);

	/* LOGS MESSAGES TO CONSOLE AND EXTENT REPORT */
	private static final Consumer<String> PASS_EXTENT_AND_LOG = PASS_EXTENT.andThen(LOG);
	private static final Consumer<String> FAIL_EXTENT_AND_LOG = FAIL_EXTENT.andThen(LOG);
	private static final Consumer<String> SKIP_EXTENT_AND_LOG = SKIP_EXTENT.andThen(LOG);
	private static final Consumer<String> INFO_EXTENT_AND_LOG = INFO_EXTENT.andThen(LOG);

	private static final Map<LogType, Consumer<String>> MAP = new EnumMap<>(LogType.class);

	static {
		MAP.put(LogType.PASS, PASS_EXTENT);
		MAP.put(LogType.FAIL, FAIL_EXTENT);
		MAP.put(LogType.SKIP, SKIP_EXTENT);
		MAP.put(LogType.INFO, INFO_EXTENT);

		MAP.put(LogType.PASS_EXTENT_AND_LOG, PASS_EXTENT_AND_LOG);
		MAP.put(LogType.FAIL_EXTENT_AND_LOG, FAIL_EXTENT_AND_LOG);
		MAP.put(LogType.SKIP_EXTENT_AND_LOG, SKIP_EXTENT_AND_LOG);
		MAP.put(LogType.INFO_EXTENT_AND_LOG, INFO_EXTENT_AND_LOG);

	}

	public static void pass(String message) {
		ExtentReportManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentReportManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {
		ExtentReportManager.getExtentTest().skip(message);
	}

	public static void info(String message) {
		ExtentReportManager.getExtentTest().info(message);
	}

	public static void log(LogType status, String message) {
		MAP.get(status).accept(message);
	}
}
