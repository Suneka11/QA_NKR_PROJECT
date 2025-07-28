package com.testNGScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PriorityTNG {
	@Test(priority = -10)
	public void chromebrowser() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(priority = -5)
	public void Urllaunch() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.instagram.com/");
	}

	@Test(priority = 11)
	public void Quit() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.instagram.com/");
		driver.quit();
	}

	@Test
	public void Login() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		WebElement Login = driver.findElement(By.name("login"));
		Login.click();

	}

}
