package com.selenium.example;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.steadystate.css.util.Output;

public class screenshot_reuse {
 
	

	public static void capture(WebDriver driver, String SchreenShotName){
		try {
			TakesScreenshot screen = (TakesScreenshot)driver;
			File src = screen.getScreenshotAs(OutputType.FILE);
		} catch (Exception e) 
		{
			System.out.println("this is catch block");
		}
		
		
	}
}
