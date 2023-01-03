package Selenium.TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class day3 {
	@BeforeSuite
	public void Bfsuite() {
		System.out.println("@BeforeSuite");
	}
	@BeforeTest
	public void prerequiste()
	{
		System.out.println("@BeforeTest3");
	}

	@BeforeClass
	public void befoclas() {
		System.out.println("@Beforeclass");
	}

	@BeforeMethod
	public void beforeevery() {
		System.out.println("@BeforeMethod");
	}

	@Test(groups= {"Confirmation", "Regression"})
	public void WebloginCarLoan(){
		System.out.println("Primer test de la clase day3");
	}

	@Test(groups= {"Regression"})
	public void MobileLogincarLoan() {
		System.out.println("segundo test de la clase day3");
	}

	@Test(groups= {"Regression"})
	public void MobilesignimcarLoan() {
		System.out.println("tercer test de la clase day3");
	}

	@AfterMethod
	public void afterevery() {
		System.out.println("@AfterMethod");
	}
	@AfterClass
	public void afteclas() {
		System.out.println("@AfterClass clase3");
	}
	@AfterTest
	public void afterevery2() {
		System.out.println("@AfterTest clase3");
	}

}
