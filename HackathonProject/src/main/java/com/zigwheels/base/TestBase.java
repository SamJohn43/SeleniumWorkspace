package com.zigwheels.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static WebDriver driver;
	public Properties prop;
	File file;
	FileInputStream fis;

	public void setupDriver() {
		prop = new Properties();

		try {
			fis = new FileInputStream(".\\src\\main\\resources\\com\\zigwheels\\config\\Config.properties");
			prop.load(fis);
		} catch (FileNotFoundException fnf) {
			System.out.println("File name or path name is not correct");
		} catch (IOException ioe) {
			System.out.println("Input output error");
		}
           //CHROME BROWSER           
		if (prop.getProperty("Browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\Drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			 driver = new ChromeDriver(options);
            //FIREFOX BROWSER
		} else if (prop.getProperty("Browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\src\\test\\resources\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			//EDGE BROWSER
		}else if (prop.getProperty("Browser").equalsIgnoreCase("Edge")) {
            System.setProperty("webdriver.edge.driver", ".\\src\\test\\resources\\Drivers\\msedgedriver.exe");
            driver=new EdgeDriver();
		}
		
		 driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	     //WEBPAGE LINK
	     public void navigateToURL() {
		 driver.get(prop.getProperty("URL"));
	}
	     //CLOSING THE BROWSER
	     public void closeDriver() {
		 driver.quit();
	}
}