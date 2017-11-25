package com.selenium.example;

import java.io.IOException;
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

public class Webtable {

	WebDriver driver;

	@Test(priority=1)
	public void assertion_softAssertion() throws IOException {

		System.out.println("Positive test");
	
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin");
		driver.findElement(By.id("btnLogin")).click();
	
	}
	
	@BeforeTest
	public void ChromeOptions_HeadlessBrowser() {

		ChromeOptions option=new ChromeOptions();
		option.addArguments("--incognito");
		option.addArguments("--start-maximized");
		System.setProperty("webdriver.chrome.driver", "Resurces/chromedriver.exe");
		driver = new ChromeDriver(option);

		//driver= new HtmlUnitDriver();
		driver.get("http://opensource.demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//pageLoadTimeout(10, TimeUnit.SECONDS);

	}

	@Test(priority=2)
	public void table() throws InterruptedException {

		driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).click();


		List<WebElement> elements= driver.findElements(By.xpath("//div[@id='tableWrapper']/table/tbody/tr"));

		System.out.println(elements.size());


		for (int i = 1; i <elements.size(); i++) {
			List<WebElement>  column=driver.findElements(By.xpath("//div[@id='tableWrapper']/table/tbody/tr["+i+"]/td"));
			System.out.println("--------"+column.size());
			
			WebElement text= driver.findElement(By.xpath("//div[@id='tableWrapper']/table/tbody/tr["+i+"]/td[4]"));
			String name=text.getText();
			
			if (name.equals("Fiona Grace"))
			{
				WebElement checkbox= driver.findElement(By.xpath("//div[@id='tableWrapper']/table/tbody/tr["+i+"]/td[1]/input"));
				checkbox.click();
				
				driver.findElement(By.xpath("//input[@id='btnDelete']")).click();
				
			}
		}

	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
