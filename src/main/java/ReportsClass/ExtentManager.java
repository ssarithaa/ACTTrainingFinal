package ReportsClass;

//OB: ExtentReports extent instance created here. That instance can be reachable by getReporter() method.


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {

    private static ExtentReports extent;
    private static ExtentHtmlReporter htmlReporter;


    public synchronized static ExtentReports getReporter(){
        if(extent == null){
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir"); // Should make this a constant
            //extent = new ExtentReports(workingDir+"\\ExtentReports\\ExtentReportResults.html", true);

            //extent = new ExtentReports("C:\\Users\\steven.baron\\cyber-cube\\Autobot4\\src\\main\\java\\reports\\MyExtentReport.html",true);
            //extent.loadConfig(new File("C:\\Users\\steven.baron\\cyber-cube\\Autobot4\\src\\main\\resources\\reportconfig\\extent-config.xml"));

            String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
//            String nameWTimeStamp = workingDir +"/main-output/act-functionality-tests-report_"+timeStamp+".html";
            String nameNoStamp = workingDir +"/Reports/act-functionality-tests-report.html";



            htmlReporter = new ExtentHtmlReporter(nameNoStamp);
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);


            htmlReporter.config().setChartVisibilityOnOpen(true);
            htmlReporter.config().setDocumentTitle("ACT Automation testing report");
            htmlReporter.config().setReportName("ACT Report");
            htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
            htmlReporter.config().setTheme(Theme.DARK);

        }
        return extent;
    }
}