package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.ConfigReader;
import utilities.Driver;

public class BlazeDemoPhotoTitlePage {

    WebDriver driver;

    public BlazeDemoPhotoTitlePage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(partialLinkText = "The Beach!")
    public WebElement titleLink;

    public void photoOfBeach(){
        driver.get(ConfigReader.getProperty("BlazeDemoURL"));
        titleLink.click();

    }
}
