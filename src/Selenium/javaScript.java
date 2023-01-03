package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class javaScript {

	public static void main(String[] args) {
		if (System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver");
		}
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,500)");
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=2000");
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='tableFixHead']//td[4]"));
		int suma = 0;
		for (int i = 0; i < list.size(); i++) {
			suma += Integer.parseInt(list.get(i).getText());
		}
		String totalAmount=driver.findElement(By.xpath("//div[@class='totalAmount']")).getText();
		int valor=Integer.parseInt(totalAmount.split(":")[1].trim());
		Assert.assertEquals(valor, suma);
		
		List<WebElement> list2 = driver.findElements(By.xpath("//div[@class='left-align']//td[3]"));
		int sum=0;
		for(WebElement actual: list2) {
			sum+=Integer.parseInt(actual.getText());
		}
		Assert.assertEquals(sum, 235);
	}

}
