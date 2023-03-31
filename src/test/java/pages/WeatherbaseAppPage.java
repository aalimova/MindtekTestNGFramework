package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class WeatherbaseAppPage {

    WebDriver driver;

    public WeatherbaseAppPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "query")
    public WebElement inputSearch;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement submitBtn;

    @FindBy(id = "left-content")
    public WebElement tableContent;

    @FindBy(xpath = "//div[@id='left-content']/p[1]")
    public WebElement invalidMessage;

    @FindBy(xpath = "(//a[@href='/weather/country.php3?r=NOR&regionname=North-America'])[2]")
    public WebElement NorthAmericaLink;

    @FindBy(xpath = "//a[@href='/weather/state.php3?c=US&name=United-States-of-America']")
    public WebElement USALink;

    @FindBy(xpath = "//li")
    public List<WebElement> listOfState;

    @FindBy(linkText = "California")
    public WebElement CaliforniaLink;

    @FindBy(linkText = "San Jose")
    public WebElement SanJoseLink;

    @FindBy(xpath = "//img[@name='fc']")
    public WebElement Fbtn;

    @FindBy(xpath = "(//td[@class='dataunit'])[1]")
    public WebElement Ctxt;

    @FindBy(xpath = "//td[contains(text(),'15.9')]")
    public WebElement validateFtoC;


}
