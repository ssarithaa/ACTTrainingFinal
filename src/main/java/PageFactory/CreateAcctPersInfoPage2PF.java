package PageFactory;

import ReportsClass.ExtentTestManager;
import com.aventstack.extentreports.Status;
import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class CreateAcctPersInfoPage2PF extends BasePage {

    WebDriver driver;


    public CreateAcctPersInfoPage2PF(WebDriver driver) throws IOException {
        super(driver);
        this.driver=driver;
    }

    public void enterValue()
    {
        String valuesToEnter[][]={
                                  {"//input[@name='firstName']","newfname"},{"//input[@name='lastName']","newlname"},{"//input[@name='birthDate']","10102000"},
                                  {"//textarea[@id='registerAddress']","MyAddress"},{"//input[@name='postalCode']","55555"},
                                  {"//input[@name='cellPhone']","7209887987"},{"//input[@name='cellPhone']","7107868767"}
                                  };
        fillAllEntries(valuesToEnter);
        ExtentTestManager.getTest().log(Status.PASS, "All values entered");
    }
    }
