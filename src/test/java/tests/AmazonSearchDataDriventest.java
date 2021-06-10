package tests;

import org.testng.annotations.Test;

import pages.AmazonHomePage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AmazonSearchDataDriventest {
	
	AmazonHomePage amazonHP;
	BrowserUtils utils = new BrowserUtils();
	
  @Test(dataProvider = "myDataBucket")
  public void test(String input) throws InterruptedException {
//	  System.out.println(input);
	  Driver.getDriver().get(PropertiesReader.getProperty("amazonURL"));
	  amazonHP = new AmazonHomePage();
	// searching-verifying the search box on the main page, to make sure we are on the main page
	  Assert.assertTrue(amazonHP.twotabsearchtextbox.isDisplayed());
	// searching for mugs 
	  amazonHP.twotabsearchtextbox.sendKeys(input);
	  amazonHP.searchButton.click();
	  utils.waitUntilElementVisible(amazonHP.coffeeMugText);
	    
	// verifying the search input been displayed on the page
	  String foundText = amazonHP.coffeeMugText.getText();
	  String afterfoundText = foundText.substring(1, foundText.length()-1);
	  Assert.assertEquals(afterfoundText, input);
	  
	 
  }
  
  
  @DataProvider                
  public String[] myDataBucket() {    // data provider needs to have object data return type - means not primitive
	  String[] mydata = new String[5];
	  mydata[0] = "coffee mug";
	  mydata[1] = "pretty coffee mug";
	  mydata[2] = "cool coffee mug";
	  mydata[3] = "cute coffee mug";
	  mydata[4] = "ugly coffee mug";
	  
	  return mydata;
  }
  
//  @DataProvider                    // with numbers
//  public int[] myDataBucket() {    // data provider needs to have object data return type - means not primitive
//	  int[] mydata = new int[5];
//	  mydata[0] = 2;
//	  mydata[1] = 5;
//	  mydata[2] = 7;
//	  mydata[3] = 9;
//	  mydata[4] = 1;
//	  
//	  return mydata;
//  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  Driver.getDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  Driver.quitDriver();
  }

}
