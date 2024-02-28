package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.GymPage;
import testBases.BaseClass;
import testBases.Excel;

public class Gym extends BaseClass{
	@Given("user moves to homepage")
	public void user_moves_to_homepage() {
		GymPage gp=new GymPage(driver);
		gp.navigate_back();
	}

	@When("clicks on gym icon in homepage")
	public void clicks_on_gym_icon_in_homepage() throws InterruptedException {
		GymPage gp=new GymPage(driver);
		Thread.sleep(3000);
		gp.gym();
	}

	@Then("the sub-menu items are printed")
	public void the_sub_menu_items_are_printed() throws IOException {
		GymPage gp=new GymPage(driver);
		System.out.println("Sub-menu in the gym are: ");
		for(int i=0;i<gp.sub_menu_size();i++) {
			System.out.println((i+1)+"."+gp.sub_menu().get(i));
			Excel.setCellData("c_Sub-menu",0,0,"Sub-menu_items");
			Excel.setCellData("c_Sub-menu",i+1,0,gp.sub_menu().get(i));
		}
	}
}
