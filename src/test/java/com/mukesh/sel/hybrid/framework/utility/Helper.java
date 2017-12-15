package com.mukesh.sel.hybrid.framework.utility;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	public static String captureScreenshot(WebDriver driver, String screenshotName) {
		
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String dest = "D:\\LearningAndTraining\\Selenium\\eclipse-oxygen-workspace-02\\com.mukesh.sel.hybrid.framework\\Screenshots\\"+screenshotName+System.currentTimeMillis()+".png";
		
		try {
			FileUtils.copyFile(src, new File(dest));
			
		} catch (Exception e) {
			
			System.out.println("Failed to capture screenshot "+e.getMessage());
		}
		
		return dest;
	}

}
