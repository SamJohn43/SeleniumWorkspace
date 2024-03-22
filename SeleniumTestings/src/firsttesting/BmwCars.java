package firsttesting;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BmwCars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sam jehova\\OneDrive\\Documents\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://cookbook.seleniumacademy.com/Config.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//DROPDOWN
		driver.findElement(By.xpath("//*[@id=\"tabs-1\"]/p[1]/select")).click();
		//RADIO BUTTON
		driver.findElement(By.xpath("//*[@id=\"tabs-1\"]/p[2]/input[2]")).click();
		//car type
		driver.findElement(By.xpath("//*[@id=\"tabs-1\"]/p[3]/input[3]")).click();
		//car colour
		driver.findElement(By.xpath("//*[@id=\"tabs-1\"]/p[4]/select/option[2]")).click();
		//CLICKING HELP BT
		driver.findElement(By.id("helpbutton")).click();
		
	    String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();
		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
		String child_window=I1.next();
		if(!parent.equals(child_window))
		{
			System.out.println("hey");
		driver.switchTo().window(child_window);
		String helpbutton=driver.getTitle();
		if(helpbutton.equals(helpbutton)) {
			System.out.println("================================================");
			System.out.println("Firstwindow is opened " + helpbutton + "\n");
		}
		driver.close();
		break;
		}
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().window(parent);
		//online chat and support
		driver.findElement(By.xpath("//*[@id=\"chatbutton\"]")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String parent1=driver.getWindowHandle();
		Set<String>s1=driver.getWindowHandles();
		// Now iterate using Iterator
		Iterator<String> I2= s1.iterator();
		while(I2.hasNext())
		{
		String child_window2=I2.next();
		if(!parent1.equals(child_window2))
		{
		driver.switchTo().window(child_window2);
		String chatbutton=driver.findElement(By.xpath("//*[@id=\"chatbutton\"]")).getText();
		//String chatbutton= driver.getText();
		System.out.println("hi");
		if(chatbutton.equals(chatbutton)) {
			System.out.println("================================================");
			System.out.println("SECONDwindow is opened " + chatbutton + "\n");
		}
		driver.close();
		break;
		}
		}
          driver.switchTo().window(parent1);
		
	}

}
