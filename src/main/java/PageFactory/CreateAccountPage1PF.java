package PageFactory;

import ReportsClass.ExtentTestManager;
import com.aventstack.extentreports.Status;
import common.BasePage;
import common.JavascriptActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class CreateAccountPage1PF extends BasePage {
    WebDriver driver;
    public CreateAccountPage1PF(WebDriver driver) throws IOException {
    super(driver);
    this.driver=driver;
    js=new JavascriptActions(this.driver);
    }


    @FindBy(xpath = "//h4[contains(text(),'Create an ACT account')]") WebElement pageHeader;
    @FindBy(xpath="//input[@id='emailAddress']") WebElement emailField;
    @FindBy(xpath="//input[@name='password']") WebElement passwdField;
    @FindBy(xpath="//input[@id='termsAgreement']") WebElement termsCheckbox;
    @FindBy(xpath="//button[contains(text(),'Continue create account')]") WebElement continueBtn;


    JavascriptActions js;


    public void verifyCreatePageLoaded() throws InterruptedException {

        boolean present=verifyElementExists(pageHeader);
        if(present)
        {
            ExtentTestManager.getTest().log(Status.PASS, "Create Account page loaded");
        }
    }
    public void enterUserCredentials()
    {
        enterText(emailField,"saritha@gmail.com");
        enterText(passwdField,"Sarithagmail1!");
        ExtentTestManager.getTest().log(Status.PASS, "Entered new user credentials");

    }
    public  void setTermsCheckbox()
    {

         js.clickElement(termsCheckbox);
        ExtentTestManager.getTest().log(Status.PASS, "Check Terms and Conditions");
    }
    public  void clickContinueBtn()
    {

       js.clickElement(continueBtn);
        ExtentTestManager.getTest().log(Status.PASS, "Click on Continue button");
    }

}
