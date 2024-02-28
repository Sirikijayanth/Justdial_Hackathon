package stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import testBases.BaseClass;

public class Hooks extends BaseClass{
	public static WebDriver driver;
	
	@BeforeAll
	public static void setup() {
		BaseClass bc=new BaseClass();
		bc.driversetup("chrome");
	}
	
	@AfterAll
	public static void tearDown() {
		BaseClass bc=new BaseClass();
		bc.quit();
	}
	
	@AfterStep
	public static void cucumberscreenshot(Scenario scenario) {
		driver=BaseClass.driver;
		TakesScreenshot ts=(TakesScreenshot) driver;
        byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png",scenario.getName());
	}

}