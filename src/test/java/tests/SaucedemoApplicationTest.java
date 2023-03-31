package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBase;

import java.util.List;

public class SaucedemoApplicationTest extends TestBase {

    public SaucedemoApplicationTest(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "user-name")
    public WebElement enterUsrname;

    @FindBy(id = "password")
    public WebElement enterPassword;

    @FindBy(id = "login-button")
    public WebElement submitBtn;

    @FindBy(tagName = "h3")
    public WebElement errorMessage;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    public WebElement addToCartBtn;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    public WebElement cartBtn;

    @FindBy(xpath = "//div[contains(text(),'Sauce Labs Bolt T-Shirt')]")
    public WebElement textOfItems;

    @FindBy(id = "remove-sauce-labs-bolt-t-shirt")
    public WebElement removedBtn;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    public List<WebElement> listOfItems;

    @FindBy (xpath = "//div[@class='removed_cart_item']")
    public WebElement removedCart;

    @Test(priority = 3)
    public void verifyErrorMessage(){
        driver.get(ConfigReader.getProperty("SauceDemoURL"));
        enterUsrname.sendKeys("standard_user");
        enterPassword.sendKeys("invalid_password");
        submitBtn.click();

        Assert.assertTrue(errorMessage.getText().equals("Epic sadface: Username and password do not match any user in this service"));
    }
    @Test(priority = 1)
    public void verifyAddtoCart(){
        driver.get(ConfigReader.getProperty("SauceDemoURL"));
        enterUsrname.sendKeys("standard_user");
        enterPassword.sendKeys("secret_sauce");
        submitBtn.click();
        addToCartBtn.click();
        cartBtn.click();
        Assert.assertEquals(textOfItems.getText(), "Sauce Labs Bolt T-Shirt");
    }
    @Test(priority = 0)
    public void verifyIsRemoved() throws InterruptedException{
        driver.get(ConfigReader.getProperty("SauceDemoURL"));
        enterUsrname.sendKeys("standard_user");
        enterPassword.sendKeys("secret_sauce");
        submitBtn.click();
        addToCartBtn.click();
        cartBtn.click();
        Thread.sleep(2000);
        removedBtn.click();
        Assert.assertEquals(removedCart.isDisplayed(), false);
    }


}
