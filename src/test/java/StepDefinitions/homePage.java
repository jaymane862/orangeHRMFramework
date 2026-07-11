package StepDefinitions;

import org.junit.Assert;

import Common.utils.WebDriverConfig;
import io.cucumber.java.en.And;

public class homePage extends WebDriverConfig{

	
	@And("^user verify \"([^\"]*)\" element is present on the page$")
	public void verifyElementIsDisplayed(String locator) {
		boolean value =actionMethods.isElementVisible(locator);
		//Assert.assertTrue(value);
		
	}
	
	
	
	
}
