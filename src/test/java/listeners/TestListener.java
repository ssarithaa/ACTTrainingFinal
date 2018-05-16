package listeners;

import com.aventstack.extentreports.Status;
import ReportsClass.ExtentManager;
import ReportsClass.ExtentTestManager;
import common.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

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
    public void onTestFailure(ITestResult iTestResult) {
        ExtentTestManager.getTest().log(Status.FAIL, iTestResult.getThrowable());
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
