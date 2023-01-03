package Selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class codigosEstado {

	public static void main(String[] args) throws MalformedURLException, IOException {
		if (System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver");
		}
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		List<WebElement> lista = footer.findElements(By.tagName("a"));
		SoftAssert s = new SoftAssert();
		for (int i = 0; i < lista.size(); i++) {
			String url = lista.get(i).getAttribute("href");
			HttpURLConnection conection = (HttpURLConnection) new URL(url).openConnection();
			// conection.setRequestMethod("GET");
			// conection.connect();
			int code = conection.getResponseCode();
			System.out.println("CODIGO>>>>" + code);
			s.assertTrue(code < 400, "El enlace '" + lista.get(i).getText() + "' esta roto");
		}
		s.assertAll();
	}
}
