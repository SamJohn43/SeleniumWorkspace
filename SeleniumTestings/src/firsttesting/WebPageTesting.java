package firsttesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebPageTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sam jehova\\OneDrive\\Documents\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.actitime.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Try Free")).click();
		WebDriverWait wait =new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.urlToBe("https://www.actitime.com/free-online-trial"));
		driver.findElement(By.id("First Name")).sendKeys("Sam");
		driver.findElement(By.id("Last Name")).sendKeys("John");
		driver.findElement(By.id("Email")).sendKeys("John.google.com");
		driver.findElement(By.id("Company")).sendKeys("sam john");
		//driver.close();
	}

}
