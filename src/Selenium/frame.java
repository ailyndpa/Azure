package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class frame {

	public static void main(String[] args) {
		if (System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver");
		}
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/nested_frames");
		driver.switchTo().frame(0);
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-left']")));
		String frameLeft=driver.findElement(By.xpath("//body[contains(text(), 'LEFT')]")).getText();
		System.out.println(">>>>>>>>>>>"+ frameLeft);
		driver.switchTo().parentFrame();
		//System.out.println("CANTIDAD DE FRAMES"+driver.findElements(By.tagName("frame")).size());
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-right']")));
		String frameRight=driver.findElement(By.xpath("//body[contains(text(), 'RIGHT')]")).getText();
		System.out.println(">>>>>>>>>>>"+ frameRight);
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));
		String frameMiddle=driver.findElement(By.id("content")).getText();
		System.out.println(">>>>>>>>>>>"+ frameMiddle);
	}

}
