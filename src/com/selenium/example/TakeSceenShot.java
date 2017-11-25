package com.selenium.example;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TakeSceenShot {

	WebDriver driver;
	By Locator_UserName=By.id("txtUsername");
	By Locator_Password=By.id("txtPassword");
	By Locator_LoginButton=By.id("btnLogin");
	
	
	
	@BeforeTest
	public void setup() throws IOException
	{
		ChromeOptions opt= new ChromeOptions();
		opt.addArguments("--incognito");
		opt.addArguments("--start-maximized");
		driver = new ChromeDriver(opt);
		driver.get("http://opensource.demo.orangehrmlive.com/");
		try {
			TakesScreenshot screen=(TakesScreenshot)driver;
			File src=screen.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./Resources/openbro.png"));
			driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("This is catch block");
		}
		
	}
	@Test
	public void logic() 
	{
		WebElement UserName=driver.findElement(Locator_UserName);
		UserName.sendKeys("admin");
		try {
				TakesScreenshot Screen=(TakesScreenshot)driver;
				File src = Screen.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("./Resources/EnterUserName.png"));
		} catch (Exception e) {
			System.out.println("enter into username catch block");
		}
		WebElement Password=driver.findElement(Locator_Password);
		Password.sendKeys("admin");
		try {
				TakesScreenshot Screen=(TakesScreenshot)driver;
				File src=Screen.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("./Resources/password.png"));
		} catch (Exception e) {
			System.out.println("Enter into password catch block");
		}
		
		WebElement LoginButton=driver.findElement(Locator_LoginButton);
		LoginButton.click();
		try {
			TakesScreenshot Screen= (TakesScreenshot)driver;
			File src=Screen.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./Resources/login.png"));
		} catch (Exception e) {
			System.out.println("enter into login catch block");
		}
		
	}
	@AfterTest
	public void close()
	{
		driver.quit();
	}
}
