package com.testNGScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTNG {
	@Test(dataProvider = "DataSet1")
	public void instagram(String userData, String passData) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.instagram.com/");
		Thread.sleep(3000);
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(userData);
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys(passData);
		WebElement loginbtn = driver.findElement(By.xpath("//button[@type='submit']"));
		loginbtn.click();
		driver.quit();
	}

	@DataProvider(name = "DataSet1")
	public Object[][] testDataSet1() {
		return new Object[][]
				{ { "sune", "12345" },
			{ "Karthick", "S1234" }, 
			{ "YUTHRA", "LK1234" },
			{ "SKY", "SKY1234" },

		};
	}

}
