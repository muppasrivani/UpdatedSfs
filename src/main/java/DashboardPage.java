
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends  BasePage{
    String tileColour="//div[contains(@class,'%s')]";
    String tileTitle= "//div[contains(@class,'panel')]//div[text()='%s']";
    String tileCount="//div[contains(@class,'panel')]//div[text()='%s']/preceding-sibling::div[contains(@class,'huge')]";
    String tileViewDetails="//div[contains(@class,'panel')]//div[contains(text(),'%s')]/following::a[contains(.,'View Details')]";

    public DashboardPage(){}
    public DashboardPage(WebDriver driver){super(driver);}


    public void UserNavigationToDashboard() {
        String pageTitle = getElement(By.className("page-header")).getText();
        if (pageTitle.contains("Dashboard")) {
            System.out.println("User is navigated to dashboard page");
        } else {
            System.out.println("User is not navigated to dashboard page");
        }
    }
    public void validateDashboardPageWithPlansTilePartnersTilePaymentInfoTileAndAnnouncementsTile(){
        isElementDisplayed(By.xpath(String.format(tileTitle,"Plans")),"Plans tile");
        isElementDisplayed(By.xpath(String.format(tileTitle,"Partners")),"Partners");
        isElementDisplayed(By.xpath(String.format(tileTitle,"Payment Info")),"Payment Info");
        isElementDisplayed(By.xpath(String.format(tileTitle,"Announcements")),"Announcements");
    }

    public void validateCountOnDashboardIsSameAsListOnPage(String title) {
        By tile = By.xpath(String.format(tileCount, title));
        String s = getElement(tile).getText();
        int countOnTile = Integer.parseInt(s);
        System.out.println("Count on "+title+" tile is "+countOnTile);
        By viewDetailslink = By.xpath(String.format(tileViewDetails, title));
        getElement(viewDetailslink).click();
        int listCount = getElements(By.xpath("//table[contains(@class,'table')]/tbody/tr")).size();
        System.out.println("Count on "+title+" page is "+listCount);
        if (listCount == countOnTile) {
            System.out.println(title + " count on dashboard and list of " + title + " on " + title + " page are equal");
        } else {
            System.out.println(title + " count on dashboard and list of " + title + " on " + title + " page are not equal");
        }
    }

    public void validateColourOfTilesOnDashboard(String tileName,String color){
        By tileColor=By.xpath((String.format(tileColour,color)));
        if(getElement(tileColor).getAttribute("class").contains(color)){
            System.out.println(tileName+" tile color on dashboard is as expected");
        }else {System.out.println(tileName+" tile color on dashboard is not as expected");}
    }
}
