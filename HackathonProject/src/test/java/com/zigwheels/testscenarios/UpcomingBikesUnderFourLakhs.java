package com.zigwheels.testscenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.zigwheels.base.ReadExcelFile;
import com.zigwheels.base.TestBase;
import com.zigwheels.pages.UpcomingBikeSearchPage;
import com.zigwheels.pages.ZigWheelsHomePage;

public class UpcomingBikesUnderFourLakhs extends TestBase {

	
	@BeforeTest
	public void beforeClass() {
		setupDriver();
		  navigateToURL();
	}
	  @Test(priority=1)
	  public void navigateToUpcomingBikes() {
		  ZigWheelsHomePage zigWheels=new ZigWheelsHomePage();
		  String ActualTitle=zigWheels.clickUpcomingBikes();
		  String ExpectedTitle = "ZigWheels - New Cars, Used Cars, Bikes Prices, News, Reviews, Forum";
		  Assert.assertEquals(ExpectedTitle, ActualTitle);
	}
	  @DataProvider
	  public Object[][] dp() throws IOException{
	  Object[][] obj = new Object[1][0];
	  obj = ReadExcelFile .readExcelData();
	  return obj;
	  }
	  @Test(priority=2,dataProvider="dp")
	  public void navigateToHondaBikes(String bikebrand) {
	  UpcomingBikeSearchPage upsp=new UpcomingBikeSearchPage();
	  upsp.selectManufacturerHonda(bikebrand);
	  upsp.clickViewMoreBikes();
	  }
	  @Test(priority=3)
      public void displayUpcomingBikes() {
      UpcomingBikeSearchPage upsp1=new UpcomingBikeSearchPage();
	  upsp1.getListOfAllBikes();
	  //upsp1.displayBikesUnderFourLakhs();
}
	/* @AfterTest
  public void afterClass() {
		  closeDriver();
	}*/
}

