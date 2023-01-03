package Selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class alertas {

	public static void main(String[] args) throws InterruptedException {
		if (System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver");
		}
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys("Ailyn");
		driver.findElement(By.id("alertbtn")).click();
		Alert alerta= driver.switchTo().alert();
		Assert.assertTrue(alerta.getText().equals("Hello Ailyn, share this practice page and share your knowledge"), "La alerta no tiene el texto que se esperaba");
		alerta.accept();
		driver.findElement(By.id("confirmbtn")).click();
		Assert.assertTrue(alerta.getText().equals("Hello , Are you sure you want to confirm?"), "La alerta confirm no tiene el texto que se esperaba");
		alerta.dismiss();
		
	}

}
