package testCases;

import java.io.IOException;
import org.testng.annotations.Test;

import pom.FreeListingPage;
import testBases.BaseClass;

public class FreeListing extends BaseClass{
	
	@Test(groups={"sanity","master"})
	public void freelisting() throws InterruptedException, IOException {
		FreeListingPage fl=new FreeListingPage(driver);
		fl.free_listing();
		BaseClass.screenshot("Freelisting");
		fl.mobile_number();
		Thread.sleep(4000);
		BaseClass.screenshot("Mobile_number");
		fl.start();
		BaseClass.screenshot("Error_msg");
		String error=fl.error();
		System.out.println("Error message displayed: "+error);	
	}
}
