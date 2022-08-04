import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlansPage extends BasePage {
    By btnAddPlan = By.xpath("//h1[contains(@class,'page')]//a[contains(.,'New Plan')]");
    public PlansPage() {}
    public PlansPage(WebDriver driver) {super(driver);}
    public void userNavigationToPlansPage() {
      String pageTitle = getElement(By.className("page-header")).getText();
        if (pageTitle.contains("Plans")) {
            System.out.println("User is navigated to Plans page");
        } else {
            System.out.println("User is not navigated to Plans page");
        }
    }
    public void IsAddPlanButtonDisplayedOnPlansPage() {
        isElementDisplayed(btnAddPlan, "Add Plan button");
    }
    public void userNavigationToNewPlanPage(String content) {
        if (driver.getCurrentUrl().contains("NewPlan")) {
            System.out.println("user is navigated to " + content + " page");
        } else {
            System.out.println("user is not navigated to " + content + " page");
        }
    }
}


