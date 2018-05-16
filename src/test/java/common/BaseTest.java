package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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

        protected WebDriver getDriver() throws IOException {
            if (this.driver == null) {
                this.setDriver(null);
            }

            return this.driver;

        }

    }

