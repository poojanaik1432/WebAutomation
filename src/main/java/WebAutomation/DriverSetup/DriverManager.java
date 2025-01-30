package WebAutomation.DriverSetup;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
	
	/**
	 * 
	 * Private constructor to avoid external Instantiation.
	 */
	private DriverManager() {

	}

	private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

	/**
	 * 
	 * 
	 * @return Thread safe {@link org.openqa.selenium.WebDriver} instance fetched
	 *         from ThreadLocal variable.
	 */
	public static WebDriver getDriver() {
		return dr.get();
	}

	/**
	 * Set the webDriver instance to ThreadLocal variable.
	 * 
	 * @param driverref {@link org.openqa.selenium.WebDriver} instance that needs to
	 *                  saved from Thread safety issues.
	 * 
	 */
	 static void setDriver(WebDriver driverref) {
		if (Objects.nonNull(driverref)) {
			dr.set(driverref);
		}

	}

	/**
	 * Calling remove method on ThreadLocal variable that ensures to set the default
	 * value to ThreadLocal variable.
	 */
	static void unload() {
		dr.remove();
	}


}
