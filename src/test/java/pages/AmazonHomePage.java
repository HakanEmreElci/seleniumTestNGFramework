package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonHomePage {
	
	public AmazonHomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	// if you work with element id, we just create an element abstract object .
	public WebElement twotabsearchtextbox;
	
	@FindBy(id = "nav-search-submit-button") // if the id/class gives you hard time, you can use this annotation this way to find it :)
	public WebElement searchButton;
	
	@FindBy(xpath = "//a[text() = 'Sign in securely']")
	public WebElement signInButton;
	
	@FindBy(id = "searchDropdownBox")
	public WebElement departmentsDropdown;
	
	@FindBy(xpath = "//div[@data-component-type = 's-search-result']//span[@class = 'a-price-whole']")
	public List<WebElement> searchItemPrices;
	
	@FindBy(xpath  = "//span[@class= 'a-color-state a-text-bold']")
	public WebElement coffeeMugText;
	
	@FindBy(xpath = "//span[@class= 'a-color-state a-text-bold']")
	public WebElement prettyCoffeeMug;

}
