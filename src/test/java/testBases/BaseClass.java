package testBases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public static Logger logger;
	@BeforeTest(groups= {"sanity","regression","master"})
	@Parameters("browser")
	public void driversetup(String br) {
		if(br.equalsIgnoreCase("chrome")){
			ChromeOptions croptions=new ChromeOptions();
			croptions.addArguments("--disable-blink-features=AutomationControlled");
			croptions.addArguments("--disable-notifications");
			driver=new ChromeDriver(croptions);
		}
		else if(br.equalsIgnoreCase("edge")) {
			EdgeOptions edoptions=new EdgeOptions();
			edoptions.addArguments("--disable-blink-features=AutomationControlled");
			edoptions.addArguments("--disable-notifications");
			driver=new EdgeDriver(edoptions);
		}
		driver.get("https://www.justdial.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
	}
	
	@AfterTest(groups= {"sanity","regression","master"})
	public void quit() {
		driver.quit();
	}

	public static String screenshot(String name) throws IOException {
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File src=screenshot.getScreenshotAs(OutputType.FILE);
		File trg=new File("C:\\Users\\2304129\\eclipse-workspace\\new\\screenshots\\"+name+".png");
		FileUtils.copyFile(src, trg);
		return "C:\\Users\\2304129\\eclipse-workspace\\new\\screenshots"+name+".png";
	}
}
