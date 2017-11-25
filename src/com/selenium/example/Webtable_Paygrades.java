package com.selenium.example;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Webtable_Paygrades {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options); 
		driver.get("http://opensource.demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
	}
	@Test(priority=1)
	public void manlogic() throws InterruptedException
	{
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin");
		driver.findElement(By.id("btnLogin")).click();

		Thread.sleep(2000);
	}
	@Test(priority=2)
	public void DeletePaygrades() throws InterruptedException
	{
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		WebElement User_Management = driver.findElement(By.xpath("//b[contains(text(),'Admin')]"));
		act.moveToElement(User_Management).build().perform();
		
		User_Management = driver.findElement(By.id("menu_admin_Job")); 
		act.moveToElement(User_Management).build().perform();
		
		User_Management = driver.findElement(By.id("menu_admin_viewPayGrades"));
		act.moveToElement(User_Management).click().build().perform();
		
		List<WebElement> PayGradeRecord = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
		System.out.println("The pay grade records count is " +PayGradeRecord.size());
		
		for(int i=1;i<PayGradeRecord.size();i++)
		{
			WebElement Currency_Pay = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[3]"));
			String Currency=Currency_Pay.getText();
			System.out.println("This is retrive the currency " +Currency);
			
			WebElement PayGrades = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[2]/a"));
			String PayGradeDesignation=PayGrades.getText();
			System.out.println("This is retrive paygrade designation " +PayGradeDesignation);
			
			if(Currency.equals("Indian Rupee") && PayGradeDesignation.equals("paresh"))
			{
				Thread.sleep(2000);
				WebElement Select_Check_Box = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[1]/input"));
				Select_Check_Box.click();
				System.out.println(" Welcome into select check box section ");
				
				Thread.sleep(2000);
				WebElement Delete_Pay_Grade = driver.findElement(By.id("btnDelete"));
				Delete_Pay_Grade.click();
				System.out.println(" Welcome into select delete button section ");
				
				Thread.sleep(2000);
				
				//driver.switchTo().alert().accept();
				WebElement Alert_ok_Button = driver.findElement(By.id("dialogDeleteBtn"));
				Alert_ok_Button.click();
				System.out.println(" Welcome into select alert box section ");
			}
		}
		
		
	}
	@AfterTest
	public void close()
	{
		driver.quit();
	}

}
