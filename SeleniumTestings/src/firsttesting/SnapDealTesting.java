package firsttesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SnapDealTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sam jehova\\OneDrive\\Documents\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.snapdeal.com/?utm_term=437025299421_104151711009_%7Bbidstrategy%7D&gclid=EAIaIQobChMI-vaL6N_v9QIVxAeRCh0EmQ_0EAAYASAAEgKYnPD_BwE&utm_campaign=brand_account_brandcat_cpt_1d_ftu&utm_source=earth_sembrand&utm_medium=snapdeal");
		driver.manage().window().maximize();
	    driver.findElement(By.id("inputValEnter")).sendKeys("Bluetooth headphone");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//*[@id=\"sdHeader\"]/div[4]/div[2]/div/div[2]/button/span")).click();
	    
	    driver.findElement(By.xpath("//*[@id=\"content_wrapper\"]/div[7]/div[5]/div[3]/div[1]/div/div[2]/div/i")).click();
	    
	    driver.findElement(By.xpath("//*[@id=\"content_wrapper\"]/div[7]/div[5]/div[3]/div[1]/div/div[2]/ul/li[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"content_wrapper\"]/div[7]/div[4]/div/div[1]/div[2]/div[2]/div[3]/div/div[3]/div/input")).clear();//sendKeys("700");
        driver.findElement(By.xpath("//*[@id=\"content_wrapper\"]/div[7]/div[4]/div/div[1]/div[2]/div[2]/div[3]/div/div[3]/div/input")).sendKeys("700");
		
        driver.findElement(By.xpath("//*[@id=\"content_wrapper\"]/div[7]/div[4]/div/div[1]/div[2]/div[2]/div[3]/div/div[4]/div/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"content_wrapper\"]/div[7]/div[4]/div/div[1]/div[2]/div[2]/div[3]/div/div[4]/div/input")).sendKeys("1400");
        
        driver.findElement(By.xpath("//*[@id=\"content_wrapper\"]/div[7]/div[4]/div/div[1]/div[2]/div[2]/div[3]/div/div[5]")).click();
        
        
        
        
    	/*
		 * Actions act=new Actions(driver); 
		 * act.sendKeys(Keys.ENTER).perform();
		 */
        
        //driver.close();
        
        
	}
	

}
