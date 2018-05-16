package common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptActions {
    JavascriptExecutor jsexe;
    WebDriver driver;
    public  JavascriptActions(WebDriver driver)
    {

        jsexe=(JavascriptExecutor)driver;
        this.driver=driver;



    }

    public void clickElement(WebElement element)
    {

        jsexe.executeScript("arguments[0].click();", element);

    }

}
