package navigationPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {
    public homePage (WebDriver driver) {
        PageFactory.initElements(driver, this);//We initialize the PageObjects with PageFactory
        //This is a keyword to indicate it is the same class where we will initialize the elements
    }

    //Menu bar PageObjects/WebElements in Dashboard
    @FindBy(xpath="//span[contains(text(),'Iniciar sesión')]")
    private WebElement iniciarSesionBtn;
    @FindBy(xpath="//input[@id='mainSearchbar']")
    private WebElement mainSearchBar;

    public void navigateToLoginPage(){
        iniciarSesionBtn.click();
    }

    public void search(String Keyboard){
        mainSearchBar.sendKeys(Keyboard);
        mainSearchBar.sendKeys(Keys.ENTER);
    }
}
