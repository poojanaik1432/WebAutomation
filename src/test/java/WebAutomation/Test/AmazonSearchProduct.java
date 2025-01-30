package WebAutomation.Test;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import WebAutomation.DriverSetup.DriverManager;
import WebAutomation.Functions.WebActions;
import WebAutomation.PageObjects.*;
import WebAutomation.Reporter.LogType;
import WebAutomation.Reporter.Reporters;
import WebAutomation.Utilities.BaseTest;

public class AmazonSearchProduct extends BaseTest {

	Home homePage;
	AppleStore appleStorePage;
	Product productPage;

	@BeforeMethod
	public void init() {
		homePage = new Home(DriverManager.getDriver());
		appleStorePage = new AppleStore(DriverManager.getDriver());
		productPage = new Product(DriverManager.getDriver());
	}

	@Test
	public void amazonSearchAndValidation() throws InterruptedException {

		Reporters.log(LogType.INFO,"Step 1: Open Amazon and search for iPhone 13");
		DriverManager.getDriver().get("https://www.amazon.in/");
		DriverManager.getDriver().manage().window().maximize();

		WebActions.clickOnElement(homePage.allDropdown);
		WebActions.clickOnElement(homePage.electronicsOption);
		WebActions.sendHumanKeys(homePage.searchBox, "IPhone 13");
		
		
		Reporters.log(LogType.INFO,"Step 2: Validate all dropdown suggestions are related to iPhone 13");

		// Fetch all the individual suggestion elements
		WebActions.waitForVisibilityOfAnElement(homePage.suggestionsContainer);
		List<WebElement> suggestions = homePage.getSuggestionsList();

		for (WebElement suggestion : suggestions) {
			String suggestionValue = suggestion.getText().toLowerCase();
			Reporters.assertTrue(suggestionValue.contains("iphone 13"), "Suggestion is expected to contain iphone 13 and actual: "+suggestionValue);
		}

		
		Reporters.log(LogType.INFO, "Step 3: Search for specific variant");
		homePage.searchBox.clear();
		WebActions.sendHumanKeys(homePage.searchBox, "Apple iPhone 12 Pro Max 256GB");

		WebActions.clickOnElement(homePage.searchIconBttn);

		Reporters.log(LogType.INFO,"Step 4: Click on the first product and validate new tab is opened");
		WebActions.waitForVisibilityOfAnElement(productPage.searchedProduct);
		WebActions.clickOnElement(productPage.searchedProduct);

		Reporters.log(LogType.INFO,"Switch to new tab");
        String originalTab = DriverManager.getDriver().getWindowHandle();
        for (String windowHandle : DriverManager.getDriver().getWindowHandles()) {
            if (!windowHandle.equals(originalTab)) {
            	DriverManager.getDriver().switchTo().window(windowHandle);
            }
        }

        Reporters.log(LogType.INFO,"Step 5: Visit Apple Store");
		WebActions.clickOnElement(appleStorePage.appleStoreLink);

		
		Reporters.log(LogType.INFO, "Step 6: Select Apple Watch variant");
		
		((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				appleStorePage.appleWatchDropdown);
		WebActions.clickOnElement(appleStorePage.appleWatchDropdown);
		WebActions.clickOnElement(appleStorePage.seGpsCellularOption);

		
		Reporters.log(LogType.INFO,"Step 8: Verify modal corresponds to the same product");

		String expectedProductDetail = appleStorePage.appleWatchFirstOption.getAttribute("title");

		
		Reporters.log(LogType.INFO,"Step 7: Hover over the watch image and verify Quick Look");

		WebActions.mouseOver(appleStorePage.watchImage);
		Reporters.assertTrue(appleStorePage.quickLookText.isDisplayed(), "Validate Quick Look option is displayed exptected: True actual: "+appleStorePage.quickLookText.isDisplayed());
		WebActions.clickOnElement(appleStorePage.quickLookText);

		String actualProductDetails = appleStorePage.productDetailOnQuickLook.getAttribute("title");
		Reporters.assertTrue(expectedProductDetail.contains(actualProductDetails),
				"Validate modal does not show the correct product expected: True actual: "+expectedProductDetail.contains(actualProductDetails));

	}

}
