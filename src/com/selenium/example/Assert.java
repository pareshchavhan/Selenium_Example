package com.selenium.example;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.ImplicitlyWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assert {

	WebDriver driver;
	@BeforeTest
	public void setup() 
	{
		driver = new ChromeDriver();
		driver.get("http://opensource.demo.orangehrmlive.com/");
		//System.out.println("This is an right path");
		//Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void maincode()
	{
		
		System.out.println("come into main code");
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin");
		driver.findElement(By.id("btnLogin")).click();
		//assertEquals(driver.getCurrentUrl(), "http://opensource.demo.orangehrmlive.com/index.php/auth/validateCredentials");
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(driver.getCurrentUrl(), "http://opensource.demo.orangehrmlive.com/index.php/auth/validateCredentials");		
		System.out.println("This is an right path");
	}
	@AfterTest
	public void close()
	{
		driver.quit();
	}
}
