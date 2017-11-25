package com.selenium.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertBoxex {

	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		//System.setProperty("", "Resurces/chromedriver.exe");
		 driver = new ChromeDriver();
		driver.get("http://output.jsbin.com/usidix/1");
	}
	@Test
	public void logic()
	{
		driver.findElement(By.xpath("//input[@value='Go!']")).click();
		String str=driver.switchTo().alert().getText();
		System.out.println(str);
		driver.switchTo().alert().accept();
	}
	@AfterTest
	public void close()
	{
		driver.quit();
	}
}
