package StepDefinitions;

import Common.utils.WebDriverConfig;
import io.cucumber.java.en.Given;

public class baseSteps extends WebDriverConfig{
	
	@Given("^website is launched successfully and cookies are accepted$")
	public void launch_website() throws Exception {
		
		driver = getDriver();
		driver.get(getSiteUrl());
		
	}

}
