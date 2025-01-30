package WebAutomation.DriverSetup;

import java.util.Objects;

public final class Driver {
	
	/**
	 * 
	 * Private constructor to avoid external Instantiation.
	 */
	private Driver() {

	}

	/**
	 * @param browser value will be passed from
	 *                {@link WebAutomation.Utilities.BaseTest}. Values can be
	 *                firefox and chrome.
	 * 
	 * @param version value will be passed from
	 *                {@link WebAutomation.Utilities.BaseTest}. Values will be
	 *                based on browser version
	 * @throws Exception 
	 */
	public static void initDriver() throws Exception {

		if (Objects.isNull(DriverManager.getDriver())) {

			try {
				DriverManager.setDriver(DriverFactory.getDriver());
			} catch (Exception e) {
				throw new Exception("Browser invocation failed. Please check the capabilities.");
			}

		}
	}

	/**
	 * quitDriver method to Close, Delete the browser cookies and unload it from
	 * DriverManager Class.
	 * 
	 */
	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().manage().deleteAllCookies();
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}

	}

}
