package com.testNGScript;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.ReusableMethods.Baseclass;
import com.pageObjectManager.PageObjectManager;

public class FileUpload extends Baseclass {
	@Test
	public void fileupload() throws AWTException {
	
	launchingBrowser("chrome");
	launchingUrl("https://www.ilovepdf.com/pdf_to_word");
	driver.findElement(By.id("pickfiles")).click();
	Robot robot = new Robot();
	robot.delay(2000);
	StringSelection fileLocation = new StringSelection("C:\\Users\\sky\\Downloads\\epfo leo.pdf");
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fileLocation, null);
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	robot.keyPress(KeyEvent.VK_ENTER);
	
	}
}
