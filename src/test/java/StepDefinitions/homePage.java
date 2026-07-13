package StepDefinitions;

import org.junit.Assert;

import Common.utils.ScreenshotUtils;
import Common.utils.WebDriverConfig;
import io.cucumber.java.en.And;

public class homePage extends WebDriverConfig{

	
	@And("^user verify \"([^\"]*)\" element is present on the page$")
	public void verifyElementIsDisplayed(String locator) throws InterruptedException {
		actionMethods.fluentWait(locator);
		boolean value =actionMethods.isElementVisible(locator);
		System.out.println(value);
		Assert.assertFalse("Element not found : "+locator,value);
		
	}
	
	
	
	
}
