package PageFactory;

import ReportsClass.ExtentTestManager;
import com.aventstack.extentreports.Status;
import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class ProfilePagePF extends BasePage {

    public ProfilePagePF(WebDriver driver) throws IOException {
        super(driver);
        this.driver=driver;

    }
    WebDriver driver;
    @FindBy(xpath="//span[contains(text(),'Education')]")
    WebElement expandButton;
    @FindBy(xpath="//span[contains(text(),'Education')]//following::button[contains(text(),'Update')][1]") WebElement updateButton;

public void clickExpandButton()
{
    clickElement(expandButton);
    ExtentTestManager.getTest().log(Status.PASS, "Clicked on Expand button");
}

public  void  clickUpdateButton()
{
    clickElement(updateButton);
    ExtentTestManager.getTest().log(Status.PASS, "Clicked on 'Update Information' button");
}
}

