package firsttesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FaceBookTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sam jehova\\OneDrive\\Documents\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.facebook.com/");
		//driver.findElement(By.xpath("//input[@aria-label=\"First name\"]")).sendKeys("Sam");
		//driver.findElement(By.xpath("//input[@aria-label=\"Surname\"]")).sendKeys("John");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@aria-label=\"Email address or phone number\"]")).sendKeys("samawesomjohn.gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@aria-label=\"Password\"]")).sendKeys("123456789");
		//*[@id="u_0_a_nn"]/div[3]/a
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Forgotten password?")).click();
		// driver.find
		driver.close();
		
		
	}

}
