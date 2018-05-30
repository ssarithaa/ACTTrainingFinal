package listeners;

import com.aventstack.extentreports.Status;
import ReportsClass.ExtentManager;
import ReportsClass.ExtentTestManager;
import common.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListener extends BaseTest implements ITestListener{



    @Override
    public void onTestStart(ITestResult iTestResult) {
        ExtentTestManager.startTest(sectionName+"-" +iTestResult.getMethod().getDescription(), iTestResult.getMethod().getMethodName());


    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

        ExtentTestManager.getTest().log(Status.PASS, "Test passed");

    }

    @Override
    public void onTestFailure(ITestResult iTestResult)   {
        ExtentTestManager.getTest().log(Status.FAIL, iTestResult.getThrowable());

        Object obj=iTestResult.getInstance();
        WebDriver driver= null;
        try {
            driver = ((BaseTest)obj).getDriver();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String destFile;
        File srcfile = null;
        srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        destFile="C:/Users/saritha.pattathil/TestScreenshots/" + sectionName + ".png";
        try {
            FileUtils.copyFile(srcfile, new File(destFile));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            ExtentTestManager.getTest().addScreenCaptureFromPath(destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        ExtentManager.getReporter().flush();

    }
}
