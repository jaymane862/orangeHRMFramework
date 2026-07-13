package StepDefinitions;

import Common.utils.BrowserSetup;
import Common.utils.WebDriverConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
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

	
	@After
	public void tearDown(Scenario scenario) {
	    if (scenario.isFailed()) {
	        logger.info("Test failed. Taking Screenshot");
	        try {
	            File source = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
	            String screenshotName = scenario.getName().replace(" ", "_") + ".png";

	            File destination = new File(
	                    System.getProperty("user.dir")
	                    + "/target/test-output/screenshots/"
	                    + screenshotName);

	            destination.getParentFile().mkdirs();

	            Files.copy(source.toPath(), destination.toPath(),
	                    StandardCopyOption.REPLACE_EXISTING);

	            scenario.attach(
	                    Files.readAllBytes(destination.toPath()),
	                    "image/png",
	                    screenshotName);
	        }
	        catch(IOException e) {
	            logger.error("Unable to capture screenshot", e);
	        	
	        }
	        
	    }
	    logger.info("************************* Test Completed *************************");
	    if (getDriver() != null) {
	    	
	        driver.quit();
	    }
	}
}


