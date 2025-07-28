package com.testNGScript;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SimpleAnnotations {
	
	
	//stcm before
	
	@BeforeSuite
	public void browsersetup() {
		System.out.println("BROWSER SETUP IS DONE");
	}
	
	
	@BeforeTest
	public void url() {
		System.out.println("URL LAUNCHED SUCCESS");
	}
	
	@BeforeClass
	public void screenshot() {
		System.out.println("Screenshot before");
	}
	
	
	@BeforeMethod
	public void login() {
		System.out.println("LOGIN");
	}
	
	
	
	@Test
	public void mensproduct() {
		System.out.println("MENS PRODUCT");
		
	}
	
	@Test
	public void womensproduct() {
		System.out.println("WOMENS PRODUCT");
		
	}
	
	@Test
	public void kidsproduct() {
		System.out.println("KIDS PRODUCT");
		
	}
	 
	
	@AfterMethod
	public void logout() {
		System.out.println("LOGOUT");
	}
	
	@AfterClass
	public void homepage() {
		System.out.println("Homepage");
	}
	
	@AfterTest
	public void screenshot2() {
		System.out.println("Screenshot after logout ");
	}
	@AfterSuite
	public void terminate() {
		System.out.println("Terminate");
	}

}
