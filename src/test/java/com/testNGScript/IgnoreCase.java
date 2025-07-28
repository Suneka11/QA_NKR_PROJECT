package com.testNGScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class IgnoreCase {
	@Test
	@Ignore
	public void chromebrowser() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.instagram.com/");
	System.out.println("BrowserID:  "+Thread.currentThread().getId());
	Thread.sleep(2000);
	driver.quit();
	}
	
	
	@Test(enabled= true)
	public void edgeBrowser() throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
	System.out.println("BrowserID:  "+Thread.currentThread().getId());
	Thread.sleep(2000);
	driver.quit();
	}
	
	
	@Test
	public void fireFoxBrowser() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	System.out.println("BrowserID:  "+Thread.currentThread().getId());
	Thread.sleep(2000);
	driver.quit();
	}
	
	
	
}

	


