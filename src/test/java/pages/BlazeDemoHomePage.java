package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

public class BlazeDemoHomePage {

    WebDriver driver;
    public BlazeDemoHomePage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//select[@name='fromPort']")
    public WebElement selectFrom;

    @FindBy(xpath = "//select[@name='toPort']")
    public WebElement selectTo;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submitBtn;

    @FindBy(xpath = "//tr[1]//input[@class='btn btn-small']")
    public WebElement chooseFlightBtn;

    @FindBy(tagName = "h3")
    public WebElement verifyText;

    public void chooseFlight(){

        String fromCity = "San Diego";
        String toCity = "New York";
        driver.get(ConfigReader.getProperty("BlazeDemoURL"));
        BrowserUtils.selectDropDownByValue(driver.findElement(By.name("fromPort")),fromCity);
        BrowserUtils.selectDropDownByValue(driver.findElement(By.name("toPort")),toCity);
        driver.findElement(By.xpath("//input[@type='submit']")).click();

    }


}
