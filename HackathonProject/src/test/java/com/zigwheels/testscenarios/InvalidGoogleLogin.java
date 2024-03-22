package com.zigwheels.testscenarios;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

 

import com.zigwheels.base.TestBase;
import com.zigwheels.pages.LoginToZigWheelsPage;
import com.zigwheels.pages.SignInPage;
import com.zigwheels.pages.ZigWheelsHomePage;

 

public class InvalidGoogleLogin extends TestBase {

 

    // @BeforeTest
    //public void beforeClass() {
     //   setupDriver();
        //  navigateToURL();
  // }
      @Test(priority=0)
    public void navigateToHome() {
          ZigWheelsHomePage zwhp=new ZigWheelsHomePage();
          zwhp.clickLoginButton();
    }
      @Test (dependsOnMethods = "navigateToHome")
 public void loginWithInvalidCredentials() {
          LoginToZigWheelsPage ltzp=new LoginToZigWheelsPage();
          ltzp.clickContinueWithGoogle();
    }
      @Test(dependsOnMethods = "loginWithInvalidCredentials")
      public void captureErrorMessage() {
          SignInPage sip1=new SignInPage();
          sip1.takeScreenshot();
      }

 

       @AfterTest
        public void afterClass() {
           closeDriver();
    }
}
