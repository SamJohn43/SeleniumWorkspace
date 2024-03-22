package firsttesting;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainProjectDemo {
	//By searchbar=By.xpath("//*[@placeholder='Start Searching…' and @id='genericSearch2226']");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//CHROME
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Sam jehova\\OneDrive\\Documents\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//FIREFOX
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Sam jehova\\OneDrive\\Documents\\Drivers\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		//WebDriver driver=new FirefoxDriver();
		
		//EDGE
		//System.setProperty("webdriver.edge.driver","C:\\Users\\Sam jehova\\OneDrive\\Documents\\Drivers\\edgedriver_win64\\msedgedriver.exe");
		//WebDriver driver=new EdgeDriver();
		
		
		driver.get("https://be.cognizant.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
		driver.findElement(By.xpath("//*[@id=\"i0116\"]")).sendKeys("");
		//driver.findElement(By.xpath(""));
		
		driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"i0118\"]")).sendKeys("");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
		
		
		driver.findElement(By.xpath("//*[@id=\"idDiv_SAOTCS_Proofs\"]/div[2]/div")).click();
		
		
		
		WebDriverWait wait = new WebDriverWait(driver,40);
   	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"idBtn_Back\"]")));
   	    
   	 try {
			Thread.sleep(4500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
   	    
		driver.findElement(By.xpath("//*[@id=\"idBtn_Back\"]")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		driver.findElement(By.xpath("//span[contains (text(),\"All Apps & Tools\")]")).click();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("PRINTING FIRST LETTER OF FIRST NAME");
		driver.findElement(By.xpath("//*[@placeholder='Start Searching…'and@ng-model='$ctrl.queryText']")).click();
		driver.findElement(By.xpath("//*[@placeholder='Start Searching…'and@ng-model='$ctrl.queryText']")).sendKeys("s");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//*[@placeholder='Start Searching…'and@ng-model='$ctrl.queryText']")).sendKeys(Keys.ENTER);
		
		//geting course name
		List<WebElement> listname=driver.findElements(By.xpath("//*[@class='apps-and-tools__card__title ellipsis ng-binding']"));
	//String app	=driver.findElement(By.xpath("//*[@class='apps-and-tools__card__title ellipsis ng-binding']"));
		
	    for(WebElement i:listname) {
		System.out.println(i.getText());
	}
	
	   driver.findElement(By.xpath("//*[@class='filter-btns']")).click();
	   
	   System.out.println("PRINTING LAST LETTER OF FIRST NAME");
	
	    driver.findElement(By.xpath("//*[@placeholder='Start Searching…'and @ng-model='$ctrl.queryText']")).sendKeys("l");
	    
	    driver.findElement(By.xpath("//*[@placeholder='Start Searching…'and@ng-model='$ctrl.queryText']")).sendKeys(Keys.ENTER);
	    
	    List<WebElement> listname1=driver.findElements(By.xpath("//*[@class='apps-and-tools__card__title ellipsis ng-binding']"));
	   
	        for(WebElement i:listname1) {
			System.out.println(i.getText());
		}
	    
	}

}
