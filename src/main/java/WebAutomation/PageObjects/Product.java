package WebAutomation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class Product {
	
	WebDriver driver;

	public Product(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//h2[contains(@aria-label, 'iPhone 12 Pro Max')])[1]")
	@Getter
	public WebElement searchedProduct;
}
