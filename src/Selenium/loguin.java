package Selenium;

import java.time.Duration;

import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.internal.util.Assert;

public class loguin {

	public static void main(String[] args) throws InterruptedException {
		if(System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver.exe");	
		}
		else{
			System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver");	
		}
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//PARA EL USO DE LOCALIZADORES HICE USO DE LA EXTENSION SELECTORHUB
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");// css selector por id
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("hello123");//css selector por atributo tagname[atributo='valor']
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();//xpath por atributo
		String msgError= driver.findElement(By.xpath("//form/p")).getText();//parentTagname/childTagname
		Assert.isTrue(msgError.equals("* Incorrect username or password"), "El mensaje de error que se muestra no es: * Incorrect username or password ");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//form/input[1]")).sendKeys("John");//parentTagname/childTagname[index]
		driver.findElement(By.cssSelector("form input[type='text']:nth-child(3)")).sendKeys("john@rsa.com");//parentTagname childTagname[attribute=’valor’]:nth-child(index)
		driver.findElement(By.xpath("//input[@type='text'][3]")).sendKeys("9864353253");//xpath por atributo[index]
		driver.findElement(By.cssSelector("div button[class='reset-pwd-btn']")).click();//parentTagname/childTagname atributo
		String smsPass=driver.findElement(By.xpath("//p[contains(@class,'infoMsg')]")).getText();
		Assert.isTrue(smsPass.equals("Please use temporary password 'rahulshettyacademy' to Login."), "El mensaje de error que se muestra no es: Please use temporary password 'rahulshettyacademy' to Login.");
		driver.findElement(By.className("go-to-login-btn")).click();
		Thread.sleep(1000);
		login(driver);
		driver.findElement(By.cssSelector("input[name='chkboxTwo']")).click();
		driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();//tagname[contains(@atributo,'valo')] expresión regular
		driver.close();
	}
	
	public static void login(WebDriver driver) {
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
	}

}
