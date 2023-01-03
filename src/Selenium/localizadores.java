package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class localizadores {

	public static void main(String[] args) throws InterruptedException {
		String usuario="rahul";
		if(System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.edge.driver", "./src/resources/msedgedriver.exe");	
		}
		else{
			System.setProperty("webdriver.edge.driver", "./src/resources/msedgedriver");	
		}
		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//PARA EL USO DE LOCALIZADORES HICE USO DE LA EXTENSION SELECTORHUB
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		String contraseña=password(driver);
		driver.findElement(By.className("go-to-login-btn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("inputUsername")).sendKeys(usuario);
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(contraseña);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.cssSelector("input[name='chkboxTwo']")).click();
		driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();//tagname[contains(@atributo,'valo')] expresión regular
		Thread.sleep(1000);
		String mensajeOK=driver.findElement(By.tagName("p")).getText();
		Assert.assertEquals(mensajeOK, "You are successfully logged in.");
		String mensajeBienvenida=driver.findElement(By.cssSelector("div h2")).getText();
		Assert.assertEquals(mensajeBienvenida, "Hello "+ usuario+",");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.close();
	}
	public static String password(WebDriver driver) throws InterruptedException {
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("div button[class='reset-pwd-btn']")).click();
		String text=driver.findElement(By.xpath("//p[contains(@class,'infoMsg')]")).getText();
		String []passArray1= text.split("'");
		String []passArray2=passArray1[1].split("'");
		String pass= passArray2[0];
		System.out.print(false);
		return pass;
		
		
	}

}
