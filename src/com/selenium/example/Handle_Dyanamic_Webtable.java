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

public class Handle_Dyanamic_Webtable {

	public WebDriver driver;
	@BeforeTest
	public void setup()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options); 
		driver.get("http://opensource.demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test(priority=1)
	public void maincode() throws InterruptedException
	{
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin");
		driver.findElement(By.id("btnLogin")).click();

		Thread.sleep(2000);

	}
	@Test(priority=2)
	public void deleteuser() throws InterruptedException
	{
		System.out.println("Welcome into adminuser");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement AdminClick = driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']"));
		AdminClick.click();



		List<WebElement> Records = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
		System.out.println("The size of records is " +Records.size());

		for(int i=1;i<Records.size();i++)
		{
			System.out.println("Welcome into for loop");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			WebElement EmpName = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[4]"));
			String Employee_Name = EmpName.getText();
			//System.out.println(Employee_Name);

			WebElement UserName = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[2]/a"));
			String User_Name = UserName.getText();
			//System.out.println(User_Name);

			if(Employee_Name.equals("Steven Edwards") && User_Name.equals("steven.edwards"))
			{
				WebElement CheckBox = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[1]/input"));
				CheckBox.click();

				WebElement Click_Delete_Button = driver.findElement(By.xpath("//input[@id='btnDelete']"));
				Click_Delete_Button.click();
				
				Thread.sleep(2000);

				WebElement Accept_OK_Button = driver.findElement(By.xpath("//input[@id='dialogDeleteBtn']"));
				Accept_OK_Button.click();
			}
		}
	}
	@AfterTest
	public void close()
	{
		driver.quit();
	}
}
