package WebAutomation.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class Home {

	WebDriver driver;

	public Home(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='nav-search-dropdown-card']")
	@Getter
	public WebElement allDropdown;

	@FindBy(xpath = "//*[text()='Electronics']")
	@Getter
	public WebElement electronicsOption;

	@FindBy(xpath = "//*[@id='twotabsearchtextbox']")
	@Getter
	public WebElement searchBox;

	@FindBy(xpath = "//*[@id='nav-search-submit-button']")
	@Getter
	public WebElement searchIconBttn;

	@FindBy(xpath = "(//div[@id='sac-autocomplete-results-container']/div/div)[1]")
	@Getter
	public WebElement suggestionsContainer;

	public List<WebElement> getSuggestionsList() {
		return suggestionsContainer.findElements(By.xpath("//*[contains(@class,'s-suggestion s-suggestion')]"));
	}
	
	

}
