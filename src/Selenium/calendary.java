package Selenium;

import java.awt.Dimension;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class calendary {

	public static void main(String[] args) throws InterruptedException {
		if (System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver");
		}
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		/*driver.get("https://www.path2usa.com/travel-companions");
		// April 23
		driver.findElementByXPath(".//*[@id='travel_date']").click();

		while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText()
				.contains("May")) {
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
		}

		List<WebElement> dates = driver.findElements(By.className("day"));
		// Grab common attribute//Put into list and iterate
		int count = driver.findElements(By.className("day")).size();

		for (int i = 0; i < count; i++) {
			String text = driver.findElements(By.className("day")).get(i).getText();
			if (text.equalsIgnoreCase("21")) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}
		}*/

		driver.get("https://www.path2usa.com/travel-companions");
		WebElement date = driver.findElement(By.xpath("//div/label[@for='form-field-travel_comp_date']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", date);
		List<WebElement> dias = driver.findElements(By.className("flatpickr-day"));
		for (int i = 0; i < dias.size(); i++) {
			String a = dias.get(i).getText();
			if (a.equalsIgnoreCase("26")) {
				dias.get(i).click();
				break;
			}

		}
	}

}
