package GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * this class provides implementation to ITestListeners Interface of TestNG
 * @author Snehal
 */
public class ListenersImplementation implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		//for every @Test --> test method
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" --- test execution started----");
		
		//Intimation of Test Execution to extent reports
		test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//For @Test is passes
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" --- test execution success----");
		
		//log the test status
		test.log(Status.PASS, methodName+" --- test execution success----");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" --- test execution failed----");
		
		//Print Exception for failure
		System.out.println(result.getThrowable());
		
		//log the test status as fail in extent reports
		test.log(Status.FAIL, methodName+" --- test execution failed----");
		test.log(Status.INFO, result.getThrowable());
		
		//For capturing the screenshot
		SeleniumUtility s = new SeleniumUtility();
		JavaUtility j = new JavaUtility();
		String screenshotName = methodName+"-"+j.getSystemDate();
		
		try {
			String path = s.captureScreenshot(BaseClass.sdriver, screenshotName);
			//attach screenshot to extent reports
			test.addScreenCaptureFromPath(path);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" --- test execution skipped ----");
		
		//Print the exception for failure
		System.out.println(result.getThrowable());
		
		//log the status as skip in extent reports
		test.log(Status.SKIP, methodName+" --- test execution skipped ----");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("------Suite execution started------");
		
		//Basic configuration of extent reports
		ExtentSparkReporter htmlRep = new ExtentSparkReporter(".\\ExtentReports\\Report - "+new JavaUtility().getSystemDate());
		htmlRep.config().setDocumentTitle("Execution Report");
		htmlRep.config().setTheme(Theme.DARK);
		htmlRep.config().setReportName("VTiger Execution report");
		
		//Set system info inside extent reports
		report = new ExtentReports();
		report.attachReporter(htmlRep);
		report.setSystemInfo("Base Platform","windows" );
		report.setSystemInfo("Base Browser", "Edge");
		report.setSystemInfo("Base Environment","Testing" );
		report.setSystemInfo("Reporter Name","Snehal" );
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("------Suite execution Finished------");
	}
	

}
