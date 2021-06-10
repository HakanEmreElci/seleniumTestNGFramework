package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.AmazonHomePage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AmazonSearchTest {

	AmazonHomePage amazonHP;

	@Test
	public void amazonSearchTest() throws InterruptedException {
		Driver.getDriver().get(PropertiesReader.getProperty("amazonURL"));
		amazonHP = new AmazonHomePage();
		amazonHP.twotabsearchtextbox.sendKeys("coffee mug");
		amazonHP.searchButton.click();
		Thread.sleep(4000);
	}

	@Test
	public void dropDownTest() {
		Driver.getDriver().get(PropertiesReader.getProperty("amazonURL"));
		amazonHP = new AmazonHomePage();
		BrowserUtils.selectByVisibleText(amazonHP.departmentsDropdown, "Amazon Fresh");

	}

	@Test
  public void searchResultVerify() throws InterruptedException {
	  Driver.getDriver().get(PropertiesReader.getProperty("amazonURL"));
	  amazonHP = new AmazonHomePage();
	  amazonHP.twotabsearchtextbox.sendKeys("Coffee Mug");
	  amazonHP.searchButton.click();
	  Thread.sleep(2000);
	  
	  System.out.println("The number of the total items in the list is: " + amazonHP.searchItemPrices.size());
	  for (WebElement itemPrice : amazonHP.searchItemPrices) {
		  String price = itemPrice.getText();
		  System.out.println(price);
	  }
		
	}
	  
	  
	  @Test
	  public void softAssertTest() {
		SoftAssert softAssert = new SoftAssert();
		
		// if this is false-> this line of code fails,  rest of the code will stop from being executed
		Assert.assertTrue(true); 
		System.out.println("If the assert above is false, this will not be printed!");
		
		// if this is false-> this line of code fails, rest will still be executed. Test will be marked as failed
		softAssert.assertTrue(true); 
		System.out.println("This is after soft assert"); //
		
		softAssert.assertAll();
		  
	  }

	  
	@BeforeMethod
	public void beforeMethod() {
		Driver.getDriver();
	}

	@AfterMethod
	public void afterMethod() {
		Driver.quitDriver();
	}

}
