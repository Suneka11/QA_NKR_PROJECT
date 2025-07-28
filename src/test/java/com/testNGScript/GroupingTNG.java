package com.testNGScript;

import org.testng.annotations.Test;

public class GroupingTNG {
	@Test(groups = "Indoor")
	public void Carrom(){
		System.out.println("Carrom");
	}
	@Test(groups = "Indoor")
	public void Chess(){
		System.out.println("Chess");
	}
	@Test(groups = "Indoor")
	public void TableTennis(){
		System.out.println("Table Tennis");
	}
	@Test(groups = "Outdoor")
	public void Cricket(){
		System.out.println("Cricket");
	}
	@Test(groups = "Outdoor")
	public void Football(){
		System.out.println("Football");
	}
	@Test(groups = "Outdoor")
	public void Golf(){
		System.out.println("Golf");
	}
@Test(groups = "Athelette")
	public void Sprint(){
		System.out.println("Sprint");
	}
	@Test(groups = "Athelette")
	public void Relay(){
		System.out.println("Relay");
	}
	@Test(groups = "Athelette")
	public void Long(){
		System.out.println("Long");
	}
	@Test(groups = "Subject")
	public void Science(){
		System.out.println("Science");
	}
	@Test(groups = "Subject")
	public void Maths(){
		System.out.println("Maths");
	}
	@Test(groups = "Subject")
	public void Tamil(){
		System.out.println("Tamil");
	}
	@Test(groups = "Planets")
	public void Earth(){
		System.out.println("Earth");
	}
	@Test(groups = "Planets")
	public void Mercury(){
		System.out.println("Mercury");
	}
	@Test(groups = "Planets")
	public void Jupiter(){
		System.out.println("Jupiter");
	}
}
