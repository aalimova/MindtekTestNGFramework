package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StoreAppCreateAccountPage {

    WebDriver driver;

    public StoreAppCreateAccountPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstname")
    public WebElement inputFirstName;

    @FindBy(id = "lastname")
    public WebElement inputLastName;

    @FindBy (id = "is_subscribed")
    public WebElement subscribeCheckBox;

    @FindBy(id = "email_address")
    public WebElement inputEmail;

    @FindBy(id = "password")
    public WebElement inputPassword;

    @FindBy(id = "password-confirmation")
    public WebElement inputConfirmatioPsw;

    @FindBy (xpath = "//button[@class='action submit primary']")
    public WebElement createBtn;



}
