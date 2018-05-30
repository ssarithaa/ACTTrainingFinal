package ReportsClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.util.HashMap;
import java.util.Map;




    public class ExtentTestManager {
        static Map extentTestMap = new HashMap();
        static ExtentReports extent = ReportsClass.ExtentManager.getReporter();

        public static synchronized ExtentTest getTest() {
            return (ExtentTest)extentTestMap.get((int) (long) (Thread.currentThread().getId()));
        }

        public static synchronized void endTest() {
            //extent.removeTest((ExtentTest)extentTestMap.get((int) (long) (Thread.currentThread().getId()))); // replaced endtest
            //extent.endTest((ExtentTest)extentTestMap.get((int) (long) (Thread.currentThread().getId()))); // replaced endtest
        }

        public static synchronized ExtentTest startTest(String testName, String desc) {
            ExtentTest test = extent.createTest(testName, desc);
            extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
            return test;
        }


    }


