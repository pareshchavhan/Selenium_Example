package com.selenium.example;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Handle_Frames {

	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--incognito");
		opt.addArguments("--start-maximized");
		driver=new ChromeDriver(opt);
		driver.get("http://seleniumhq.github.io/selenium/docs/api/java/index.html");

		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
	}
	@Test
	public void logic() throws InterruptedException
	{
		List<WebElement> FrameCout= driver.findElements(By.tagName("frame"));
		System.out.println("The no of frame in html page is " +FrameCout.size());
		//driver.switchTo().defaultContent();
		//frame1
		Thread.sleep(5000);
		try {
			WebElement frame1 = driver.findElement(By.xpath("//frame[@src='overview-frame.html'][@name='packageListFrame']"));
			driver.switchTo().frame(frame1);
			//String Frame1_Title=frame1.getText();
			//System.out.println("The text of First Frame is " +Frame1_Title);
		} catch (Exception e) {
			System.out.println("This is first frame catch block ");
		}


		WebElement Frame1_condition=driver.findElement(By.xpath("//a[@href='com/thoughtworks/selenium/condition/package-frame.html']"));
		Frame1_condition.click();

		driver.switchTo().defaultContent();

		//frame2
		WebElement Frame2 = driver.findElement(By.xpath("//a[@href='org/openqa/selenium/support/AbstractFindByBuilder.html']"));
		driver.switchTo().frame(Frame2);
	}
	@AfterTest
	public void close()
	{
		driver.quit();
	}
}
