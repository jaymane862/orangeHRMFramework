package Common.utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserSetup extends WebDriverConfig{
	
	public void setDriver(String browserName) {
		switch(browserName.toLowerCase()) {
		case "chrome":
			
			if(getHeadlessValue().equalsIgnoreCase("true")) {
				ChromeOptions chromeOption = new ChromeOptions();
				chromeOption.addArguments("--headless");
				
				driver = new ChromeDriver(chromeOption);
			}
			else{
				driver = new ChromeDriver();
			}
			setBrowserWindowSize();
			break;
			
		case "firefox":
			if(getHeadlessValue().equalsIgnoreCase("ture")) {
				FirefoxOptions fireFoxOption = new FirefoxOptions();
				fireFoxOption.addArguments("--headless");
				driver = new FirefoxDriver(fireFoxOption);
			}
			else {
				driver = new FirefoxDriver();
			}
			setBrowserWindowSize();
			break;
			
		case "edge":
			if(getHeadlessValue().equalsIgnoreCase("true")) {
				EdgeOptions edgeOption = new EdgeOptions();
				edgeOption.addArguments("--headless");
				driver = new EdgeDriver(edgeOption);
			}
			else {
				driver = new EdgeDriver();
			}
			setBrowserWindowSize();
		    break;
	}
	
	}
	public void setBrowserWindowSize() {
		getDriver().manage().window().maximize();
	}

}
