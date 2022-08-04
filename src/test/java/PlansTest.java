import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class PlansTest {
    public String browser="chrome";
    private String plan="Plans";
    private String btnName="Add Plan button";
    protected String pageName="New Plan";

    @Test
    public void validateUserNavigatedToPlansPage(){
        LoginPage login=new LoginPage();
        login.launchBrowser(browser);
        DashboardPage dashboard=login.loginWithValidUserIdPassword();
        login.getElement(By.xpath(String.format(dashboard.tileViewDetails, "Plans"))).click();
        PlansPage plans=new PlansPage(login.getDriver());
        plans.userNavigationToPlansPage();
    }
    @Test
    public void validateAddPlanButtonOnPlansPage(){
        LoginPage login=new LoginPage();
        login.launchBrowser(browser);
        DashboardPage dashboard=login.loginWithValidUserIdPassword();
        login.getElement(By.xpath(String.format(dashboard.tileViewDetails,plan))).click();
        PlansPage plans=new PlansPage(login.getDriver());
        plans.IsAddPlanButtonDisplayedOnPlansPage();
    }
    @Test
    public void validateUserNavigatedToNewPlanPage(){
        LoginPage login=new LoginPage();
        login.launchBrowser(browser);
        DashboardPage dashboard=login.loginWithValidUserIdPassword();
        login.getElement(By.xpath(String.format(dashboard.tileViewDetails,plan))).click();
        PlansPage plans=new PlansPage(login.getDriver());
        login.clickElement(plans.btnAddPlan,btnName);
        plans.userNavigationToNewPlanPage(pageName);
    }
    /*@AfterTest
    public void closeBrowser(){
        LoginPage login=new LoginPage();

        login.closeBrowser();

    }*/
}
