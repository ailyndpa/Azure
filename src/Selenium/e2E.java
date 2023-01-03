package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class e2E {

	public static void main(String[] args) throws InterruptedException {

		if (System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver");
		}
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		// SELECCIONAR COUNTRY
		driver.findElement(By.id("autosuggest")).sendKeys("Ha");
		Thread.sleep(4000);
		List<WebElement> list = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
																	
		for (WebElement elem : list) {
			if (elem.getText().equalsIgnoreCase("Haiti")) {
				elem.click();
				break;
			}
		}
		
		// VERIFI RADIO BUTTON
		WebElement oneWay = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0"));
		WebElement round_Trip = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1"));
		round_Trip.click();
		if (oneWay.isSelected()) {
			WebElement Date = driver.findElement(By.xpath("//div/span[@class='date-close-disabled']"));
			Assert.assertTrue(Date.isEnabled(),"Los campos asociados a la fecha deben estar deshabilitados cuando se selecciona la opción One Way");
		} else if (round_Trip.isSelected()) {
			WebElement Date = driver.findElement(By.xpath("//div/span[@class='date-close']"));
			Assert.assertTrue(Date.isEnabled(),"Los campos asociados a la fecha deben estar habilitados cuando se selecciona la opción Round Trip");
			}
		
		// SELECCIONAR DESDE HASTA
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//a[@value='BLR']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@text='Hubli (HBX)']")).click();
												
		// SPECIFY DATE1
		driver.findElement(By.xpath("//td[contains(@class,'today')]")).click();
		Thread.sleep(2000);
		
		// SPECIFY DATE2
		if (round_Trip.isSelected()) {
		driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
		// SELECCIONANDO UNA FECHA X(fila=5; posicion=4)
		driver.findElement(By.xpath("//div[contains(@class,'first')]/table/tbody/tr[5]/td[4]")).click();
		}
		// SELECCIONAR PASAJEROS
		// RF1 solo permite adicionar 5 adultos, 2 niños y 1 infantil
		WebElement pasajeros = driver.findElement(By.id("divpaxinfo"));
		pasajeros.click();
		Thread.sleep(5000);
		for (int i = 1; i < 5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		for (int j = 0; j < 2; j++) {
			driver.findElement(By.id("hrefIncChd")).click();
		}
		driver.findElement(By.id("hrefIncInf")).click();
	
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertTrue(pasajeros.getText().equals("5 Adult, 2 Child, 1 Infant"),"Se esperaba que fueran 5 adultos, 2 niños y 1 infantil");
	
		// SELECCIONAR DIVISA
		WebElement currency = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropDown = new Select(currency);
		dropDown.selectByIndex(0);
		Assert.assertTrue(dropDown.getFirstSelectedOption().getText().equalsIgnoreCase("select"),"El valor que se selecciona en Currency no es select");
		dropDown.selectByVisibleText("USD");
		Assert.assertEquals(dropDown.getFirstSelectedOption().getText(), "USD");
		dropDown.selectByValue("AED");
		Assert.assertTrue(dropDown.getFirstSelectedOption().getText().equals("AED"),"El valor que se selecciona en Currency no es AED");
		
		// SELECCIONAR checkbox
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected(),"No esta seleccionado el checkbox  Family and Friends");

		// COUNT NUMBER CHECKBOX
		List<WebElement> checkboxs = driver.findElements(By.xpath("//input[@type='checkbox']"));
		Assert.assertEquals(checkboxs.size(), 6);
		
		//CLICK SOBRE EL BOTON SEARCH
		WebElement search=driver.findElement(By.id("ctl00_mainContent_btn_FindFlights"));
		search.click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("QAClickJet - Flight Booking for Domestic and International, Cheap Air Tickets"), "El titulo de la pagina no es el esperado");
		driver.close();
	}

}
