package navigationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
    public loginPage (WebDriver driver) {
        PageFactory.initElements(driver, this);//We initialize the PageObjects with PageFactory
        //This is a keyword to indicate it is the same class where we will initialize the elements
    }

    //Login PageObjects/WebElements
    @FindBy(xpath="//input[@id='username']")
    private WebElement userNameTxt;
    @FindBy(xpath="//input[@id='password']")
    private WebElement passwordTxt;
    @FindBy(xpath="//button[contains(text(),'Iniciar sesión')]")
    private WebElement btnLogin;

    public void login(String user, String password) {
        userNameTxt.sendKeys(user);
        passwordTxt.sendKeys(password);
        btnLogin.click();
    }
}
