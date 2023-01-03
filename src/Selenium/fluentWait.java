package Selenium;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class fluentWait {
	public static void main(String[] args) {
		if (System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver");
		}
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.cssSelector("div button")).click();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		
		wait.until(new Function<WebDriver, WebElement>() {
			WebElement elemento= driver.findElement(By.cssSelector("div[id='finish'] h4"));
		     public WebElement apply(WebDriver driver) {
		    	 if(elemento.isDisplayed()) {
		    		 return elemento;
		    	 }	
		    	 else {
		    		 return null;
		    	 }
		    	 
		     }
		   });
		Assert.assertTrue(driver.findElement(By.cssSelector("div[id='finish'] h4")).getText().equalsIgnoreCase("Hello World!"));
	}
}
