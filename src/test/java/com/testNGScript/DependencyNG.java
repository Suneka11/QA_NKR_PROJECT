package com.testNGScript;
import org.testng.annotations.Test;

public class DependencyNG {
	@Test(priority = -5)
	public void Study() {
		System.out.println("Study");
	}
	@Test(dependsOnMethods = "Job")
	public void Money() {
		System.out.println("Money");
	}
	@Test
	public void Job() {
		System.out.println("Job");
	}
	@Test(priority = 2)
	public void Life() {
		System.out.println("Life");
	}
	@Test(dependsOnMethods = "Money")
	public void Love() {
		System.out.println("Love");
	}
	

}
