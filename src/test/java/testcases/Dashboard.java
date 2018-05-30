package testcases;

import PageFactory.AccInfoUSCitizenshipPF;
import PageFactory.DashboardLandingPF;
import PageFactory.LoginPF;
import PageFactory.ProfilePagePF;
import common.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import resources.testdata;

import java.io.IOException;

public class Dashboard extends BaseTest {

WebDriver driver;
DashboardLandingPF dashboardLanding;
ProfilePagePF profilePage;
AccInfoUSCitizenshipPF usCitizenshipPage;

@Test(description = "Verify 'Complete my profile' option working")
public void completeProfile() throws IOException {
dashboardLanding.isPageLoaded();
dashboardLanding.clickProfileLink();
profilePage.clickExpandButton();
profilePage.clickUpdateButton();
usCitizenshipPage.selectNotCitizen();
usCitizenshipPage.selectYesI9Filed();
usCitizenshipPage.clickUploadBtn();
usCitizenshipPage.uploadFile();
usCitizenshipPage.clickContinueBtn();

}



    @Parameters({"browser","url","userName","passWd"})
    @BeforeTest
    public void setUpBefore(String browser, String url, String userName, String passWd) throws IOException {
    sectionName="Complete your Profile";
    setDriver(browser);
    driver=getDriver();
    driver.get(url);
    loginToApp(userName,passWd);
    dashboardLanding=new DashboardLandingPF(driver);
    profilePage=new ProfilePagePF(driver);
    usCitizenshipPage=new AccInfoUSCitizenshipPF(driver);


    }
}
