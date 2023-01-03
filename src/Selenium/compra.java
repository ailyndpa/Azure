package Selenium;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class compra {

	public static void main(String[] args) throws InterruptedException {

		if (System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver");
		}
		String[] productAdd = { "Cucumber", "Brocolli", "Beans" };
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		addProducto(driver, productAdd);
		payProducto(driver);
		// driver.close();

	}

	public static void addProducto(WebDriver driver, String[] productAdd) {

		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));
		int j = 0;
		for (int i = 0; i < products.size(); i++) {
			String namesProduct[] = products.get(i).getText().split("-");
			String nameProduct = namesProduct[0].trim();// el metodo trim elimina los espacios en blanco
			List productAddList = Arrays.asList(productAdd);// CONVIERTE EL ARREGLO A UNA LISTA

			if (productAddList.contains(nameProduct)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				j++;

				if (j == productAddList.size()) {
					break;
				}
			}

		}		 
	}
	
	public static void payProducto(WebDriver driver) {
		driver.findElement(By.xpath("//a [@class='cart-icon']")).click();
		driver.findElement(By.xpath("//div[@class='cart-preview active']/div/button")).click();
		driver.findElement(By.xpath("//div[@class='promoWrapper']/input")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//div[@class='promoWrapper']/button")).click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='promoWrapper']/span"), "Code applied ..!"));
		driver.findElement(By.cssSelector("div button:last-child")).click();
	}
	

}
