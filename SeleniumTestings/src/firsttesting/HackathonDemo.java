package firsttesting;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class HackathonDemo {

	public WebDriver driver = null;
	By scroll = By.xpath("//*[@id='modelList']/li[5]/div/div[3]/div[3]/span");
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public void launchBrowser() {
		// chrome
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Sam jehova\\OneDrive\\Documents\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
		// driver= new ChromeDriver();

		// edge browser
		 //System.setProperty("webdriver.edge.driver","C:\\Users\\Sam
		 //jehova\\OneDrive\\Documents\\Drivers\\edgedriver_win64\\msedgedriver.exe");
		// driver = new EdgeDriver();

		// firefoxbrowser
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\Sam jehova\\OneDrive\\Documents\\Drivers\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		// driver = new FirefoxDriver();

		ChromeOptions options = new ChromeOptions();
		// EdgeOptions options = new EdgeOptions();
		options.addArguments("--disable-notifications");
		// driver = new FirefoxDriver(options);
		driver = new ChromeDriver(options);
		// driver = new ChromeDriver(options);

		
		 // System.setProperty("webdriver.gecko.driver","C:\\Users\\Sam jehova\\OneDrive\\Documents\\Drivers\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		  //driver = new FirefoxDriver(options);
		 
	}

	public void bikeSearch() {

		driver.get("https://www.zigwheels.com/upcoming-bikes");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Actions acts = new Actions(driver);

		WebElement admin = driver.findElement(By.xpath("//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[3]/a"));
		WebElement admin1 = driver.findElement(By.xpath("//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[3]/ul/li[5]/a"));
		org.openqa.selenium.interactions.Action act = acts.moveToElement(admin).pause(2500).moveToElement(admin1)
				.pause(2000).click().pause(3000).build();
		act.perform();

		WebElement manufacture = driver.findElement(By.className("custom-select"));
		Select s = new Select(manufacture);
		s.selectByVisibleText("Honda");

		WebElement scr = driver.findElement(scroll);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scr);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//span[contains(text(),'View More Bikes')]")).click();

		ArrayList<Integer> Bikesname = new ArrayList<Integer>();

		for (int i = 1; i <= 14; i++) {
			if (i != 7) {
				String name = driver.findElement(By.xpath("//*[@id=\"modelList\"]/li[" + i + "]/div/div[3]/div[1]"))
						.getText();
				name = name.replaceAll("\\D+", "");
				int n = Integer.parseInt(name);
				Bikesname.add(n);
			}
		}

		for (int i = 0; i < Bikesname.size(); i++) {
			//int a=1;
			if (Bikesname.get(i) < 400) {
				// System.out.println(Bikesname.get(i));
				int j;
				if (i <= 6) {
					j = i + 1;
				} else {
					j = i + 2;
				}

				String name = driver.findElement(By.xpath("//*[@id='modelList']/li[" + j + "]/div/div[3]/a/strong"))
						.getText();
				String price = driver.findElement(By.xpath("//*[@id='modelList']/li[" + j + "]/div/div[3]/div[1]"))
						.getText();
				String date = driver.findElement(By.xpath("//*[@id='modelList']/li[" + j + "]/div/div[3]/div[2]"))
						.getText();
				System.out.println(name + "  " + price + "  " + date);
			}
			//a=a+1;
		}



	}

	public void carSearch() {
		////// fill code here for used cars in chennai.......///

		driver.findElement(By.xpath("//*[@id=\"Header\"]/div[1]/div[1]/div[1]/a/img")).click();

		Actions acts = new Actions(driver);

		WebElement admin = driver.findElement(By.xpath("//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[6]/a"));
		WebElement admin1 = driver
				.findElement(By.xpath("//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[6]/ul/li/div[2]/ul/li[5]/a"));

		org.openqa.selenium.interactions.Action act = acts.moveToElement(admin).pause(2500).moveToElement(admin1)
				.pause(2000).click().pause(3000).build();
		act.perform();

		String PopularModels = driver
				.findElement(By.xpath("/html/body/div[11]/div/div[1]/div[1]/div[1]/div[2]/ul/li[2]/div[2]/div[4]"))
				.getText();
		System.out.println(PopularModels);
	}

	public void invalidLogin() {
		////// fill code here for invalid login used google.......///

		driver.findElement(By.xpath("//*[@id=\"Header\"]/div[1]/div[1]/div[1]/a/img")).click();
		driver.findElement(By.xpath("//*[@id=\"forum_login_title_lg\"]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id=\"googleSignIn\"]/span[1]")).click();
		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		// Now iterate using Iterator
		Iterator<String> I1 = s.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("123@gmail");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
				System.out.println("hey tis is SAM");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				File fstsrc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				File dest = new File("./snaps/img.png");
				try {
					FileHandler.copy(fstsrc, dest);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				driver.quit();

				// *[@id="googleSignIn"]/span[2]
				// *[@id="googleSignIn"]/span[1]
			}
		}
	}

	public static void main(String[] args) {
		HackathonDemo h = new HackathonDemo();
		h.launchBrowser();
		h.bikeSearch();
		h.carSearch();
		h.invalidLogin();
	}
}
