package Selenium;

import java.awt.Window;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class scope {

	public static void main(String[] args) {
		if (System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver");
		}
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.qaclickacademy.com/practice.php");
		// busca la cantidad de etiquetas "a" en la pagina
		// System.out.println("CANTIDAD DE TAGNAME a " +
		// driver.findElements(By.tagName("a")).size());
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		// busca la cantidad de etiquetas "a" en el footer
		// System.out.println("CANTIDAD DE TAGNAME a EN EL FOOTER " +
		// footer.findElements(By.tagName("a")).size());
		WebElement colum = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		// busca la cantidad de etiquetas "a" en la primera columna
		// System.out.println("CANTIDAD DE TAGNAME a EN LA COLUMNA 1 " +
		// colum.findElements(By.tagName("a")).size());

		List<WebElement> link = colum.findElements(By.tagName("a"));
		for (int i = 1; i < link.size(); i++) {
			link.get(i).sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
		}
		Set<String> tab = driver.getWindowHandles();
		Iterator<String> it = tab.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

	}

}
