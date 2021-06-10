package tests;

import org.testng.annotations.Test;

import pages.SeleniumEasyAlertPage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class SeleniumEasyAlertTests {
	
	// instead of doing SeleniumEasyAlertPage alertPage = new SeleniumEasyAlertPage();
	// you can just instantiate SeleniumEasyAlertPage alertPage; and the second part you can put
	// inside the method with the instantiation so that a new session ID isn't lost in the next method
	SeleniumEasyAlertPage alertPage;
	BrowserUtils utils = new BrowserUtils();

	@Test(priority=1, description="This is first Alert accept test.")
	public void firstAlertTest() throws InterruptedException {
		Driver.getDriver().get(PropertiesReader.getProperty("seleniumEasyAlertUrl"));
		alertPage = new SeleniumEasyAlertPage();
		alertPage.firstAlertBtn.click();

		// calling to switchToAlert function
		utils.switchToAlert();
		utils.waitUntilAlertIsPresent();

//	  Alert alert = Driver.getDriver().switchTo().alert(); // switching to the alert window like this!!!
//	  WebDriverWait letsWait = new WebDriverWait(Driver.getDriver(), 10);
//	  letsWait.until(ExpectedConditions.alertIsPresent());

		String expectedMsg = "I am an alert box!";
		String actualMsg = utils.alertGetText();
		Assert.assertEquals(actualMsg, expectedMsg);
		Thread.sleep(4000);
		utils.alertAccept();

	}

	@Test(priority=2, description="This is a second Alert test of pressing a button.")
	public void secondAlertTest() throws InterruptedException {
		Driver.getDriver().get(PropertiesReader.getProperty("seleniumEasyAlertUrl"));
		alertPage = new SeleniumEasyAlertPage();
		alertPage.secondAlertBtn.click();
		utils.switchToAlert();
		utils.waitUntilAlertIsPresent();

		String expectedMsg = "Press a button!";
		String actualMsg = utils.alertGetText();
		Assert.assertEquals(actualMsg, expectedMsg);
		Thread.sleep(5000);
		utils.alertDismiss();
	}
	
	@Test(priority=3, description="This is the third alert test")
	public void thirdAlertTest() throws InterruptedException {
		
		Driver.getDriver().get(PropertiesReader.getProperty("seleniumEasyAlertUrl"));
		alertPage = new SeleniumEasyAlertPage();
		alertPage.thirdAlertBtn.click();
		utils.switchToAlert();
		utils.waitUntilAlertIsPresent();
		String expectedMsg = "Please enter your name";
		String actualMsg = utils.alertGetText();
		Assert.assertEquals(actualMsg, expectedMsg);
		
		utils.sendKeys("John");
		Thread.sleep(3000);
		utils.alertAccept();
		
	}
	
	

	@BeforeTest
	public void beforeTest() {
		Driver.getDriver();
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

//  @AfterMethod
//  public void afterMethod() {
//	  Driver.getDriver().close();
//  }

	@AfterTest
	public void afterTest() {
		Driver.quitDriver();
	}

}
