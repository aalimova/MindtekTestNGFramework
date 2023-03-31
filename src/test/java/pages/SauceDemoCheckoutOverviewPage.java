package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SauceDemoCheckoutOverviewPage {

    WebDriver driver;
    public SauceDemoCheckoutOverviewPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class='inventory_item_price']")
    public List<WebElement> cartItemPrice;

    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    public WebElement subtotalPrice;
}
