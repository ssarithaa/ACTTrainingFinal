package testcases;

import PageFactory.DashboardLandingPF;
import PageFactory.LoginPF;

import common.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import resources.testdata;

import java.io.IOException;

public class Login extends BaseTest {
WebDriver driver;
    LoginPF loginpage;
    DashboardLandingPF dashboardlanding;

    @Test(description = "Verify user is able to load the Home page",priority = 1)
    public void verifyHomepage() throws InterruptedException {
        loginpage.verifyHomePageLoaded();
        loginpage.clickLogin();//Select from login or Create New Account

    }
    @Test(description = "Verify user is not allowed to login with invalid credentials",priority = 2,dataProvider = "invalidcredentials",dataProviderClass = testdata.class)
    public void verifyInvalidLogin(String uname, String passwd) throws InterruptedException {
        loginpage.loginToApp(uname, passwd);
        loginpage.clickSubmit();
        //should display error msg
       // dashboardlanding.isPageLoaded();

    }
    @Test(description = "Verify user is able to login with valid credentials",priority = 3,dataProvider = "validcredentials",dataProviderClass = testdata.class)
    public void verifyValidLogin(String uname, String passwd) throws InterruptedException {

        loginpage.loginToApp(uname,passwd);
        loginpage.clickSubmit();
        dashboardlanding.isPageLoaded();

    }

    @Parameters({"browser","url"})
    @BeforeClass
    public void setUpBefore(String browser,String url) throws IOException {
        sectionName="Login page";
        setDriver(browser);
        driver=getDriver();
        driver.get(url);
        loginpage=new LoginPF(driver);
        dashboardlanding=new DashboardLandingPF(driver);
    }
    @AfterClass
    private void setUpAfter()
    {
        driver.close();
    }

}
