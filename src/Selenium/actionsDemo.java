package Selenium;

import java.io.File;
//import java.awt.RenderingHints.Key;
//import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {

	public static void main(String[] args) throws IOException {
		if (System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", "./src/resources/geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", "./src/resources/geckodriver");
		}
		
		PROBANDO
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/gp/css/homepage.html/ref=nav_bb_ya");
		Actions mouse=new Actions(driver);
		WebElement acountAndList= driver.findElement(By.id("nav-link-accountList"));
		mouse.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("ailyn").doubleClick().build().perform();
		mouse.moveToElement(acountAndList).contextClick().build().perform();
		File foto=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(foto, new File("C:/Users/adelpino.CHF/git/2-ocutubre/test-output/Failed suite [Suite]/lily1.jpeg"));
	}

}
