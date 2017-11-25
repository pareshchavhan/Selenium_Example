package com.selenium.example;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Take_Screenshot {

	public static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "Resurces/chromedriver.exe");
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		Utility_Screenshot.ScreenShot(driver,"BrowesrOpen");
		
		driver.findElement(By.id("email")).sendKeys("pareshnit@gmail.com");
		Utility_Screenshot.ScreenShot(driver, "Enter_User_Name");
		driver.findElement(By.id("pass")).sendKeys("chavhanp");
		Utility_Screenshot.ScreenShot(driver, "Enter_Password");
		Thread.sleep(2000);
		//driver.findElement(By.id("loginbutton")).click();
		
		
		driver.quit();
	}
}
