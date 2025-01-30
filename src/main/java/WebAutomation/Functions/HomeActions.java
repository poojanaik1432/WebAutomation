package WebAutomation.Functions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import WebAutomation.DriverSetup.DriverManager;
import WebAutomation.PageObjects.Home;
import WebAutomation.PageObjects.Product;
import WebAutomation.Reporter.LogType;
import WebAutomation.Reporter.Reporters;

public class HomeActions {

	Home homePage = new Home(DriverManager.getDriver());
	Product productPage = new Product(DriverManager.getDriver());
	public HomeActions(WebDriver driver) {
		// TODO Auto-generated constructor stub
	}

	public void searchProductAndVerifySuggestion() throws InterruptedException {
		WebActions.clickOnElement(homePage.allDropdown);
		WebActions.clickOnElement(homePage.electronicsOption);
		WebActions.sendHumanKeys(homePage.searchBox, "IPhone 13");
		Reporters.log(LogType.INFO, "Step 2: Validate all dropdown suggestions are related to iPhone 13");

		// Fetch all the individual suggestion elements
		WebActions.waitForVisibilityOfAnElement(homePage.suggestionsContainer);
		List<WebElement> suggestions = homePage.getSuggestionsList();

		for (WebElement suggestion : suggestions) {
			String suggestionValue = suggestion.getText().toLowerCase();
			Reporters.assertTrue(suggestionValue.contains("iphone 13"),
					"Suggestion is expected to contain iphone 13 and actual: " + suggestionValue);
		}

	}

	public void searchProduct() throws InterruptedException {
		Reporters.log(LogType.INFO, "Step 3: Search for specific variant");
		homePage.searchBox.clear();
		WebActions.sendHumanKeys(homePage.searchBox, "Apple iPhone 12 Pro Max 256GB");

		WebActions.clickOnElement(homePage.searchIconBttn);

		Reporters.log(LogType.INFO, "Step 4: Click on the first product and validate new tab is opened");
		WebActions.waitForVisibilityOfAnElement(productPage.searchedProduct);
		WebActions.clickOnElement(productPage.searchedProduct);

		Reporters.log(LogType.INFO, "Switch to new tab");
		String originalTab = DriverManager.getDriver().getWindowHandle();
		for (String windowHandle : DriverManager.getDriver().getWindowHandles()) {
			if (!windowHandle.equals(originalTab)) {
				DriverManager.getDriver().switchTo().window(windowHandle);
			}
		}
	}

}
