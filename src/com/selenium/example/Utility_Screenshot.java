package com.selenium.example;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Utility_Screenshot {
	
	
	public static void ScreenShot(WebDriver driver, String ScreenshotName)
	{
		try {
			TakesScreenshot ts= (TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./Resources/"+ScreenshotName+".png"));
			//FileUtils.copyFile(src, new File("./Resources/"+ScreenshotName+".png"));
			System.out.println("Screen shot taken");
		} catch (Exception e) {
			
			System.out.println("Exception while taking screenshot"+e.getMessage());
		} 
	}

}
