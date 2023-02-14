package searchBar;

import driverSetUp.chromeDriverSetUp;
import globalVariables.setGlobalVariables;
import navigationPages.homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TC3_noMatchingArticlesFound {
    WebDriver driver = chromeDriverSetUp.setupDriver();

    // Page Objects
    navigationPages.homePage homePage = new homePage(driver); //Dashboard page objects
    WebDriverWait wait = new WebDriverWait(driver, 10);

    @BeforeTest
    public void startWebDriver() {
        driver.get(setGlobalVariables.HOME_PAGE); //Call homepage
        driver.manage().window().maximize();
    }

    @Test
    public void TC_3_noMatchingArticlesFound() {
        //Search unexisting product
        homePage.search("Marhaba");

        //Verify Item was not found
        WebElement nullProduct = driver.findElement(By.xpath("//p[@class='o-nullproduct-title-query']"));
        String substring = nullProduct.getText().substring(0,38);
        assertEquals("Lo sentimos, no encontramos nada para ", substring);
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
    }
}
