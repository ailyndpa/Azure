package Selenium.TestNG;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class day1 {

	@BeforeTest
	public void Demo1() {
		System.out.println("@BeforeTest1");
	}

	@Test(groups= {"Confirmation", "Regression"})
	public void Zemo() {
		System.out.println("Primera prueba en la clase day1");
	}
	
	@Test(groups= {"Regression"}, dependsOnMethods= {"Zemo"}, dataProvider="getData")
	public void SecondTest(String usuario, String Contraseña) {
		System.out.println("1.0" + usuario);
		System.out.println("1.1" + Contraseña);
	}
	
	@Test()
	   public void testcase1(ITestContext testContext){
	      System.out.println("Thread ID: "+Thread.currentThread().getId());
	      int currentCount = testContext.getAllTestMethods()[0].getCurrentInvocationCount();
	      System.out.println("Executing count: " + currentCount);
	   }
	
	@DataProvider
	public Object[][] getData(){
		Object [][] data= new Object[2][2];
		data[0][0]="user1";
		data[0][1]="pass1";
		data[1][0]="user2";
		data[1][1]="pass2";
		return data;
	}

	@AfterTest
	public void lastexecution() {
		System.out.println("@AfterTest day1");
	}

	@AfterSuite
	public void afSyite() {
		System.out.println("@AfterSuite");
	}
}
