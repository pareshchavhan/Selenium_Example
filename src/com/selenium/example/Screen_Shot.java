package com.selenium.example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Screen_Shot {

	public WebDriver driver;

	@BeforeTest
	public void setup()
	{
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--start--maximized");
		driver = new ChromeDriver(opt);
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
	}
	@Test
	public void sceenshot()
	{
		screenshot_reuse.capture(driver, "Browser opend");
	}
	@AfterTest
	public void close()
	{
		driver.quit();
	}
}
