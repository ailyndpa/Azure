package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class certificados {

	public static void main(String[] args) {
		if (System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver");
		}
		ChromeOptions option= new ChromeOptions();		
		option.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(option);
		
		driver.manage().window().maximize();
		driver.get("https://expire.badssl.com/");
		System.out.println(driver.getTitle());
	}

}
