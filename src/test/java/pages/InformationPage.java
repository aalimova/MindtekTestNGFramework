package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.awt.dnd.DragGestureEvent;

public class InformationPage {

    WebDriver driver;
    public InformationPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tr[1]//input[@class='btn btn-small']")
    public WebElement chooseFlightBtn1;

    @FindBy(xpath = "//tr[2]//input[@class='btn btn-small']")
    public WebElement chooseFlightBtn2;

    @FindBy(xpath = "//tr[3]//input[@class='btn btn-small']")
    public WebElement chooseFlightBtn3;

    @FindBy(xpath = "//tr[4]//input[@class='btn btn-small']")
    public WebElement chooseFlightBtn4;

    @FindBy(xpath = "//tr[5]//input[@class='btn btn-small']")
    public WebElement chooseFlightBtn5;

    @FindBy(xpath = "//tr[1]/td[2]")
    public WebElement expectedFlightNo;

    @FindBy(xpath = "//tr[1]/td[3]")
    public WebElement expectedAirline;

    @FindBy(xpath = "//tr[1]/td[6]")
    public WebElement expectedPrice;

    @FindBy(xpath = "//div//p[1]")
    public WebElement actualAirline;

    @FindBy(xpath = "//div//p[2]")
    public WebElement actualFlightNo;

    @FindBy(xpath = "//div//p[3]")
    public WebElement actualPrice;
}
