package PageFactory;

import ReportsClass.ExtentTestManager;
import com.aventstack.extentreports.Status;
import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class LoginPF extends BasePage{

@FindBy(xpath="//a[contains(text(),'Log into account')]") WebElement loginButton;
@FindBy(xpath="//a[contains(text(),'Create new account')]") WebElement newAccButton;
    @FindBy(xpath="//input[@name='username']") WebElement usernameField;
    @FindBy(xpath="//input[@name='password']") WebElement passwordField;
    @FindBy(xpath="//button[@type='submit']") WebElement submitButton;

WebDriver driver;
    public LoginPF(WebDriver driver) throws IOException {
    super(driver);
    this.driver=driver;
    }



    public void verifyHomePageLoaded() throws InterruptedException {
        driver.manage().window().maximize();
       boolean present=verifyElementExists(loginButton);
       if(present)
       {
           ExtentTestManager.getTest().log(Status.PASS, "Home page loaded");
       }
    }
    public void clickLogin()
    {

    clickElement(loginButton);
    if(ExtentTestManager.getTest()!=null) //to facilitate calling login from Basetest
    ExtentTestManager.getTest().log(Status.PASS,"Clicked Login Button");
    }
    public void clickNewAcct()
    {
        clickElement(newAccButton);
        ExtentTestManager.getTest().log(Status.PASS,"Clicked Create an Account Button");
    }

public void loginToApp(String uname,String passwd)
{
    usernameField.clear();
    passwordField.clear();
    enterText(usernameField,uname);
    enterText(passwordField,passwd);
    if(ExtentTestManager.getTest()!=null)//to facilitate calling login from Basetest
    ExtentTestManager.getTest().log(Status.PASS,"Entered login Credentials");
}
public void clickSubmit()
{
   clickElement(submitButton);
    if(ExtentTestManager.getTest()!=null)//to facilitate calling login from Basetest
   ExtentTestManager.getTest().log(Status.PASS,"Clicked submit button");
}
}
