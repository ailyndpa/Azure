package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class tarea7 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://qaclickacademy.com/");
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']/li[5]")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,650)");
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='left-align']//tr"));
		List<WebElement> columns = driver.findElements(By.xpath("//div[@class='left-align']//tr/th"));
		System.out.println("Number of rows in the table: " + rows.size());
		System.out.println("number of columns in the table: " + columns.size());
		List<WebElement> secondRow = driver.findElements(By.xpath("//div[@class='left-align']//tr[3]/td"));
		for (int i = 0; i < secondRow.size(); i++) {
			System.out.println("values of the second row: " + secondRow.get(i).getText());
		}
		
	}
}
