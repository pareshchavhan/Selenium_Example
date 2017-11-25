package com.selenium.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames_Selenium {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "F://Paresh//Seleniam//SeleniamAutomation//Selenium_Example//Resurces//chromedriver.exe");	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumhq.github.io/selenium/docs/api/java/index.html");

		
		Thread.sleep(5000);
		
		//---Frame 1----------
				WebElement fisrtFrame= driver.findElement(By.xpath("//frame[@src='overview-frame.html'][@name='packageListFrame']"));
				driver.switchTo().frame(fisrtFrame);
				driver.findElement(By.xpath("//a[text()='com.thoughtworks.selenium.condition']")).click();
				
				
				driver.switchTo().defaultContent();
				
				//-------Frame 2----
				WebElement frame2= driver.findElement(By.xpath("//frame[@src='allclasses-frame.html'][@name='packageFrame']"));
				driver.switchTo().frame(frame2);
				driver.findElement(By.xpath("//a[text()='Condition']")).click();
		
		//*********frame 1**********
		/*WebElement frame1=driver.findElement(By.xpath("//frame[@src='overview-frame.html']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//a[@href='com/thoughtworks/selenium/package-frame.html']")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		//***********frame 2*********
		
		WebElement frame2=driver.findElement(By.xpath("//frame[@src='allclasses-frame.html']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//a[@href='org/openqa/selenium/remote/http/AbstractHttpCommandCodec.CommandSpec.html']")).click();
		//driver.findElement(By.xpath("//a[contains(text(),'AbstractHttpCommandCodec.CommandSpec')]")).click();
*/	}

}
