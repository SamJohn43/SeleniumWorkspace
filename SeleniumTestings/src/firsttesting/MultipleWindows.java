 package firsttesting;

import java.util.Iterator;
//import java.sql.Driver;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

//Handling multiple browsers Chrome/Firefox
public class MultipleWindows {
	WebDriver driver = null;
    String checkName;
	public void driverSetup() {
		boolean loop = true;
		System.out.println("Enter any of the below browser name");
		System.out.println("Chrome \nFirefox ");

		// String s;
		// String currDir = System.getProperty("user.dir");
		// System.out.println("Current Directory: " + currDir);

		System.out.println();

		Scanner sc = new Scanner(System.in);
		String browserName = sc.nextLine();

		while (loop) {
			if (browserName.equalsIgnoreCase("chrome")) {

				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\Sam jehova\\OneDrive\\Documents\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
				driver = new ChromeDriver();
				loop = false;
			} else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\Sam jehova\\OneDrive\\Documents\\Drivers\\geckodriver-v0.30.0-win64\\geckodriver.exe");
				driver = new FirefoxDriver();
				loop = false;
			} else {
				System.out.println("Invalid browser name, please enter the valid browser or 0 to Exit\n");
				browserName = sc.nextLine();
				if (browserName.equalsIgnoreCase("0")) {
					System.out.println(" it is terminating now\n");
					System.exit(0);

				}
			}

		}

		driver.manage().window().maximize();
	}
	// Enter the url

	public void openUrl() {
		driver.get("https://www.rediff.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// Click on "Create Account" link & Validate “Create Rediffmail account” webpage
	// is opened.
	public void validateParentPage() {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"signin_info\"]/a[2]")).click();
		String parentpage = driver.getTitle();
		if (parentpage.equals("Rediffmail Free Unlimited Storage")) {
			System.out.println("validated:" + parentpage + "\n");
		} else {
			System.out.println("excepted webpage is not displayed\n");
		}
	}

	// Finding the total number of links in “Create Rediffmail account” webpage and
	// printing the links.
	public void findAndPrintParentPageLinks() {
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total Links Are " + allLinks.size() + "\n");
		for (int i = 0; i < allLinks.size(); i++) {
			System.out.println("Links on this pages are " + allLinks.get(i).getAttribute("href"));
			// System.out.println("Links on this pages are "+allLinks.get(i).getText());
		}
	}

	// Clicking on "terms and conditions" link
	public void clickChildWindow() {
		driver.findElement(By.linkText("terms and conditions")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	// Validating child window “Terms and Conditions” is opened.
	// Switching to the child window
	// Geting the title of the child window
	// Validating the title of the child window with the expected title.
	public void validateChildWindow() {
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

		String child_window=I1.next();

		if(!parent.equals(child_window))
		{
			 checkName=driver.switchTo().window(child_window).getTitle();
		}
		}
		/*
		 * Set<String> s1 = driver.getWindowHandles(); // List
		 * 
		 * // System.out.println("All Windows = ");
		 * 
		 * for (String window : s1) { //driver.manage().timeouts().implicitlyWait(20,
		 * TimeUnit.SECONDS); try { Thread.sleep(3000); } catch (InterruptedException e)
		 * { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
			//String checkName = driver.switchTo().window(child_).getTitle();
			// System.out.println(driver.switchTo().window(window).getTitle() + " --> " +
			// window);
		         driver.switchTo().window(parent);
			if (checkName.equalsIgnoreCase("Rediffmail: Terms and Conditions")) {
				System.out.println("\n" + checkName + " window is opened");
				String childWindow = driver.getTitle();
				System.out.println("\nchildWindow Title: " + childWindow);

				if (childWindow.equals("Rediffmail: Terms and Conditions")) {
					System.out.println("\nvalidated : " + childWindow);

				}
			}
		}

	

	// Closing the child window
	public void closingChildwindow() {
		driver.quit();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// Switching to the parent window (“Create Rediffmail account” webpage)
	// Closing the browser
	public void closingBrowser() {
		driver.quit();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MultipleWindows mws = new MultipleWindows();
		mws.driverSetup();
		mws.openUrl();
		mws.validateParentPage();
		mws.findAndPrintParentPageLinks();
		mws.clickChildWindow();
		mws.validateChildWindow();
		mws.closingChildwindow();
		mws.closingBrowser();

	}

}
