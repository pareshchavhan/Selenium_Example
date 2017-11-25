package com.selenium.example;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Window_handle_5th_nov_2017 {
	
	WebDriver driver;
      
	@BeforeTest
	public void Setup()
	{
	     driver= new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.get("https://www.naukri.com/");
	}
	
	@Test
	public void Logic()
	{
		String main_Window = driver.getWindowHandle();
		
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows.size());
		for (String abc : windows) {
			
			driver.switchTo().window(abc);
			System.out.println("Title of the page: "+driver.getTitle());
		}
		
	}
	@AfterTest
	public void Close()
	{
		driver.quit();
	}
}
