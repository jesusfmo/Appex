package driverSetUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class chromeDriverSetUp {
    public static WebDriver setupDriver() {
        String exePath = Paths.get("").toAbsolutePath().toString() + File.separator + "driver" + File.separator; //Set chromedriver path
        System.setProperty("webdriver.chrome.driver", exePath + "chromedriver"); //Add chromedriver path property
        WebDriver driver = new ChromeDriver(); //Initialize chromedriver
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
