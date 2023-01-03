package Selenium;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class tarea6Seccion11 {

	public static void main(String[] args) throws InterruptedException {
		if (System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver");
		}
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.qaclickacademy.com/practice.php");
		driver.findElement(By.id("checkBoxOption2")).click();
		String option = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]")).getText();
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select sel = new Select(dropdown);
		sel.selectByVisibleText(option);
		driver.findElement(By.id("name")).sendKeys(option);
		driver.findElement(By.id("alertbtn")).click();
		Alert alerta = driver.switchTo().alert();
		String text = alerta.getText().split(",")[0].split(" ")[1];
		Assert.assertTrue(text.equals(option));
	}
}
