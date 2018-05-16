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


    public void isPageLoaded() {
        if (verifyElementExists(welcomeText)) {
            ExtentTestManager.getTest().log(Status.PASS, "Logged in successfully");
        }
    }
}

