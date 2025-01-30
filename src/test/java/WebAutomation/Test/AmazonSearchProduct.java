package WebAutomation.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import WebAutomation.DriverSetup.DriverManager;
import WebAutomation.Functions.AppleStoreActions;
import WebAutomation.Functions.CommonActions;
import WebAutomation.Functions.HomeActions;
import WebAutomation.Utilities.BaseTest;

public class AmazonSearchProduct extends BaseTest {

	HomeActions homeActions;
	CommonActions commonActions;
	AppleStoreActions appleStoreActions;
	
	@BeforeMethod
	public void init() {
		homeActions = new HomeActions(DriverManager.getDriver());
		commonActions = new CommonActions(DriverManager.getDriver());
		appleStoreActions = new AppleStoreActions(DriverManager.getDriver());
	}

	@Test
	public void amazonSearchAndValidation() throws InterruptedException {
		commonActions.launchAmazon();
		homeActions.searchProductAndVerifySuggestion();
		homeActions.searchProduct();
        appleStoreActions.clickOnAppStoreLink();
        appleStoreActions.selectAppleWatchAndVerifyModal();
	}

}
