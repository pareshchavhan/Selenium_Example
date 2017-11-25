package com.selenium.example;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Close_Naukri_Alert {

	WebDriver driver;

	@BeforeTest
	public void setup()
	{
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--start--maximized");
		driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().timeouts().implicitlyWait(04, TimeUnit.SECONDS);
	}

	@Test
	public void popup() throws InterruptedException
	{
		String main_window = driver.getWindowHandle();
		System.out.println("The Title of the main window " +driver.getTitle());

		Set<String> child_windows = driver.getWindowHandles();


		int size = child_windows.size();
		System.out.println("The size of childs windows are " +size);

		for (String childs : child_windows) 

		{
			driver.switchTo().window(childs);
			System.out.println("The Title of all childs windows are " +driver.getTitle());

			if(!main_window.equals(childs))
			{
				Thread.sleep(2000);
				driver.close();
			}
		}
		driver.switchTo().window(main_window);
		System.out.println("The main window titl is " +driver.getTitle());

		WebElement View_Recruters = driver.findElement(By.xpath("//button[contains(text(),'View Recruiters')]"));
		View_Recruters.click();
		
		Set<String> child1 = driver.getWindowHandles();
		for (String nextchild : child1) {
			driver.switchTo().window(nextchild);
			System.out.println("The another child window is " +driver.getTitle());
			
			if(!main_window.equals(nextchild))
			{
				Thread.sleep(2000);
				driver.close();
			}
		}
		driver.switchTo().window(main_window);
		//driver.switchTo().defaultContent();
		System.out.println("The title is " +driver.getTitle());
		
	}

	@AfterTest
	public void closecon()
	{
		driver.quit();
	}
}
