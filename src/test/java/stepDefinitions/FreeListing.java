package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.FreeListingPage;
import testBases.BaseClass;

public class FreeListing extends BaseClass{
	
	@Given("user clicks on freelisting icon")
	public void user_clicks_on_freelisting_icon() {
		FreeListingPage fl=new FreeListingPage(driver);
		fl.free_listing();
	}

	@When("invalid mobile number is passed and clicks on startnow icon")
	public void invalid_mobile_number_is_passed() throws InterruptedException {
		FreeListingPage fl=new FreeListingPage(driver);
		fl.mobile_number();
		Thread.sleep(4000);
		fl.start();
	}

	@Then("the error message is validated")
	public void the_error_message_is_validated() {
		FreeListingPage fl=new FreeListingPage(driver);
		String error=fl.error();
		System.out.println("Error message displayed: "+error);
	}
}
