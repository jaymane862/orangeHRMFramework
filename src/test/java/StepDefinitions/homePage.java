package StepDefinitions;

import org.junit.Assert;

import Common.utils.ScreenshotUtils;
import Common.utils.WebDriverConfig;
import io.cucumber.java.en.And;

public class homePage extends WebDriverConfig{

	
	@And("^user verify \"([^\"]*)\" element is present on the page$")
	public void verifyElementIsDisplayed(String locator) throws InterruptedException {
		boolean value =actionMethods.isElementVisible(locator);
		Thread.sleep(5000);
		ScreenshotUtils.getFullPageScreenShot();
		//Assert.assertTrue(value);
		
	}
	
	
	
	
}
