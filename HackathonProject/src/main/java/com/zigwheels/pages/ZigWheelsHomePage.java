package com.zigwheels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.zigwheels.base.TestBase;

public class ZigWheelsHomePage extends TestBase {
	// WebDriver driver;
	By newBike = By.xpath("//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[3]/a");
	By upcomingBike = By.xpath("//*[@data-track-label='bikes-upcoming' and @href=\"/upcoming-bikes\"]");

	public String clickUpcomingBikes() {
		String ActualTitle=driver.getTitle();
		Actions acts = new Actions(driver);
		WebElement newBikes = driver.findElement(newBike);
		WebElement upcomingBikes = driver.findElement(upcomingBike);
		
		org.openqa.selenium.interactions.Action act = acts.moveToElement(newBikes).pause(2500)
				.moveToElement(upcomingBikes).pause(2000).click().pause(3000).build();
		act.perform();
		return ActualTitle;
	}

	public void clickUsedCars() {
		// write code to click logo
		try {
			Thread.sleep(10356);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    driver.findElement(By.xpath("//*[@id=\"Header\"]/div[1]/div[1]/div[1]/a/img")).click();
		Actions acts = new Actions(driver);

		WebElement usedCars = driver.findElement(By.xpath("//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[6]/a"));

		org.openqa.selenium.interactions.Action act = acts.moveToElement(usedCars).click().pause(2500).build();
		act.perform();
	}

	public void clickChennaiLocation() {

		Actions acts = new Actions(driver);
		WebElement chennaiLocation = driver
				.findElement(By.xpath("//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[6]/ul/li/div[2]/ul/li[5]/a"));

		org.openqa.selenium.interactions.Action act = acts.moveToElement(chennaiLocation).click().pause(3000).build();
		act.perform();
		//*[@id="popularCityList"]/li[5]/a
		//gs_input5
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  driver.findElement(By.xpath("//a[@title=\'Chennai\' or @text()='Chennai']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void clickLoginButton() {
		//zigwheels logo
		driver.findElement(By.xpath("//*[@id=\"Header\"]/div[1]/div[1]/div[1]/a/img")).click();
		driver.findElement(By.xpath("//*[@id='forum_login_title_lg']")).click();
	}
}

