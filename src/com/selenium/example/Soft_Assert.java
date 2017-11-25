package com.selenium.example;

import static org.testng.Assert.assertEquals;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Soft_Assert {

	WebDriver driver;
	String Username=null;
	String Password=null;
	
	@BeforeTest
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://opensource.demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void code() throws ClassNotFoundException, InterruptedException, SQLException
	{
		Database data = new Database(driver);
		String[] user=data.database();		
				
		driver.findElement(By.id("txtUsername")).sendKeys(user[0]);
		System.out.println(user[0]);
		driver.findElement(By.id("txtPassword")).sendKeys(user[1]);
		System.out.println(user[1]);
		driver.findElement(By.id("btnLogin")).click();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(driver.getCurrentUrl(), "http://opensource.demo.orangehrmlive.com/","expected is not match with actual");
		System.out.println("This is follow a path");
		
		soft.assertAll();
	}
	@AfterTest
	public void close()
	{
		driver.quit();
	}
}
