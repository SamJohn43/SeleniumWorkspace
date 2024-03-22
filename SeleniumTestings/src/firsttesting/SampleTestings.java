package firsttesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class SampleTestings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Sam jehova\\OneDrive\\Documents\\Drivers\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		
		//System.setProperty("webdriver.edge.driver","C:\\Users\\Sam jehova\\OneDrive\\Documents\\Drivers\\edgedriver_win64\\msedgedriver.exe");
		//WebDriver driver=new EdgeDriver();
		
		WebDriver driver=new FirefoxDriver();
				
		driver.manage().window().maximize();
		//driver.get("http://webapps.tekstac.com/OnlineShopping/fashion.html");
		driver.get("https://www.redbus.in/");
		
	    driver.findElement(By.xpath("/html/body/section/div[2]/main/div[3]/div[1]/div[1]/div/div[1]/div/div[1]/div/div/div")).sendKeys("KALLAKRICHI");
		
		
		WebElement source1=driver.findElement(By.id("Shirts"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement drag=driver.findElement(By.id("droppable"));
		Actions builder=new Actions(driver);
		builder.clickAndHold(source1).moveToElement(drag).release(source1).build().perform();
		
		//driver.close();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
		}

}
