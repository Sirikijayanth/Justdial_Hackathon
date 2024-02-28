package pom;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarWashingServicesPage extends BasePage{
	
	public CarWashingServicesPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[text()='Maybe Later']")
	WebElement pop_up1;
	
	@FindBy(xpath="//a[@role='link']/img")
	WebElement logo;
	
	@FindBy(xpath="//*[@id=\"city-auto-sug\"]")
	WebElement loc;
	
	@FindBy(xpath="//div[text()='Detect Location']")
	WebElement click_loc;
	
	@FindBy(xpath="//div/input[@id='main-auto']")
	WebElement service;
	
	@FindBy(xpath="//div[@class='search_text font14 fw400 color111']")
	WebElement click_service;
	
	@FindBy(xpath="//li/div/div[text()='Ratings']")
	WebElement ratings_filter;
	
	@FindBy(xpath="//span[text()='4.0+']")
	WebElement select_rating;
	
	@FindBy(xpath="//h1[contains(text(),'Car Washing Services')]")
	WebElement search_page_title;
	
	@FindBy(xpath="//a[contains(@class,'resultbox_title')]")
	List<WebElement> shop_names;
	
	@FindBy(xpath="//div[contains(@class,'resultbox_totalrate')]")
	List<WebElement> ratings;
	
	@FindBy(xpath="//div[text()='Ratings']")
	List<WebElement> customer_ratings;
	
	@FindBy(xpath="//span[contains(@class,'callcontent')]")
	List<WebElement> phone_number;
	
	public void pop_up1() {
		try {
			pop_up1.click();
		}
		catch(Exception e) {
		}
	}
	public String logo_validate() {
		return logo.getDomAttribute("title");
	}
	public void loc() throws InterruptedException{
		loc.clear();
		Thread.sleep(5000);
		loc.click();
	}
	public void click_loc() throws InterruptedException {
		click_loc.click();
		Thread.sleep(5000);
	}
	public WebElement service() {
		service.clear();
		return service;
	}
	public void click_service() {
		click_service.click();
	}
	public void ratings_filter() {
		ratings_filter.click();
	}
	public void select_rating() {
		select_rating.click();
	}
	public String search_page_title() {
		String full_title=search_page_title.getText();
		String title=full_title.substring(4,full_title.indexOf(" in"));
		return title;
	}
	public List<String> shop_names() {
		List<String> shop_list=new ArrayList<String>();
		for(int i=0;i<5;i++) {
			shop_list.add(shop_names.get(i).getText());
		}
		return shop_list;
	}
	public List<String> ratings(){
		List<String> ratings_list=new ArrayList<String>();
		for(int i=0;i<5;i++) {
			String ratings_string=ratings.get(i).getText();
			ratings_list.add(ratings_string);
		}
		return ratings_list;
	}
	public List<Integer> customer_ratings() {
		List<Integer> list_cust_votes=new ArrayList<Integer>();
		for(int i=0;i<5;i++) {
			String cust_rating=customer_ratings.get(i).getText();
			String cust_num_rating=cust_rating.substring(0,cust_rating.indexOf(" "));
			list_cust_votes.add(Integer.parseInt(cust_num_rating));	
		}
		return list_cust_votes;
	}
	public List<String> phone_number() throws InterruptedException{
		List<String> ph_num_list=new ArrayList<String>();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		for(int i=0;i<5;i++) {
			String text=phone_number.get(i).getText();
			String exp_txt="Show Number";
			if(text.equalsIgnoreCase(exp_txt)){
				
				js.executeScript("arguments[0].click();",phone_number.get(i));
				Thread.sleep(5000);
				ph_num_list.add(phone_number.get(i).getText());
			}
			else{
				ph_num_list.add(phone_number.get(i).getText());
			}
		}
		return ph_num_list;
	}
	public List<WebElement> scrolling() {
		return shop_names;
	}
}
