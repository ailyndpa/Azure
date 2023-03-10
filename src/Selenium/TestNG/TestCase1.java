package Selenium.TestNG;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class TestCase1 {
	protected WebDriver driver;
	WebElement round_Trip;

	@BeforeTest
	@Parameters({ "URL", "BrowserType" })
	public void beforeTest(String url, String BrowserType) throws Exception {
		switch (BrowserType) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "Edge":
			System.setProperty("webdriver.edge.driver", "./src/resources/msedgedriver.exe");
			driver= new EdgeDriver();
			break;

		case "Firefox":
			System.setProperty("webdriver.gecko.driver", "./src/resources/geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			driver = new FirefoxDriver(options);
			
			break;
		default:
			throw new Exception("Browser" + BrowserType + " not supported");
		}
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test
	public void selectCountry(){
		driver.findElement(By.id("autosuggest")).sendKeys("Ha");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> list = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
																			
		for (WebElement elem : list) {
			if (elem.getText().equalsIgnoreCase("Haiti")) {
				elem.click();
				break;
			}
		}
	}
	@Test
	public void verifRadioButton(){
		WebElement oneWay = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0"));
				round_Trip = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1"));
		round_Trip.click();
		if (oneWay.isSelected()) {
			WebElement Date = driver.findElement(By.xpath("//div/span[@class='date-close-disabled']"));
			Assert.assertTrue(Date.isEnabled(),"Los campos asociados a la fecha deben estar deshabilitados cuando se selecciona la opci??n One Way");
		} else if (round_Trip.isSelected()) {
				WebElement Date = driver.findElement(By.xpath("//div/span[@class='date-close']"));
				Assert.assertTrue(Date.isEnabled(),"Los campos asociados a la fecha deben estar habilitados cuando se selecciona la opci??n Round Trip");
		}
	}
	@Test
	public void fromTo(){
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//a[@value='BLR']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@text='Hubli (HBX)']")).click();
	}

	@AfterClass
	public void After() {
		//driver.close();
	}
}
