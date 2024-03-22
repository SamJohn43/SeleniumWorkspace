package com.zigwheels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zigwheels.base.TestBase;

public class UsedCarsInChennaiPage extends TestBase {
	//WebDriver driver;
	//String PopularModels;
	
	public void getListOfAllPopularModels() {
		//System.out.println("POPULAR MODELS:");
		System.out.println("================================================");
		System.out.println("Used cars in Chennai : Popular models in a List");
		System.out.println("================================================");
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String PopularModels=driver.findElement(By.xpath("/html/body/div[11]/div/div[1]/div[1]/div[1]/div[2]/ul/li[2]/div[2]/div[4]")).getText();
		//System.out.println("================================================");
        System.out.println("\n"+PopularModels+"\n");
        System.out.println("================================================");
	}
}


