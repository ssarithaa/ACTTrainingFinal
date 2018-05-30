package PageFactory;

import ReportsClass.ExtentTestManager;
import com.aventstack.extentreports.Status;
import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class DashboardLandingPF extends BasePage {
    public DashboardLandingPF(WebDriver driver) throws IOException {
        super(driver);
    }

    @FindBy(xpath = "//h4[contains(text(),'Hi')]")
    WebElement welcomeText;
    @FindBy(xpath="//a[contains(text(),'profile')]") WebElement profileLink;


    public void isPageLoaded() {
        if (verifyElementExists(welcomeText)) {
            ExtentTestManager.getTest().log(Status.PASS, "Logged in successfully");
        }
    }
public void clickProfileLink()
{
    clickElement(profileLink);
    ExtentTestManager.getTest().log(Status.PASS, "Clicked on 'Complete your profile' link");
}

}

