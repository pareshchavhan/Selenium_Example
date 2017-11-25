package com.selenium.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.server.handler.GetTitle;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Window_Handles {

	public WebDriver driver;

	@BeforeTest
	public void setup()
	{
		
		//FirefoxOptions options = new FirefoxOptions();
		//options.addArguments("--start-maximized");
		//System.setProperty("webdriver.ie.driver", "Resurces/IEDriverServer.exe");*/
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		//System.setProperty("webdriver.ie.driver", "Resurces/IEDriverServer.exe");
		//InternetExplorerDriver ie = new InternetExplorerDriver();
		//driver = new InternetExplorerDriver();
		driver = new ChromeDriver(options);
		driver.get("https://www.naukri.com/");
	}
	@Test
	public void mainlogic() throws InterruptedException
	{
		String main_window = driver.getWindowHandle();
		System.out.println("The main window title is " +driver.getTitle());
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows.size());

		for (String i : windows) {

			/*driver.switchTo().window(i);
			String Title = driver.getTitle();
			System.out.println(Title);*/
			driver.switchTo().window(i);
			
			System.out.println(main_window);
			System.out.println("--"+i);
			if(!main_window.equals(i))
			{
				
				System.out.println("The child windoe title is " +driver.getTitle());
				Thread.sleep(2000);
				driver.close();
				Thread.sleep(2000);
			}
		}

		driver.switchTo().window(main_window);
		System.out.println("The parent window title is " +driver.getTitle());
	}
	@AfterTest
	public void close()
	{
		driver.quit();
	}
}
