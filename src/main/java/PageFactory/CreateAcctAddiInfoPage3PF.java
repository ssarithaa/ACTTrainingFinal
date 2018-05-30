package PageFactory;

import common.BasePage;
import common.JavascriptActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;

public class CreateAcctAddiInfoPage3PF extends BasePage{
    WebDriver driver;
    JavascriptActions js;
    public CreateAcctAddiInfoPage3PF(WebDriver driver) throws IOException {
                    super(driver);
                    this.driver=driver;
        js=new JavascriptActions(driver);

    }

    //@FindBy(xpath = "//label[@class='form-check-label']") List<WebElement> gender;
    @FindBy(xpath = "//div[@class='list-group-item'][1]//label[@class='form-check-label']") List<WebElement> gender;
    @FindBy(xpath = "//div[@class='list-group-item'][2]//label[@class='form-check-label']") List<WebElement> background;
    @FindBy(xpath = "//div[@class='CheckboxList']//label") List<WebElement> race;
    @FindBy(xpath="//button[@type='submit']") WebElement submitBtn;



    public void enterValues()
    {

        randomOptionClick(gender);
        randomOptionClick(background);
        randomOptionClick(race);


    }
    public void clickContinue()
    {
        js.clickElement(submitBtn);
    }
}
