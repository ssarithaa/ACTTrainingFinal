package PageFactory;

import ReportsClass.ExtentTestManager;
import com.aventstack.extentreports.Status;
import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public class AccInfoUSCitizenshipPF extends BasePage {
    WebDriver driver;
    public AccInfoUSCitizenshipPF(WebDriver driver) throws IOException {
        super(driver);
        this.driver=driver;
    }
@FindBy(xpath="//div[@class='list-group-item']//child::label")
List<WebElement> optionBtns;
 @FindBy(xpath="//button[contains(text(),'Continue')]") WebElement continueBtn;
 @FindBy(xpath="//div[@class='file-upload-dropzone']") WebElement uploadBtn;


    public void selectNotCitizen()
    {
        clickElement(optionBtns.get(1));
        ExtentTestManager.getTest().log(Status.PASS, "Clicked on No for US Citizen");
    }
    public void selectYesI9Filed()
    {
        clickElement(optionBtns.get(2));
        ExtentTestManager.getTest().log(Status.PASS, "Clicked on Yes for I-9 Uploaded");
    }
    public void uploadFile() throws IOException {
       Runtime.getRuntime().exec("E:/Automation/Training/autoscript.exe");
        ExtentTestManager.getTest().log(Status.PASS, "File loaded executing the AutoIT script");
    }
    public void clickUploadBtn()
    {

        clickElement(uploadBtn);
        ExtentTestManager.getTest().log(Status.PASS, "Clicked on upload button");
    }
    public void clickContinueBtn()
    {

        clickElement(continueBtn);
        ExtentTestManager.getTest().log(Status.PASS, "Clicked on Continue button");
    }

}
