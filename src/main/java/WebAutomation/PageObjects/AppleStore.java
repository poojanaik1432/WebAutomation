package WebAutomation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class AppleStore {

	WebDriver driver;

	public AppleStore(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Visit the Apple Store']")
	@Getter
	public WebElement appleStoreLink;

	@FindBy(xpath = "(//span[text()='Apple Watch'])[1]/..")
	@Getter
	public WebElement appleWatchDropdown;

	@FindBy(xpath = "//*[text()='Apple Watch SE (GPS + Cellular)']/..")
	@Getter
	public WebElement seGpsCellularOption;

	@FindBy(xpath = "(//*[@data-testid='observer']/a)[1]")
	@Getter
	public WebElement appleWatchFirstOption;
	
	@FindBy(xpath = "//*[@class='EditorialTileProduct__image__M1rM1']")
	@Getter
	public WebElement watchImage;
	
	@FindBy(xpath = "//span[text()='Quick look']")
	@Getter
	public WebElement quickLookText;
	
	@FindBy(xpath = "//*[@id='asin-title']/a")
	@Getter
	public WebElement productDetailOnQuickLook;
	
}
