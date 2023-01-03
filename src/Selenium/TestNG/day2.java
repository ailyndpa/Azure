package Selenium.TestNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class day2 {
	@BeforeTest
	public void prerequiste()
	{
		System.out.println("@BeforeTest2");
	}
	@BeforeMethod
	public void prerequiste2()
	{
		System.out.println("@BeforeMethod");
	}
	@Test(groups= {"Confirmation", "Regression"})
	public void ploan()
	{
		System.out.println("Primera prueba de la clase day2");
	}
	@Test(groups= {"Regression"})
	public void ploan2()
	{
		System.out.println("Segunda prueba de la clase day2");
	}
	@AfterTest
	public void ploan22()
	{
		System.out.println("@AfterTest day2");
	}
	
}
