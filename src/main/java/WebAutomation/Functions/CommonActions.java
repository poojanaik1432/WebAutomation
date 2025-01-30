package WebAutomation.Functions;

import org.openqa.selenium.WebDriver;

import WebAutomation.DriverSetup.DriverManager;
import WebAutomation.Reporter.LogType;
import WebAutomation.Reporter.Reporters;

public class CommonActions {

	public CommonActions(WebDriver driver) {
		// TODO Auto-generated constructor stub
	}

	public void launchAmazon() {
		Reporters.log(LogType.INFO, "Step 1: Open Amazon and search for iPhone 13");
		DriverManager.getDriver().get("https://www.amazon.in/");
		DriverManager.getDriver().manage().window().maximize();
	}

}
