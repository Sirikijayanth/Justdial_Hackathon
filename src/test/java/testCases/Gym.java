package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pom.GymPage;
import testBases.BaseClass;
import testBases.Excel;

public class Gym extends BaseClass {
	
	@Test(groups= {"regression","master"})
	public void gym() throws InterruptedException, IOException {
		GymPage gp=new GymPage(driver);
			gp.navigate_back();
			BaseClass.screenshot("Back_to_hp");
			gp.gym();
			System.out.println("Sub-menu in the gym are: ");
			Thread.sleep(3000);
			BaseClass.screenshot("Sub-menu");
			for(int i=0;i<gp.sub_menu_size();i++) {
				System.out.println((i+1)+"."+gp.sub_menu().get(i));
				Excel.setCellData("Sub-menu",0,0,"SUB_MENU ITEMS");
				Excel.setCellData("Sub-menu",i+1,0,gp.sub_menu().get(i));
			}
		
	}
	
}
