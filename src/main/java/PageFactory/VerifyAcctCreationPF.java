package PageFactory;

import ReportsClass.ExtentTestManager;
import com.aventstack.extentreports.Status;
import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class VerifyAcctCreationPF extends BasePage {
    WebDriver driver;
    public VerifyAcctCreationPF(WebDriver driver) throws IOException {
      super(driver);
      this.driver=driver;
    }
    @FindBy(xpath="//a[contains(text(),'Continue')]")
    WebElement continueBtn;
    @FindBy(xpath="//div[@class='success-icon']") WebElement successIcon;
    public void verifyAccountCreated()
    {
        if(verifyElementExists(successIcon))
        {
            ExtentTestManager.getTest().log(Status.PASS, "Account successfully created");
        }
    }

    public void continueToLogin()
    {
        clickElement(continueBtn);
        ExtentTestManager.getTest().log(Status.PASS, "Clicked continue button");
    }
}
