package com.testNGScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionTNG {
	@Test
    public void chromebrowser() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        Thread.sleep(2000);

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("TestPilot@");

        WebElement password = driver.findElement(By.name("pass")); // corrected name
        password.sendKeys("TestPilot@");

        WebElement login = driver.findElement(By.name("login"));
        
        // SoftAssert
        SoftAssert softassert = new SoftAssert();
        String actualPassword = password.getAttribute("value"); // get value instead of getText
        softassert.assertEquals(actualPassword, "TestPilot@", "Password mismatch!");

        login.click();
        
        softassert.assertAll(); // required to trigger all soft assertions

        driver.quit();
    
}
}
