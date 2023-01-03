package Selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumIntrocution {

	public static void main(String[] args) {
		if(System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", "./src/resources/geckodriver.exe");	
		}
		else{
			System.setProperty("webdriver.gecko.driver", "./src/resources/geckodriver");
		}
		
		//Para ejecutar las pruebas con navegador chrome
			//System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver.exe");
			//WebDriver driver= new ChromeDriver();
		//Para ejecutar las pruebas con firefox
			System.setProperty("webdriver.gecko.driver", "./src/resources/geckodriver.exe");
			WebDriver driver= new FirefoxDriver();
		//Para ejecutar las pruebas con Edge
			//System.setProperty("webdriver.edge.driver", "./src/resources/msedgedriver.exe");
			//WebDriver driver= new EdgeDriver();	
		
		//CODIGO COM�N		
		driver.get("https://rahulshettyacademy.com/");
		String titulo=driver.getTitle();
		String url=driver.getCurrentUrl();
		System.out.println(titulo);
		System.out.println(url);
		driver.quit();		
	}

}
