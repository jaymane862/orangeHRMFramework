package Common.Helpers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeoutException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.gherkin.model.Scenario;

import Common.utils.WebDriverConfig;

public class ActionMethods extends WebDriverConfig {

	private static final Logger logger = LogManager.getLogger(ActionMethods.class);
	String mainWindow;
	String childWindow;
	Scenario scenario;
	String Value = "value";
	

	public void fluentWait(String locator) {
		Wait <WebDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoreAll(Arrays.asList(NoSuchElementException.class, NoSuchFrameException.class,
						StaleElementReferenceException.class, InvalidElementStateException.class));
		wait.until(d -> isElementVisible(locator));
	}

	public void enterText(String value, String locator) throws Exception {
		if (!(value == null || value.equalsIgnoreCase("skip"))) {
			WebElement elementObj = getLocator(locator);
			elementObj.sendKeys(value.trim());
			logger.info("Text Entered {}", value);
		}
	}

	public void clearText(String locator) throws Exception {
		WebElement elementObj = getLocator(locator);
		elementObj.click();
		elementObj.clear();
	}

	public void click(String locator) throws Exception {
		WebElement elementObj = getLocator(locator);
		elementObj.click();
	}

	public void clickUsingJSExecutor(String locator) throws Exception {
		WebElement elementObj = getLocator(locator);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].click();", elementObj);
	}

	public String getText(String locator) throws Exception {
		String text = getLocator(locator).getText().trim();
		logger.info("Visible text on the page is: " + text);
		return text;
	}

	public void DrawBorderToElement(String locator) throws Exception {
		WebElement elementObj = getLocator(locator);
		((JavascriptExecutor) getDriver()).executeScript(
				"arguments[0].setAttribute('style', 'background: yellow; border: 3px solid red;');", elementObj);
	}

	public void selectValueByText(String name, String locator) throws Exception {
		WebElement elementObj = getLocator(locator);
		Select value = new Select(elementObj);
		value.selectByVisibleText(name);
		value.selectByIndex(8);
		
	}

	public void selectValueByValue(String option, String locator) throws Exception {
		WebElement elementObj = getLocator(locator);
		Select value = new Select(elementObj);
		value.selectByValue(option);
		
	
	}

	public void selectValueByIndex(int index, String locator) throws Exception {
		WebElement elementObj = getLocator(locator);
		Select value = new Select(elementObj);
		value.selectByIndex(index);
	}

	public void clickAndHover(String locator) throws Exception {
		WebElement elementObj = getLocator(locator);
		Actions action = new Actions(driver);
		action.moveToElement(elementObj).click().build().perform();
	}

	public void hoverOnElement(String locator) throws Exception {
		WebElement elementObj = getLocator(locator);
		Actions action = new Actions(driver);
		action.moveToElement(elementObj).build().perform();
	}


	public boolean isElementVisible(String locator) {
		try {
			WebElement elementObj = getLocator(locator);
			return elementObj.isDisplayed();
		} catch (Exception e) {
			 
			return false;
		}
	}

	public void waitForElementToBeEnabled(long sec, String locator) {
		waitUntilPageReadyStateIsComplete();
		Wait<WebDriver> wait = new FluentWait<>(getDriver()).withTimeout(Duration.ofSeconds(sec))
				.pollingEvery(Duration.ofMillis(500))
				.ignoring(NoSuchElementException.class);

		wait.until(d -> isElementEnabled(locator));
	}

	public boolean isElementEnabled(String locator) {
		try {
			WebElement elementObj = getLocator(locator);
			return elementObj.isEnabled();
		} catch (Exception e) {
			return false;
		}
	}

	public void waitUntilPageReadyStateIsComplete() {
		new WebDriverWait(getDriver(), Duration.ofSeconds(60)).until(webDriver -> ((JavascriptExecutor) webDriver)
				.executeScript("return document.readyState").equals("complete"));
	}

	public void scrollDownPage(double VerticalDown) {
		((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0," + VerticalDown + ")");
	}

	public void scrollUpPage(double VerticalUp) {
		VerticalUp = -VerticalUp;
		((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0," + VerticalUp + ")");
	}

	
	public void switchToWindow() {
		mainWindow = getDriver().getWindowHandle();
		for (String handle : getDriver().getWindowHandles()) {
			if (!(handle.equals(mainWindow))) {
				getDriver().switchTo().window(handle);
				logger.info("Switched to child window");
			}
		}
	}

	public void closeChildWindow() {
		for (String handle : getDriver().getWindowHandles()) {
			if (!(handle.equals(mainWindow))) {
				getDriver().close();
			}
		}
		getDriver().switchTo().window(mainWindow);
		logger.info("Successfully redirected to main window");
	}

	

	public void clickLinkText(String locator) throws Exception {
		WebElement elementObj = getDriver().findElement(By.linkText(locator));
		elementObj.click();

	}

	public void sleep(long delay) {
		try {
			Thread.sleep(delay);
		} catch (Exception e) {
			logger.info("Exception occured" + e.getMessage());
			Thread.currentThread().interrupt();
		}
	}

public void scrollToElement(WebElement element) {
		((JavascriptExecutor) actionMethods.getDriver())
				.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	}


}
