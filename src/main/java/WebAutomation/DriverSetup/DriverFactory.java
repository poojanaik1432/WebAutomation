package WebAutomation.DriverSetup;

import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

	public static WebDriver getDriver() throws Exception {

		WebDriver driver = null;
		String driverPath = Paths.get("src", "resources", "chromedriver.exe").toAbsolutePath().toString();
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
		
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver(options);
		return driver;

	}

}