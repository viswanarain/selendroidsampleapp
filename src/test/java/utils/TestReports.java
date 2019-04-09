package utils;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
 
public class TestReports
{
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;
     
    @BeforeSuite
    public void setUp()
    {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/MyOwnReport.html");
        System.out.println("***************Reports Path*****************");
        System.out.println(System.getProperty("user.dir") +"/test-output/MyOwnReport.html");
        System.out.println("*********************************************");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
         
        extent.setSystemInfo("OS", "Android");
        extent.setSystemInfo("Host Name", "MAC");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "vis");
         
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("DEMO REPORT");
        htmlReporter.config().setReportName("SUITE STATUS REPORT");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        //htmlReporter.config().setTheme(Theme.DARK);
    }
     
    @AfterMethod
    public void getResult(ITestResult result)
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
        	CommonUtils.takeScreenShot();
        	test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
            test.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        }
        else
        {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.YELLOW));
            test.skip(result.getThrowable());
        }
    }
     
    @AfterSuite
    public void tearDown()
    {
        extent.flush();
    }
}
