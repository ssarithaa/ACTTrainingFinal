package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

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


}
