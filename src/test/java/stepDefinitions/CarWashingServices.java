package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pom.CarWashingServicesPage;
import testBases.BaseClass;
import testBases.Excel;

public class CarWashingServices extends BaseClass {
	
	@Given("User is on the homepage of justdial")
	public void user_is_on_the_homepage_of_justdial() throws InterruptedException {
		CarWashingServicesPage cw=new CarWashingServicesPage(driver);
		Thread.sleep(3000);
		cw.pop_up1();
		Assert.assertEquals(cw.logo_validate(),"Justdial");
	}

	@When("user sends location and services {string} required")
	public void user_sends_location_and_services_required(String string) throws InterruptedException {
		CarWashingServicesPage cw=new CarWashingServicesPage(driver);
		cw.loc();
		cw.click_loc();		
		cw.service().sendKeys(string);
		Thread.sleep(3000);
		cw.click_service();
	}

	@When("after selecting rating")
	public void after_selecting_rating() {
		CarWashingServicesPage cw=new CarWashingServicesPage(driver);
		cw.ratings_filter();
		cw.select_rating();
	}

	@Then("all the five services are printed")
	public void all_the_five_services_are_printed() throws IOException, InterruptedException {
		CarWashingServicesPage cw=new CarWashingServicesPage(driver);
		System.out.println("The first 5 shops with rating > 4 and customer ratings > 20 are: ");
		BaseClass.screenshot("services_numbers");
		for(int i=0;i<5;i++) {
			float c=Float.parseFloat(cw.ratings().get(i));
			int cust_votes=cw.customer_ratings().get(i);
			if(c>4 && cust_votes>20) {
				String shop_name=cw.shop_names().get(i);
				String phone_number=cw.phone_number().get(i);
				System.out.print((i+1)+"."+shop_name+" with rating "+c+" and customer ratings "+cust_votes+"----->");
				System.out.println(phone_number);
				Excel.setCellData("c_services_phonenumbers",0,0,"SERVICES");
				Excel.setCellData("c_services_phonenumbers",0,1,"PHONE_NUMBERS");
				Excel.setCellData("c_services_phonenumbers",i+1,0,shop_name);
				Excel.setCellData("c_services_phonenumbers",i+1,1,phone_number);
			}
		}
	}

}
