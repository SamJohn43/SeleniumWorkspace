package firsttesting;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InvokeBrowserDynamically {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=null;
		boolean loop = true;
		System.out.println("Enter any of the below browser name");
		System.out.println("Chrome \nFirefox ");

		String s;
		//String currDir = System.getProperty("user.dir");
		//System.out.println("Current Directory: " + currDir);

		System.out.println();

		Scanner sc = new Scanner(System.in);
		String browserName = sc.nextLine();

		while(loop) {
		if(browserName.equalsIgnoreCase("chrome")) {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Sam jehova\\OneDrive\\Documents\\Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		loop = false;
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Sam jehova\\OneDrive\\Documents\\Drivers\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		loop = false;
		}
		else {
		System.out.println("Invalid browser name, please enter the valid browser or 0 to Exit");
		browserName = sc.nextLine();
		if(browserName.equalsIgnoreCase("0")) {
		System.out.println(" it is terminating now");
		System.exit(0);

		}
		}

		}

		driver.manage().window().maximize();

		//To Launch the URL
		driver.get("https://www.redbus.in/");

		String expResult = "Book Bus Travels, AC Volvo Bus, rPool & Bus Hire - redBus India";

		String actResult = driver.getTitle();

		if (expResult.equalsIgnoreCase(actResult))
		System.out.println("The correct Red Bus website is launched");
		else
		System.out.println("The Red Bus website launched is not correct one");
	}

}
