import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;


public class BasePage {
    protected WebDriver driver = null;
    public BasePage() {
    }
    public BasePage(WebDriver driver) {this.driver = driver;}
    public WebDriver getDriver() {return driver;}
    public void isElementDisplayed(By locator, String elementName) {
        if (getElement(locator).isDisplayed()) {
            System.out.println(elementName + " is displayed on the webpage");
        } else {
            System.out.println(elementName + " is not displayed on the webpage");
        }

    }
    public WebElement getElement(By by) {
        getDriver().findElement(by);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style','border:2px solid red')", getDriver().findElement(by));
        return getDriver().findElement(by);
    }
    public List<WebElement> getElements(By by) {
        return getDriver().findElements(by);
    }
    public void enterText(By by, String contorlName) {
        WebElement element=getElement(by);
        element.clear();
        element.sendKeys(contorlName);
    }
    public void clickElement(By by, String controlName) {
        getElement(by).click();
        System.out.println("click action performed on the " + controlName);
    }
    public void takeScreenShot() {
        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd hh-mm-ss");
            String time = sdf.format(date);
            TakesScreenshot screenShot = ((TakesScreenshot) getDriver());
            File file = screenShot.getScreenshotAs(OutputType.FILE);
            FileHandler.createDir(new File("ScreenShots"));
            FileHandler.copy(file, new File("ScreenShots\\" + time + ".png"));
        } catch (Exception e) {
        }
    }
    public void switchToWindow(){
        Set<String> windowIds=getDriver().getWindowHandles();
        for (String eachWindowId:windowIds) {
            getDriver().switchTo().window(eachWindowId);
        }
      }
    public void switchToFrames(WebElement frameElement){getDriver().switchTo().frame(frameElement);}
    public void navigateBack() {
        driver.navigate().back();
    }
    public void closeBrowser() {
        driver.quit();
    }


}
