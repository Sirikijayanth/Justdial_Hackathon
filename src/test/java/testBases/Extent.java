package testBases;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extent implements ITestListener {
	public ExtentSparkReporter sparkReporter;  // UI of the report
	public ExtentReports extent;  //populate common info on the report
	public ExtentTest test; // creating test case entries in the report and update status of the test methods

	public void onStart(ITestContext context) {
		sparkReporter=new ExtentSparkReporter("C:\\Users\\2304081\\eclipse-workspace\\Hackathon_Project\\reports");//specify location of the report
		sparkReporter.config().setDocumentTitle("Automation Report"); // TiTle of report
		sparkReporter.config().setReportName("Justdial"); // name of the report
		sparkReporter.config().setTheme(Theme.STANDARD);//Theme of report
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Computer Name","localhost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("Tester Name","Rishika");
		extent.setSystemInfo("os","Windows10");
		extent.setSystemInfo("Browser name","Chrome,Edge");
					
	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName()); // create a new entry in the report or new test
		try {
			String img=BaseClass.screenshot(result.getName());
			test.addScreenCaptureFromPath(img);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());	
		try {
			String img=BaseClass.screenshot(result.getName());
			test.addScreenCaptureFromPath(img);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {

		test = extent.createTest(result.getName());
		try {
			String img=BaseClass.screenshot(result.getName());
			test.addScreenCaptureFromPath(img);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	
	public void onFinish(ITestContext context) {
		extent.flush();
	}
		

}
