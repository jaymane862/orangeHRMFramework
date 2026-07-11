package Common.utils;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverConfig implements BaseTest{
	
	protected static WebDriver driver =null;
	public static Properties prop;
	public static FileInputStream file;
	private static final String siteUrl = null;
	
	
	
	public static WebDriver getDriver() {
		return driver;
	}

	
	public String getBrowserType() {

	    return System.getProperty(
	            "browserName",
	            prop.getProperty("browserName"));
	}
	
	public String getHeadlessValue() {

	    return System.getProperty(
	            "Headless",
	            prop.getProperty("Headless"));
	}
	
	public String getSiteUrl() {
	    return prop.getProperty("siteUrl");
	}
	
	public String getAppType() {

	    return System.getProperty(
	            "appName",
	            prop.getProperty("appName"));
	}
	
	
	public WebElement getLocator(String key) throws Exception {

	    String locator = fetchLocatorValue(key);

	    return driver.findElement(By.xpath(locator));
	}
	
	
	
	public String fetchLocatorValue(String key) throws Exception {

	    String className = key.split("[.]")[0];
	    String elementName = key.split("[.]")[1];

	    String packageName;

	    if(getAppType().equalsIgnoreCase("WEB"))
	    {
	        packageName = "ObjectRepository.WEB.";
	    }
	    else
	    {
	        packageName = "ObjectRepository.MOBILE.";
	    }
        //Load the class Dynamically
	    Class<?> cls = Class.forName(packageName + className);

	    // Create object
	    Object obj = cls.getDeclaredConstructor().newInstance();

	    // Get findLocator() method
	    Method method = cls.getMethod("findElement", String.class);

	    // Invoke method
	    return (String) method.invoke(obj, elementName);
	}
	
	
	public static void closeDriver() {
		if(null != driver) {
			driver.manage().deleteAllCookies();
			driver.close();
		}
	}
	
	public static void quitDriver() {
		if(null != driver) {
			driver.quit();
		}
	}
	
}
