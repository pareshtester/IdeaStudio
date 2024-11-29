package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseClass;

public class ExtentListener extends BaseClass implements ITestListener {

	 ExtentReports extent = ExtentReportNG.settReport();
	 ExtentTest test;
	private static  ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		WebDriver driver =null;
		extentTest.get().log(Status.PASS, "Success");
		Object obj = result.getInstance();
		if(obj instanceof BaseClass)
		{
			driver = ((BaseClass)obj).getdriver();
		}
		
		if(driver!=null)
		{
			try {
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(result.getMethod().getMethodName(), driver), result.getMethod().getMethodName());
			}catch(Exception e)
			{
				e.getStackTrace();
			}
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		WebDriver driver = null;
		Object obj = result.getInstance();
		if(obj instanceof BaseClass)
		{
			driver = ((BaseClass)obj).getdriver();
		}
		if(driver!=null)
		{
			try {
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(result.getMethod().getMethodName(), driver), result.getMethod().getMethodName());
			}catch(Exception e)
			{
				e.getStackTrace();
			}
		}
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}
	
	
	
	

}
