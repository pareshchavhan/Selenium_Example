package com.selenium.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Webtable_Hrm_Delete {

	public WebDriver driver;
	@BeforeTest
	public void setup()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options); 
		driver.get("https://www.w3schools.com/");
	}
	@Test
	public void maincode()
	{
		
	}
	@AfterTest
	public void close()
	{
		
	}
}
