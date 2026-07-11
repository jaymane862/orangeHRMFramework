package ObjectRepository.WEB;

import java.util.HashMap;
import java.util.Map;

public class homePage {
	
	private static final Map<String,String> homePage;
	static {
		homePage = new HashMap<>();		
		homePage.put("mainSlider", "xpath://*[@class='full-width-slider']");
		homePage.put("nextArrow", "xpath://*[@class='arrw-right']");
		homePage.put("previousArrow", "xpath://*[@class='arrw-left']");
		homePage.put("ribonCenterText", "xpath://*[@class='riboncenter']//h3");
		homePage.put("viewAllBoutiquesText", "xpath://*[@class='off-brand']//span[1]");
		homePage.put("goToTopButton", "xpath://*[@class='goToTop']");
		homePage.put("", "");
		homePage.put("", "");
		homePage.put("", "");
		homePage.put("", "");
		homePage.put("", "");
		homePage.put("", "");
		homePage.put("", "");
		homePage.put("", "");
		homePage.put("", "");
		
	}
	
	public String findElement(String elementName) {
		if(homePage.containsKey(elementName)) {
			return (homePage.get(elementName).trim());
		}
		
		return null;
	}

}
