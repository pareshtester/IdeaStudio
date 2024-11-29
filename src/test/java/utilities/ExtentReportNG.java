package utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BaseClass;

public  class ExtentReportNG extends BaseClass {
	private static ExtentReports extent;
	private static ExtentSparkReporter spark;
	
	public static ExtentReports settReport()
	{
		if(extent==null)
		{ CreateFile file = new CreateFile();
		  File newFile = file.fileSetup();
			//File f = new File(path+"/ExtentReports/test.html");
		    spark = new ExtentSparkReporter(newFile);
		    spark.config().setTheme(Theme.DARK);
		    spark.config().setReportName("Automation Report");
		    spark.config().setDocumentTitle("Website status Test Report");
		    extent = new ExtentReports();
		    try {
		    extent.attachReporter(spark);
		    extent.setSystemInfo("Envirionment is:",System.getProperty("user.name"));
		    extent.setSystemInfo("OS is:", System.getProperty("os,name"));
		    }catch(Exception e)
		    {
		    	e.getStackTrace();
		    }
		}
		return extent;
	}
	
	
}
