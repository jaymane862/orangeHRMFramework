package StepDefinitions;




import Common.utils.BrowserSetup;
import Common.utils.WebDriverConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.File;
import java.io.FileInputStream;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends WebDriverConfig {

	
	private static final Logger logger = LogManager.getLogger(Hooks.class);

	
	@Before
	public void setUp(Scenario scenario) {

	    logger.info("************************* Test Started *************************");

	    prop = new Properties();

	    try {
	        file = new FileInputStream(System.getProperty("user.dir")
	                + "/runConfig.properties");

	        prop.load(file);

	    } catch (Exception e) {
	        System.out.println(e);
	    }

	    BrowserSetup browserSetup = new BrowserSetup();
	    browserSetup.setDriver(getBrowserType());  
	}

	

	@AfterStep
	public void addScreenshot(Scenario scenario) {
		// validate if scenario has failed
		if (scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			File targetFile = new File(System.getProperty("user.dir")+"\\screenShots\\new.Png");
            
			srcFile.renameTo(targetFile);
		}
	}


	@After
	public void tearDown(Scenario scenario) {
	    if (scenario.isFailed()) {
	        logger.info("Test failed. Taking Screenshot");
	        try {
	            String screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BASE64);
	            screenshot = screenshot.replaceAll("[\n\r]", "");
	            byte[] decodedString = Base64.getDecoder().decode(screenshot.getBytes(StandardCharsets.UTF_8));
	            scenario.attach(decodedString, "image/png", "Screenshot added");
	        } catch (Exception e) {
	            logger.warn("Failed to capture screenshot: " + e.getMessage());
	        }
	    }
	    logger.info("************************* Test Completed *************************");
	    if (getDriver() != null) {
	    	
	        driver.quit();
	    }
	}
}

