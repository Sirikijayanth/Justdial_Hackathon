package testCases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.CarWashingServicesPage;
import testBases.BaseClass;
import testBases.Excel;

public class CarWashingServices extends BaseClass{
	
	@Test(priority=1,groups={"sanity","master"})
	public void loc_service() throws InterruptedException, IOException {
		CarWashingServicesPage cw=new CarWashingServicesPage(driver);
		Thread.sleep(3000);
		cw.pop_up1();
		BaseClass.screenshot("Homepage");
		Assert.assertEquals(cw.logo_validate(),"Justdial");
		System.out.println("Homepage is validated");
		cw.loc();
		cw.click_loc();		
		cw.service().sendKeys("car washing services");
		Thread.sleep(3000);
		BaseClass.screenshot("After_loc_services");
		cw.click_service();
		
	}
	
	@Test(priority=2,groups={"sanity","master"})
	public void filter() throws IOException, InterruptedException{
		CarWashingServicesPage cw=new CarWashingServicesPage(driver);
		String actual_title=cw.search_page_title();
		String exp_title="Car Washing Services";
		Assert.assertEquals(actual_title,exp_title);
		cw.ratings_filter();
		cw.select_rating();
		Thread.sleep(3000);
		BaseClass.screenshot("After_ratings");
	}
	
	@Test(priority=3,groups={"regression","master"})
	public void display_services_numbers() throws InterruptedException, IOException {
		CarWashingServicesPage cw=new CarWashingServicesPage(driver);
		System.out.println("The first 5 shops with rating > 4 and customer ratings > 20 are: ");
		for(int i=0;i<5;i++) {
			float c=Float.parseFloat(cw.ratings().get(i));
			int cust_votes=cw.customer_ratings().get(i);
			if(c>4 && cust_votes>20) {
				String shop_name=cw.shop_names().get(i);
				String phone_number=cw.phone_number().get(i);
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].scrollIntoView();",cw.scrolling().get(i));
				System.out.print((i+1)+"."+shop_name+" with rating "+c+" and customer ratings "+cust_votes+"----->");
				System.out.println(phone_number);
				Excel.setCellData("services_phonenumbers",0,0,"SERVICES");
				Excel.setCellData("services_phonenumbers",0,1,"PHONE_NUMBERS");
				Excel.setCellData("services_phonenumbers",i+1,0,shop_name);
				Excel.setCellData("services_phonenumbers",i+1,1,phone_number);
			}
		}
		BaseClass.screenshot("services_numbers");
	}
}
