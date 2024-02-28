package pom;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GymPage extends BasePage{

	public GymPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[contains(@class,'header_logo')]/img")
	WebElement logo;
	
	@FindBy(xpath="//a[contains(@title,'Gym in')]/div/span")
	WebElement gym;
	
	@FindBy(xpath="//ul[@id='filter_ul']/li")
	List<WebElement> sub_menu;
	
	public void navigate_back() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", logo);
	}
	public void gym() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)");
		js.executeScript("arguments[0].click();",gym);
	}
	public int sub_menu_size() {
		return sub_menu.size();
	}
	public List<String> sub_menu() {
		List<String> gym_menu=new ArrayList<String>();
		for(int i=0;i<sub_menu.size();i++) {
			gym_menu.add(sub_menu.get(i).getText());
		}
		return gym_menu;
	}
}
