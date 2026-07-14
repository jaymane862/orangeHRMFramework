package StepDefinitions;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.utils.WebDriverConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class baseSteps extends WebDriverConfig{
	
	@Given("^.*website is launched successfully and cookies are accepted$")
	public void launch_website() throws Exception {
		
		driver = getDriver();
		driver.get(getSiteUrl());
        actionMethods.waitUntilPageReadyStateIsComplete();
		
	}
	@Then("^.*checks each link present on the page$")
	public void linkStatusCodeCheck() {
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		 System.out.println("Total Number of links: "+links.size());
		 int noOfCount =0;
		 
		 for (WebElement eachLink :links) {
			 String hrefValue = eachLink.getAttribute("href");
			 if(hrefValue == null || hrefValue.isEmpty()) {
				 System.out.println("Href Value is empty");
				 continue;
				 
				 
			 }
			 try{
				 URL url = new URL(hrefValue);
				 HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				 connection.connect();
				 if(connection.getResponseCode()>=400) {
					 System.out.println(hrefValue +" ====> Link is broken");
					 noOfCount++;
				 }
				 else {
					 System.out.println(hrefValue + " ====> Link is not broken");
				 }
			 }
			 catch(Exception e) {
				 
			 }
		 }
		 System.out.println("Number of broken link: "+ noOfCount);
	 }
		
	}


