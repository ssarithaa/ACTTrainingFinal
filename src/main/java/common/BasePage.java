package common;

import ReportsClass.ExtentTestManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import sun.plugin.util.UIUtil;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class BasePage {

WebDriver driver;

    public BasePage(WebDriver driver) throws IOException {
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    protected boolean verifyElementExists(WebElement element)
    {
        boolean present=false;
        if(element!=null) {
            if (element.isDisplayed())

                present = true;
            else
                present = false;
        }
        return present;
    }


    protected void clickElement(WebElement element)
    {
    if (element!=null)
    {
            element.click();
    }

    }

    protected void enterText(WebElement element, String valueToEnter)
    {
        if(element!=null)
        element.sendKeys(valueToEnter);

    }

    protected void fillAllEntries(String valuesPassed[][])
    {
    for (String data[]:valuesPassed)
    {
        WebElement element=driver.findElement(By.xpath(data[0]));
        String valueToEnter=data[1];
        element.sendKeys(valueToEnter);

    }
    }
protected void randomOptionClick(List<WebElement> elementList)
{
    Random random=new Random();
    int randomNumber= random.nextInt(elementList.size());
    elementList.get(randomNumber).click();
    ExtentTestManager.getTest().log(Status.PASS, "Random option selected");
}

}
