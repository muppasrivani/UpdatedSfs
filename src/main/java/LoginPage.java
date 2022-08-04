import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class LoginPage extends  BasePage {
    private final String url = "http://qa-sfs.projectsbuddy.com/";
    private final String userId = "siva";
    private final String password = "1234";
    private static By txtUserId = By.id("userid");
    private static By txtPassword = By.id("password");
    private static By btnLogin = By.id("login");

    public LoginPage() {}
    public LoginPage(WebDriver driver) {super(driver);}

    public void launchBrowser(String browserName) {
        switch (browserName){
            case "chrome":
                ChromeOptions cOptions=new ChromeOptions();
                cOptions.addArguments("--incognito");
                driver = new ChromeDriver(cOptions);
                break;
            case "firefox":
                FirefoxOptions fOptions=new FirefoxOptions();
                fOptions.addArguments("--incognito");
                driver=new FirefoxDriver(fOptions);
                break;
            case "msedge":
                EdgeOptions msOptions=new EdgeOptions();
                msOptions.addArguments("--incognito");
                driver=new EdgeDriver(msOptions);
                break;
        }
        driver.get(url);
        driver.manage().window().maximize();
    }
    public void validateLoginPageWithUserIdPasswordAndLoginOptions(){
        isElementDisplayed(txtUserId,"UserId text box");
        isElementDisplayed(txtPassword,"Password text box");
        isElementDisplayed(btnLogin,"Login button");
    }
    public DashboardPage loginWithValidUserIdPassword(){
        enterText(txtUserId,userId);
        takeScreenShot();
        enterText(txtPassword,password);
        takeScreenShot();
        driver.findElement(btnLogin).click();
        takeScreenShot();
        return new DashboardPage(driver);
    }




}