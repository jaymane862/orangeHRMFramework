package ObjectRepository.WEB;

import java.util.HashMap;
import java.util.Map;

public class homePage {
	
	private static final Map<String,String> homePage;
	static {
		homePage = new HashMap<>();	
		homePage.put("companyLogo","xpath://*[@alt='company-branding']");
		homePage.put("loginText", "xpath://*[contains(@class,'orangehrm-login-title')]");
		homePage.put("demoCredentails", "xpath://*[contains(@class,'orangehrm-demo-credentials')]");
		homePage.put("userNameIcon", "xpath:(//*[contains(@class,'label-icon')])[1]");
		homePage.put("usernameText", "xpath:(//*[@class='oxd-label'])[1]");
		homePage.put("userNameInputField", "xpath://*[@name='username']");
		homePage.put("passwordIcon", "xpath:(//*[contains(@class,'label-icon')])[2]");
		homePage.put("passwordText", "xpath:(//*[@class='oxd-label'])[2]");
		homePage.put("passwordInputField", "xpath://*[@name='password']");
		homePage.put("loginButton", "xpath://*[contains(@class,'orangehrm-login-button')]");
		homePage.put("forgotPasswordLink", "xpath://*[contains(@class,'orangehrm-login-forgot-header')]");
		homePage.put("footerElement", "xpath:(//*[contains(@class,'orangehrm-login-footer')])[1]");
		homePage.put("footerSocialMediaLinks", "xpath:(//*[contains(@class,'orangehrm-login-footer')])[1]");
		
		
	}
	
	public String findElement(String elementName) {
		if(homePage.containsKey(elementName)) {
			return (homePage.get(elementName).trim());
		}
		
		return null;
	}

}
