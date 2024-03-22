package com.zigwheels.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zigwheels.base.TestBase;

public class UpcomingBikeSearchPage extends TestBase{
    //***SELECTING MANUFRACTURER***//
	public void selectManufacturerHonda(String bikebrand) {
		By manufacturer=By.className("custom-select");
		WebElement selectManufacturer = driver.findElement(manufacturer);
		Select s=new Select(selectManufacturer);
		s.selectByVisibleText(bikebrand);
		}
	//***CLICKING "VIEW MORE"***//
	public void clickViewMoreBikes() {
		 By scroll=By.xpath("//*[@id='modelList']/li[5]/div/div[3]/div[3]/span");
        WebElement scr=driver.findElement(scroll);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", scr);
        
        try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        
        WebDriverWait wait = new WebDriverWait(driver,20);
   	    wait.until(ExpectedConditions.visibilityOfElementLocated(scroll));
        driver.findElement(By.xpath("//span[contains(text(),'View More Bikes')]")).click();
	    } 
	 public void getListOfAllBikes() {
		int count=1;
        int k=1;
        WebElement Bikelocator1=driver.findElement(By.xpath("//*[@id=\"modelList\"]/li["+k+"]/div/div[3]/div[1]"));

         try {
          while(Bikelocator1!=null) {
          if(k==7) {
          k+=1;
          continue;
          }else {
          Bikelocator1=driver.findElement(By.xpath("//*[@id=\"modelList\"]/li["+k+"]/div/div[3]/div[1]"));
          count+=1;
          k+=1;
          }
          }
        }catch(NoSuchElementException e) {
            System.out.println("\n"+"*****There are "+count+" Honda bikes in Total******"+"\n");
            System.out.println("================================================");
          }
          ArrayList<Integer> bikesPrice = new ArrayList<Integer>();
          try {
		  Thread.sleep(2500);
	      } catch (InterruptedException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
	      }
          for (int i=1;i<=count;i++) {

          if (i!=7) {
               String price=driver.findElement(By.xpath("//*[@id=\"modelList\"]/li["+i+"]/div/div[3]/div[1]")).getText();
               price =price.replaceAll("\\D+","");
               int n= Integer.parseInt(price);
               bikesPrice.add(n);
               }
           }

           int honda=0;
           for(int i=0;i<bikesPrice.size();i++) {
           if(bikesPrice.get(i)<400) {
           honda+=1;
           }
           }
           System.out.println("\n"+"There are "+honda+" Honda bikes under four lakhs in the list"+"\n");
           System.out.println("================================================");
   
             for(int i=0;i<bikesPrice.size();i++) {
        	 if(bikesPrice.get(i)<400) {
       	
       		 int j;
       		 if (i<6) {
       			 j=i+1; 
       		 }else {
       			 j=i+2;
       		 }
       		 
       		String name=driver.findElement(By.xpath("//*[@id='modelList']/li["+j+"]/div/div[3]/a/strong")).getText();
       		
       		String price=driver.findElement(By.xpath("//*[@id=\"modelList\"]/li["+j+"]/div/div[3]/div[1]")).getText();
       		
       		String date=driver.findElement(By.xpath("//*[@id=\"modelList\"]/li["+j+"]/div/div[3]/div[2]")).getText();
       	
       		System.out.println(name+"  "+price+"  "+date);
       		System.out.println("================================================");
		     
           	}
       	    }
   }
}

