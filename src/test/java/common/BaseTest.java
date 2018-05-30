package common;

import PageFactory.LoginPF;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

        private WebDriver driver;
        protected static String sectionName;


        protected void setDriver(String browser) throws IOException {

            switch (browser.toLowerCase()) {
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", "C:/Users/saritha.pattathil/geckodriver.exe");
                    this.driver = new FirefoxDriver();
                    this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "chrome":
                    System.setProperty("webdriver.chrome.driver","C:/Users/saritha.pattathil/chromedriver.exe");
                    this.driver = new ChromeDriver();
                    this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                default:
                    System.out.println("Unsupported browser");

            }

        }

        public WebDriver getDriver() throws IOException {
            if (this.driver == null) {
                this.setDriver(null);
            }

            return this.driver;

        }

    public void loginToApp(String userName, String passWd) throws IOException {
        LoginPF loginpage=new LoginPF(driver);
       loginpage.clickLogin();

        loginpage.loginToApp(userName,passWd);
        loginpage.clickSubmit();
    }


        }



