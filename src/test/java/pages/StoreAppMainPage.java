package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class StoreAppMainPage {

    WebDriver driver;
    public StoreAppMainPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }


    @FindBy(linkText = "Create an Account")
    public WebElement createAccountLnk;

    @FindBy(linkText = "Sign In")
    public WebElement singInLink;








}
