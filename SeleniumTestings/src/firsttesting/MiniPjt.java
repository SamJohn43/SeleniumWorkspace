package firsttesting;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//************Handling multiple browsers CHROME/FireFox************
public class MiniPjt { 
	WebDriver driver = null;

	public void driverSetup() {
		boolean loop = true;
		System.out.println("Enter any of the below browser name");
		System.out.println("Chrome \nFirefox ");
		String s;
		System.out.println();
		Scanner sc = new Scanner(System.in);
		String browserName = sc.nextLine();
		while (loop) {
			if (browserName.equalsIgnoreCase("chrome")) {

				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sam jehova\\OneDrive\\Documents\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
				driver = new ChromeDriver();
				loop = false;
			} else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\Sam jehova\\OneDrive\\Documents\\Drivers\\geckodriver-v0.30.0-win64\\geckodriver.exe");
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
	// ************Enter the URL************
	public void openUrl() {
		driver.get("https://www.rediff.com/");

	}

	// ************Click on "Create Account" link & Validate “Create RediffMail account” WebPage************
	// is opened.
	public void validateParentPage() {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"signin_info\"]/a[2]")));
		driver.findElement(By.xpath("//*[@id=\"signin_info\"]/a[2]")).click();
		String parentpage = driver.getTitle();
		if (parentpage.equals("Rediffmail Free Unlimited Storage")) {
			System.out.println("================================================");
			System.out.println("validated:" + parentpage + "\n");
		} else {
			System.out.println("excepted webpage is not displayed\n");
		}
	}

	// ********Finding the total number of links in “Create RediffMail account” WebPage and*******
	// ********printing the links.**********
	public void findAndPrintParentPageLinks() {
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("================================================");
		System.out.println("Total Links Are " + allLinks.size() + "\n");
		for (int i = 0; i < allLinks.size(); i++) {
			System.out.println("Links on this pages are " + allLinks.get(i).getAttribute("href"));
	
		}
	}

	// **************Clicking on "terms and conditions" link***************
	public void clickChildWindow() {
		driver.findElement(By.linkText("terms and conditions")).click();
	}

	// **********Validating child window “Terms and Conditions” is opened.************
	// ************Switching to the child window************
	// ************Getting the title of the child window************
	// ************Validating the title of the child window with the expected title.************
	public void validateChildWindow() {
		Set<String> s1 = driver.getWindowHandles();
		for (String window : s1) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String checkName = driver.switchTo().window(window).getTitle();
			if (checkName.equalsIgnoreCase("Rediffmail: Terms and Conditions")) {
				System.out.println("================================================");
				System.out.println("\n" + checkName + " window is opened");
				String childWindow = driver.getTitle();
				System.out.println("\nchildWindow Title: " + childWindow);

				if (childWindow.equals("Rediffmail: Terms and Conditions")) {
					System.out.println("\nvalidated : " + childWindow);
					System.out.println("================================================");
				}
			}
		}
	}

	// ************Closing the child window************
	public void closingChildwindow() {
		driver.quit();
	}

	// ************Switching to the parent window (“Create RediffMail account” WebPage)************
	// ************Closing the browser************
	public void closingBrowser() {
		driver.quit();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiniPjt mp = new MiniPjt();
		mp.driverSetup();
		mp.openUrl();
		mp.validateParentPage();
		mp.findAndPrintParentPageLinks();
		mp.clickChildWindow();
		mp.validateChildWindow();
		mp.closingChildwindow();
		mp.closingBrowser();
	}
}

