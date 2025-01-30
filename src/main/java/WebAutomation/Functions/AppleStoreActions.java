package WebAutomation.Functions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import WebAutomation.DriverSetup.DriverManager;
import WebAutomation.PageObjects.AppleStore;
import WebAutomation.Reporter.LogType;
import WebAutomation.Reporter.Reporters;

public class AppleStoreActions {

	AppleStore appleStorePage = new AppleStore(DriverManager.getDriver());

	public AppleStoreActions(WebDriver driver) {
		// TODO Auto-generated constructor stub
	}

	public void clickOnAppStoreLink() throws InterruptedException {
		Reporters.log(LogType.INFO, "Step 5: Visit Apple Store");
		WebActions.clickOnElement(appleStorePage.appleStoreLink);
	}

	public void selectAppleWatchAndVerifyModal() {
		Reporters.log(LogType.INFO, "Step 6: Select Apple Watch variant");
		((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				appleStorePage.appleWatchDropdown);
		WebActions.clickOnElement(appleStorePage.appleWatchDropdown);
		WebActions.clickOnElement(appleStorePage.seGpsCellularOption);

		String expectedProductDetail = appleStorePage.appleWatchFirstOption.getAttribute("title");

		Reporters.log(LogType.INFO, "Step 7: Hover over the watch image and verify Quick Look");
		WebActions.mouseOver(appleStorePage.watchImage);
		Reporters.assertTrue(appleStorePage.quickLookText.isDisplayed(),
				"Validate Quick Look option is displayed exptected: True actual: "
						+ appleStorePage.quickLookText.isDisplayed());
		WebActions.clickOnElement(appleStorePage.quickLookText);

		Reporters.log(LogType.INFO, "Step 8: Verify modal corresponds to the same product");
		String actualProductDetails = appleStorePage.productDetailOnQuickLook.getAttribute("title");
		Reporters.assertTrue(expectedProductDetail.contains(actualProductDetails),
				"Validate modal does not show the correct product expected: True actual: "
						+ expectedProductDetail.contains(actualProductDetails));

	}
}
