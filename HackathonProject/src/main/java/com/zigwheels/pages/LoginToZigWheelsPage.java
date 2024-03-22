package com.zigwheels.pages;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.zigwheels.base.TestBase;

public class LoginToZigWheelsPage extends TestBase {

	public void clickContinueWithGoogle() {
		  try {
	            Thread.sleep(2000);
	        } catch (InterruptedException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	         driver.findElement(By.xpath("//*[@id=\"googleSignIn\"]/span[1]")).click();
	         String parent=driver.getWindowHandle();
	         Set<String>s=driver.getWindowHandles();
	         // Now iterate using Iterator
	         Iterator<String> I1= s.iterator();
	         while(I1.hasNext())
	         {
	         String child_window=I1.next();
	         if(!parent.equals(child_window))
	         {
	         driver.switchTo().window(child_window);
	         driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("123@gmail");
	         try {
	            Thread.sleep(2000);
	        } catch (InterruptedException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	         driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
	      
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        try {
	            Thread.sleep(4000);
	        } catch (InterruptedException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	        }
	         }
	         }
	}
}

