package testcases;

import PageFactory.*;
import common.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class Registration extends BaseTest {
    WebDriver driver;
    LoginPF loginpage;
    CreateAccountPage1PF createAcct1;
    CreateAcctPersInfoPage2PF createAcctPersInfo2;
    CreateAcctAddiInfoPage3PF createAcctAddiInfo3;
    VerifyAcctCreationPF verifyPage;


    @Test(description = "Verify user is able to load the Create Account page",priority = 1)
    public void verifyCreateAcctpage() throws InterruptedException {
        loginpage.verifyHomePageLoaded();
        loginpage.clickNewAcct();//Select from login or Create New Account
        createAcct1.verifyCreatePageLoaded();
    }
    @Test(description = "Verify user is able to create account with valid information", priority = 2)
    public  void verifyValidInfo() throws InterruptedException {
        createAcct1.enterUserCredentials();
        createAcct1.setTermsCheckbox();
        createAcct1.clickContinueBtn();//continue to enter personal info
        createAcctPersInfo2.enterValue();
        createAcct1.clickContinueBtn();//continue after entering personal info
        createAcctAddiInfo3.enterValues();
        createAcctAddiInfo3.clickContinue();
        verifyPage.verifyAccountCreated();
        verifyPage.continueToLogin();
    }

@Test(description = "Verify user is able to login with the new account", priority = 3)
public void verifyLoginNew()
{
loginpage.loginToApp(CreateAccountPage1PF.emailID,CreateAccountPage1PF.passWd);
loginpage.clickSubmit();
}


    @Parameters({"browser","url"})
    @BeforeClass
    public void setUpBefore(String browser,String url) throws IOException {
        sectionName="Create new Account";
        setDriver(browser);
        driver=getDriver();
        driver.get(url);
        createAcct1=new CreateAccountPage1PF(driver);
        createAcctPersInfo2=new CreateAcctPersInfoPage2PF(driver);
        createAcctAddiInfo3=new CreateAcctAddiInfoPage3PF(driver);
        loginpage=new LoginPF(driver);
        verifyPage=new VerifyAcctCreationPF(driver);
    }
    @AfterClass
    private void setUpAfter()
    {
     //driver.close();
    }

}
