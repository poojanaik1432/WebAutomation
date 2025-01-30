package WebAutomation.Reporter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.Assert;

import WebAutomation.Reporter.LogType;

public final class Reporters {

	private static String getTimestamp() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return formatter.format(date) + " :: ";
	}

	public static void assertTrue(boolean condition, String description) {
		try {
			Assert.assertTrue(condition, description);
		} catch (AssertionError var3) {
			ExtentLogger.log(LogType.FAIL, "Assert True - " + description);
			ExtentLogger.log(LogType.FAIL, ExceptionUtils.getStackTrace(var3));
			Assert.fail(description);
		}
		ExtentLogger.log(LogType.PASS, getTimestamp() + "Assert True - " + description);

	}

	public static void assertFalse(boolean condition, String description) {
		try {
			Assert.assertFalse(condition, description);
		} catch (AssertionError var3) {
			ExtentLogger.log(LogType.FAIL, "Assert False - " + description);
			ExtentLogger.log(LogType.FAIL, ExceptionUtils.getStackTrace(var3));
			Assert.fail(description);
		}
		ExtentLogger.log(LogType.PASS, getTimestamp() + "Assert False - " + description);
	}

	public static void assertEquals(Object value1, Object value2, String description) {
		try {
			Assert.assertEquals(value1, value2, description);
		} catch (AssertionError var4) {
			ExtentLogger.log(LogType.FAIL, "Assert Equals - " + description);
			ExtentLogger.log(LogType.FAIL, ExceptionUtils.getStackTrace(var4));
			Assert.fail(description);
		}
		ExtentLogger.log(LogType.PASS, getTimestamp() + "Assert Equals - " + description);
	}

	public static void assertNotEquals(Object value1, Object value2, String description) {
		try {
			Assert.assertNotEquals(value1, value2, description);
		} catch (AssertionError var4) {
			ExtentLogger.log(LogType.FAIL, "Assert Not Equals - " + description);
			ExtentLogger.log(LogType.FAIL, ExceptionUtils.getStackTrace(var4));
			Assert.fail(description);
		}
		ExtentLogger.log(LogType.PASS, getTimestamp() + "Assert Not Equals - " + description);
	}

	public static void assertGreaterThanZero(int value) {
		try {
			Assert.assertTrue(value > 0);
		} catch (AssertionError var2) {
			ExtentLogger.log(LogType.FAIL, "Assert Greater Than Zero - " + value);
			ExtentLogger.log(LogType.FAIL, ExceptionUtils.getStackTrace(var2));
			Assert.fail("Assert " + value + " is greater than zero");
		}
		ExtentLogger.log(LogType.PASS,
				getTimestamp() + "Assert Greater Than Zero - Assert " + value + " is greater than zero");
	}

	public static void assertNull(Object condition, String description) {
		try {
			Assert.assertNull(condition, description);
		} catch (AssertionError var3) {
			ExtentLogger.log(LogType.FAIL, "Assert Null - " + description);
			ExtentLogger.log(LogType.FAIL, ExceptionUtils.getStackTrace(var3));
			Assert.fail(description);
		}
		ExtentLogger.log(LogType.PASS, getTimestamp() + "Assert Null - " + description);
	}

	public static void assertNotNull(Object condition, String description) {
		try {
			Assert.assertNotNull(condition, description);
		} catch (AssertionError var3) {
			ExtentLogger.log(LogType.FAIL, "Assert Not Null - " + description);
			ExtentLogger.log(LogType.FAIL, ExceptionUtils.getStackTrace(var3));
			Assert.fail(description);
		}
		ExtentLogger.log(LogType.PASS, getTimestamp() + "Assert Not Null - " + description);
	}

	public static void log(LogType arg, String description) {
		ExtentLogger.log(arg, description);
	}

}