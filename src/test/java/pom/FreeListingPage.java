package pom;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FreeListingPage extends BasePage{

	public FreeListingPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//li/a/div[text()='Free Listing']")
	WebElement free_listing;
	
	@FindBy(name="pincode")
	WebElement mobile_number;
	
	@FindBy(xpath="//button[text()='Start Now ']")
	WebElement start;
	
	@FindBy(xpath="//span[contains(@class,'undefined entermobilenumber')]")
	WebElement error;
	
	public void free_listing() {
		JavascriptExecutor javascript=(JavascriptExecutor)driver;
		javascript.executeScript("arguments[0].click();", free_listing);
	}
	public void mobile_number() {
		String mobile_num=RandomStringUtils.randomNumeric(1, 9);
		mobile_number.sendKeys(mobile_num);
	}
	public void start() {
		start.click();
	}
	public String error() {
		return error.getText();
	}

}
