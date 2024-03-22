package firsttesting;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import graphql.Assert;
public class MiniProjectDemo {

	//WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//firefox browser
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Sam jehova\\OneDrive\\Documents\\Drivers\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		
		//chrome browser
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sam jehova\\OneDrive\\Documents\\Drivers\\chromedriver_win32\\chromedriver.exe");
	    // WebDriver driver=new ChromeDriver();
		
		//edge browser
		//System.setProperty("webdriver.edge.driver","C:\\Users\\Sam jehova\\OneDrive\\Documents\\Drivers\\edgedriver_win64\\msedgedriver.exe");
		//WebDriver driver=new EdgeDriver();
		
		
     
        
        driver.get("https://www.rediff.com/");
        
        driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //locating by linktext
       // driver.findElement(By.linkText("Create Account")).click();
		//locating by realtive path
        //driver.findElement(By.xpath("//a[contains(text(),'Create Account')]")).click();
        //Another Method
       driver.findElement(By.xpath("//*[@id=\"signin_info\"]/a[2]")).click();
        
        String parentpage=  driver.getTitle();
        if(parentpage.equals("Rediffmail Free Unlimited Storage")) {
        	System.out.println("validated:" +parentpage);
        }else {
        	System.out.println("excepted webpage is not displayed");
        }
        	
 
        
        
        
        
        List<WebElement> allLinks=driver.findElements(By.tagName("a"));
        System.out.println("Total Links Are "+ allLinks.size());
        
        for(int i=0;i<allLinks.size();i++)
        {
        	System.out.println("Links on this pages are "+allLinks.get(i).getAttribute("href"));
        	//System.out.println("Links on this pages are "+allLinks.get(i).getText());
        }
           
        
        //driver.findElement(By.linkText("terms and conditions")).click();

        //driver.manage().window().maximize();
        //String childpage=  driver.getTitle();
        //System.out.println(childpage);
        
        
        
        
        String parentWindow = driver.getWindowHandle();
		
		System.out.println("Parent Window = " + driver.getTitle());
//		System.out.println("Parent Window = "+driver.switchTo().window(parentWindow).getTitle());
		
	//	Thread.sleep(2000);
		//driver.findElement(By.id("helpbutton")).click();
		//Thread.sleep(2000);
	    //driver.findElement(By.id("chatbutton")).click();
	    //Thread.sleep(2000);
		driver.findElement(By.linkText("terms and conditions")).click();
		//System.out.println("child click");
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set<String> s1 = driver.getWindowHandles();   //List 
		
		//System.out.println("All Windows = ");
		String newWindw;
		for (String string : s1) {
			
		}
		for(String window : s1)
		{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String checkName = driver.switchTo().window(window).getTitle();
			//System.out.println(window);
			//System.out.println(driver.switchTo().window(window).getTitle() + " --> " + window);
			newWindw = window;
			if(checkName.equalsIgnoreCase("Rediffmail: Terms and Conditions")) {
				System.out.println("Rediffmail: Terms and Conditions window is found");
				 String childWindow=  driver.getTitle();
			        System.out.println(childWindow);

			        if(childWindow.equals("Rediffmail: Terms and Conditions")) {
			        System.out.println("\nvalidated : " + childWindow);
			       // driver.close();
			       
			       
			        }
			        
			}
		}
		//System.out.println(driver.getWindowHandle());
		
		 //driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
		 //driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
		 
        driver.quit();
        
        
        
		
	}

}
