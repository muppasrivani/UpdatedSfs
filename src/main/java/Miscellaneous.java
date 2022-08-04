import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Miscellaneous {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://outlook.com");
        driver.manage().window().maximize();
        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd hh-mm-ss");
            String time = sdf.format(date);
            TakesScreenshot screenShot = ((TakesScreenshot) driver);
            File file = screenShot.getScreenshotAs(OutputType.FILE);
            FileHandler.createDir(new File("ScreenShots"));
            FileHandler.copy(file, new File("ScreenShots\\" + "time.png"));
        } catch (Exception e) {
        }
    }
}


