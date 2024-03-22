package firsttesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TripTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Sam jehova\\OneDrive\\Documents\\Drivers\\geckodriver-v0.30.0-win64\\geckodriver.exe");
	   WebDriver	driver = new FirefoxDriver();
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sam jehova\\OneDrive\\Documents\\Drivers\\chromedriver_win32\\chromedriver.exe");
		//WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.tripadvisor.in/");
		
		driver.findElement(By.xpath("//*[@id=\"lithium-root\"]/main/div[1]/div[2]/div/div/div[2]/a/span[1]/span")).click();
	    driver.findElement(By.xpath("/html/body/div[3]/div/form/input[1]")).sendKeys("Nairobi");
	    driver.findElement(By.xpath("//*[@id=\"typeahead_results\"]/a[2]/div[2]/div[1]")).click();
	
	    //driver.findElement(By.xpath("//*[@id=\"component_2\"]/div/div[2]/div/div/div/div[3]/div/div/div/div[2]")).click();
	   
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   
		
	   // driver.findElement(By.xpath("//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/div[14]/div/div/div[2]/div/div[2]/div/div[2]/span[2]/span")).click();
	    
	  //  driver.findElement(By.xpath("//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/div[14]/div/div/div[2]/div/div[2]/div/div[2]/span[2]/span")).click();
	  //  driver.findElement(By.xpath("//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/div[14]/div/div/div[2]/div/button")).click();
	   
	    
	    driver.findElement(By.xpath("//*[@id=\"component_2\"]/div/div[2]/div/div/div/div[1]/div/div/div[2]")).click();
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    for(int i=5;i>=1;i--) {
	    	                                          //*[@id="BODY_BLOCK_JQUERY_REFLOW"]/div[14]/div/div/div[2]/div/div/div[2]/div[1]/div[3]/div[5]/div[7]
	    	String date= driver.findElement(By.xpath("//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/div[14]/div/div/div[2]/div/div/div[2]/div[1]/div[3]/div[5]/div["+i+"]")).getText();
	    	System.out.println("hlo");
	    	if(date!=null) {
	    		driver.findElement(By.xpath("//*[@id=\\\"BODY_BLOCK_JQUERY_REFLOW\\\"]/div[14]/div/div/div[2]/div/div/div[2]/div[1]/div[3]/div[5]/div["+i+"]")).click();
	    		System.out.println("hey");
	    		break;
	    	}
	    }
	    
	    
	   // String date= driver.findElement(By.xpath("//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/div[14]/div/div/div[2]/div/div/div[2]/div[1]/div[3]/div[5]/div[7]")).getText();
	   // System.out.println(date);
	    
	    
	    
	    
	    
	    
	    By scroll=By.xpath("//*[@id=\"component_2\"]/div/div[3]/div/div[1]/div[1]/div[1]/div/div/div[10]/div[6]/span[1]");
	    By scroll1=By.xpath("//*[@id=\"component_2\"]/div/div[3]/div/div[1]/div[1]/div[1]/div/div/div[3]/div[1]");
	    WebElement scr=driver.findElement(scroll1);
	    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", scr);
	    driver.findElement(scroll).click();
	    
	    By elevator=By.xpath("//*[@id=\"component_2\"]/div/div[3]/div/div[1]/div[1]/div[1]/div/div/div[10]/div[9]/div/label");
	    driver.findElement(elevator).click();
	    
	}

}













////*[@id="BODY_BLOCK_JQUERY_REFLOW"]/div[14]/div/div/div[2]/div/div/div[2]/div[1]/div[3]/div/div