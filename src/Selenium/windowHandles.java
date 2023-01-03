package Selenium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowHandles {

	public static void main(String[] args) {
		
		if (System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver");
		}
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.linkText("Free Access to InterviewQues/ResumeAssistance/Material")).click();

		/*ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
		
		String [] usuario= driver.findElement(By.linkText("mentor@rahulshettyacademy.com")).getText().split("@");
		String usser=usuario[0];
		String correo= driver.findElement(By.linkText("mentor@rahulshettyacademy.com")).getText();
		driver.switchTo().window(tabs2.get(0));
		driver.findElement(By.id("username")).sendKeys(usser);
		driver.findElement(By.id("password")).sendKeys(usser);*/
		
		Set<String> windows= driver.getWindowHandles();
		Iterator<String> it= windows.iterator();
		String parent= it.next();
		String child=it.next();
		driver.switchTo().window(child);
		String [] usuario= driver.findElement(By.linkText("mentor@rahulshettyacademy.com")).getText().split("@");
		String usser=usuario[0];
		driver.switchTo().window(parent);
		driver.findElement(By.id("username")).sendKeys(usser);
		driver.findElement(By.id("password")).sendKeys(usser);
	}

}
