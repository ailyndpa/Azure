package Selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class tarea8 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//input[@class='inputs ui-autocomplete-input']")).sendKeys("uni");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		List<WebElement> list = driver.findElements(By.xpath("//ul/li[@class='ui-menu-item']"));
		for (int i = 0; i < list.size(); i++) {
					
			if (list.get(i).getText().equalsIgnoreCase("United States (USA)")) {
				list.get(i).click();
			}
		}

	}

}
