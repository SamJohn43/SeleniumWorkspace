 package com.zigwheels.testscenarios;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.zigwheels.base.TestBase;
import com.zigwheels.pages.UsedCarsInChennaiPage;
import com.zigwheels.pages.ZigWheelsHomePage;

public class PopularUsedCarsInChennai extends TestBase    {    // UpcomingBikesUnderFourLakhs

	// @BeforeTest public void beforeClass() { setupDriver(); navigateToURL(); } 
	@Test (priority=1)           //(dependsOnMethods="displayUpcomingBikes")
	public void navigateToUsedCars() {
		ZigWheelsHomePage zwhp = new ZigWheelsHomePage();
		zwhp.clickUsedCars();
	}

	@Test(dependsOnMethods="navigateToUsedCars")
	public void navigateToUsedCarsInChennai() {
		ZigWheelsHomePage zwhp1 = new ZigWheelsHomePage();
		zwhp1.clickChennaiLocation();
	}

	@Test(dependsOnMethods="navigateToUsedCarsInChennai")
	public void getListOfUsedCarsInChennai() {
		UsedCarsInChennaiPage ucic = new UsedCarsInChennaiPage();
		ucic.getListOfAllPopularModels();
	}

	
	 // @AfterTest public void afterClass() { 
		// closeDriver();
	//  }
	 
}

