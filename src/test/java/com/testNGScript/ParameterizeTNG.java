package com.testNGScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizeTNG {
	@Test
	@Parameters({"username","pass"})
	public void instagram(String userData ,String passData) {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.instagram.com/");
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(userData);
		System.out.println("USERNAME ENTERED SUCCESSFULLY");
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys(passData);
		System.out.println("PASSWORD ENTERED SUCCESSFULLY");
		WebElement element = driver.findElement(By.xpath("//button[@type='submit']"));
		element.click();
		driver.quit();
	}

}
