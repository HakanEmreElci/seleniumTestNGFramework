package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {
	
	Alert alert;
	WebDriverWait letsWait;
	static Select letsSelect;
	
	public void switchToAlert() {
		alert = Driver.getDriver().switchTo().alert();
	}
	
	public String alertGetText() {
		return alert.getText(); // this one switch first and gets the text
	}
	
	public void alertAccept() { // this one switches first and accepts
		alert.accept();
	}
	
	public void alertDismiss() { //this one switches first and dismiss
		alert.dismiss();
	}
	
	public void sendKeys(String name) {
		alert.sendKeys(name);
	}
	
	public void waitUntilAlertIsPresent() {
		letsWait = new WebDriverWait(Driver.getDriver(), 10);	
		letsWait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void waitUntilElementVisible(WebElement element) {
		letsWait = new WebDriverWait(Driver.getDriver(), 10);
		letsWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void selectByVisibleText(WebElement element, String optionToSelect) {
		letsSelect = new Select(element);
		letsSelect.selectByVisibleText(optionToSelect);
	}

	
}
