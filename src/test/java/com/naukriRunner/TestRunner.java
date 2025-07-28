package com.naukriRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.ReusableMethods.Baseclass;
import com.pageObjectManager.PageObjectManager;
import com.utility.FileReaderManager;

public class TestRunner extends Baseclass {
	@BeforeSuite
	public void browserlaunch() {
		launchingBrowser(PageObjectManager.PageObjectmanager().getFileReaderManager().getDataProperty("browsername"));

	}

	@BeforeClass
	public void Launch() {
		launchingUrl(PageObjectManager.PageObjectmanager().getFileReaderManager().getDataProperty("url"));

	}

	@Test
	public void LoginPage() {
		PageObjectManager.PageObjectmanager().getLoginPageManager().getLoginPage();

	}

	@AfterClass
	public void browserTerminate() throws InterruptedException {
	    Thread.sleep(3000);
	    terminateBrowser(); 
	}
}

