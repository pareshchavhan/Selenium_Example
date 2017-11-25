package com.selenium.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HnadleAlert_Boxex {

	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "Resurces/chromedriver.exe");
		driver = new ChromeDriver();
	   driver.manage().window().maximize();
	    driver.get("https://www.ksrtc.in/oprs-web/");
	    
	    
	    Thread.sleep(2000);
		
		
		driver.findElement(By.id("searchBtn")).click();
		//Alert alt=driver.switchTo().alert();
		String text=driver.switchTo().alert().getText();
		System.out.println("The Alrt messege is" +text);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		//alt.accept();
		Thread.sleep(2000);
		
		driver.quit();
	}
}
