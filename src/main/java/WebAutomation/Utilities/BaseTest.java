package WebAutomation.Utilities;

import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import WebAutomation.DriverSetup.Driver;

/**
 * Used to initialize environment variables and drivers
 */

public class BaseTest {
	
	protected BaseTest() {
	}

	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void setUp(Object[] data) throws Exception {
		Driver.initDriver();
	}

	@AfterMethod
	protected void tearDown() {
		Driver.quitDriver();
	}

}
