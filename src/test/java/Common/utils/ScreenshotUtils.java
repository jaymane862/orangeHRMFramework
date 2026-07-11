package Common.utils;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotUtils extends WebDriverConfig{

	public static void getFullPageScreenShot() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File targetFile = new File(System.getProperty("user.dir")+"\\screenShots\\new.Png");
        
		srcFile.renameTo(targetFile);
	}
	
	
}
