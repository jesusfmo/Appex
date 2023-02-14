package purchases;

import driverSetUp.chromeDriverSetUp;
import globalVariables.setGlobalVariables;
import navigationPages.homePage;
import navigationPages.loginPage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC7_buySmartTV {
    WebDriver driver = chromeDriverSetUp.setupDriver();

    // Page Objects
    homePage homePage = new homePage(driver); //Dashboard page objects
    loginPage login = new loginPage(driver); //Login page objects
    WebDriverWait wait = new WebDriverWait(driver, 10);
    Actions actions = new Actions(driver);

    //Get credentials
    String user = setGlobalVariables.USER;
    String password = setGlobalVariables.PASSWORD;

    @BeforeTest
    public void startWebDriver() {
        driver.get(setGlobalVariables.HOME_PAGE); //Call homepage
        driver.manage().window().maximize();
    }

    @Test
    public void TC_7_buySmartTV() throws InterruptedException {
        //Search Smart TV
        homePage.search("Smart TV");

        //Filter items by price range
        WebElement minPrice = driver.findElement(By.xpath("//input[@id='min-price-filter']"));
        WebElement maxPrice = driver.findElement(By.xpath("//input[@id='max-price-filter']"));
        WebElement submitRange = driver.findElement(By.xpath("//div[@class='a-price__filterButton']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", minPrice);
        wait.until(ExpectedConditions.visibilityOf(minPrice));
        minPrice.sendKeys("10000");
        maxPrice.sendKeys("25000");
        submitRange.click();
        Thread.sleep(3000);


        //Filter items by screen size
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement size = driver.findElement(By.xpath("//label[contains(text(),'65 pulgadas')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", size);
        wait.until(ExpectedConditions.visibilityOf(size));
        driver.findElement(By.xpath("//input[@id='variants.normalizedSize-65 pulgadas']")).click();
        Thread.sleep(3000);

        //Filter items by Marca
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement marca = driver.findElement(By.xpath("//label[contains(text(),'SAMSUNG')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", marca);
        wait.until(ExpectedConditions.visibilityOf(marca));
        driver.findElement(By.xpath("//input[@id='brand-SAMSUNG']")).click();
        Thread.sleep(3000);

        //Choose an item
        driver.findElement(By.cssSelector(".m-product__listingPlp > li:nth-of-type(1)")).click();

        //Proceed to buy item
        WebElement buyBtn = driver.findElement(By.xpath("//button[@id='opc_pdp_buyNowButton']"));
        wait.until(ExpectedConditions.visibilityOf(buyBtn));
        buyBtn.click();

        //Login to proceed purchase
        login.login(user,password);

        //Login requires SMS code for Authentication, not possible to do
        //To finish purchase a valid card (debit or credit) is needed since the page is already in production
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
    }
}
