package WebAutomation.Functions;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import WebAutomation.DriverSetup.DriverManager;

public class WebActions {

	public static void waitForVisibilityOfAnElement(WebElement ele) {
		FluentWait wait = new FluentWait(DriverManager.getDriver());
		wait.withTimeout(Duration.ofMinutes(2)).pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOf(ele));
	}

	/**
	 * Waits for an element to be clickable
	 * @param ele
	 */

	public static void waitForElementClickable(WebElement ele) {
		FluentWait wait = new FluentWait(DriverManager.getDriver());
		wait.withTimeout(Duration.ofMinutes(2)).pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class).until(ExpectedConditions.elementToBeClickable(ele));
	}

	/**
	 * Waits for an element to be visible
	 * @param element
	 * @param text
	 * @throws InterruptedException 
	 */

	public static void sendHumanKeys(WebElement element, String text) throws InterruptedException {
		Random r = new Random();
		for (int i = 0; i < text.length(); i++) {
			try {
				Thread.sleep((int) (r.nextGaussian() * 20 + 100));
			} catch (InterruptedException e) {
			}
			String s = new StringBuilder().append(text.charAt(i)).toString();
			element.sendKeys(s);
		}
		Thread.sleep(2000);
	}
	
	
	/**
	 * To Click on element
	 * @param ele
	 */
	public static void clickOnElement(WebElement ele) {
		waitForElementClickable(ele);
		ele.click();
	}

	/**
	 * Mouse over on element
	 * @param ele
	 */
	public static void mouseOver(WebElement ele) {
		Actions actions = new Actions(DriverManager.getDriver());
		actions.moveToElement(ele).perform();
	}

}
