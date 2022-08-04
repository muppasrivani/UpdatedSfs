import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class DashboardTest{
    public String browser="chrome";
    private String plan="Plans";
    private String partner="Partners";
    private String paymentInfo="Payment Info";
    private String announcement="Announcements";
    String planColor="green";
    String partnerColor="primary";
    String paymentsColor="yellow";
    String announcementsColor="red";
    @Test
    public void validateUserIsAtDashboardPage(){
        LoginPage login=new LoginPage();
        login.launchBrowser(browser);
        DashboardPage dashboard=login.loginWithValidUserIdPassword();
        dashboard.UserNavigationToDashboard();

    }
    @Test
    public void validateDashboardPageWithPlansTilePartnersTilePaymentInfoTileAndAnnouncementsTile(){
        LoginPage login=new LoginPage();
        login.launchBrowser(browser);
        DashboardPage dashboard=login.loginWithValidUserIdPassword();
        dashboard.validateDashboardPageWithPlansTilePartnersTilePaymentInfoTileAndAnnouncementsTile();
        }

    @Test
     public void validateCountOnPlansTileIsSameAsListOfPlansInPlansPage(){
        LoginPage login=new LoginPage();
        login.launchBrowser(browser);
        DashboardPage dashboard=login.loginWithValidUserIdPassword();
        dashboard.validateCountOnDashboardIsSameAsListOnPage(plan);
        login.navigateBack();
        dashboard.validateCountOnDashboardIsSameAsListOnPage(partner);
        login.navigateBack();
        dashboard.validateCountOnDashboardIsSameAsListOnPage(paymentInfo);
    }
    @Test
    public void valiateColorOfTilesOnDashboard(){
        LoginPage login=new LoginPage();
        login.launchBrowser(browser);
        DashboardPage dashboard=login.loginWithValidUserIdPassword();
        dashboard.validateColourOfTilesOnDashboard(plan,planColor);
        dashboard.validateColourOfTilesOnDashboard(partner,partnerColor);
        dashboard.validateColourOfTilesOnDashboard(paymentInfo,paymentsColor);
        dashboard.validateColourOfTilesOnDashboard(announcement,announcementsColor);


    }
    /*@AfterTest
    public void closeBrowser(){
    LoginPage login=new LoginPage();
    login.closeBrowser();

    }*/
}

