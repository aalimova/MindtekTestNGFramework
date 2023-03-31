package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class SauceDemoLoginPage {
    WebDriver driver;
    public SauceDemoLoginPage(){
         driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "user-name")
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;


    @FindBy(id = "login-button")
    public WebElement submitBtn;

    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement errorMessage;

    public void login(String username, String password){

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submitBtn.click();
    }


}
