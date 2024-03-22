package com.zigwheels.pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.zigwheels.base.TestBase;

public class SignInPage extends TestBase {

	public void invalidLoginCredentials() {
		
	}
	public void takeScreenshot()  {
	    //***CAPTURING ERROR MESSAGE***//
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss"); //yyyy-MM-dd
		String dateTime = sdf.format(date);
		String fileName = "ScreenShot_" + dateTime;

		File fstsrc= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("./src/test/resources/ScreenShot/img"+ fileName+".png");

		try {
		FileHandler.copy(fstsrc, dest);
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ErrTxt=driver.findElement(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[2]/div[2]")).getText();
		System.out.println("================================================");
		System.out.println("ERROR MESSAGE: "+ErrTxt);
		System.out.println("================================================");
	}
}

