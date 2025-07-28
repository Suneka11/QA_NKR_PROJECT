package com.testNGScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class InvocationCountTNG {
	@Test(invocationCount = 4)
	public void instagram() throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.instagram.com/");
		Thread.sleep(2000);
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys("Suneka@gmail.com");
		System.out.println("USERNAME ENTERED SUCCESSFULLY");
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("Sune0512");
		System.out.println("PASSWORD ENTERED SUCCESSFULLY");
		WebElement loginbtn = driver.findElement(By.xpath("//button[@type='submit']"));
		loginbtn.click();
		System.out.println("SUCCESSFULLY LOGGED");
		driver.quit();
	}

}
