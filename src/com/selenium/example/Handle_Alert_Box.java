package com.selenium.example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Handle_Alert_Box {

	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		ChromeOptions chr = new ChromeOptions();
		chr.addArguments("--maximized --chrome browser");
		driver = new ChromeDriver();
		driver.get("http://output.jsbin.com/usidix/1");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@Test
	public void logic() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@value='Go!']")).click();
		Thread.sleep(2000);
		Alert alt= driver.switchTo().alert();
		String str = alt.getText();
		System.out.println(str);
		alt.accept();
	}
	@AfterTest
	public void close()
	{
		driver.quit();
	} 
}
