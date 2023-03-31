package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.BrowserUtils;
import utilities.Driver;

public class EnterDataIntoFormPage {

    WebDriver driver;
    public EnterDataIntoFormPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "inputName")
    public WebElement inputFirstLastName;

    @FindBy(id = "address")
    public WebElement inputAddress;

    @FindBy(id = "city")
    public WebElement inputCity;

    @FindBy(id = "state")
    public WebElement inputSate;

    @FindBy(id = "zipCode")
    public WebElement inputZipCode;

    @FindBy(id = "cardType")
    public WebElement selectCardType;

    @FindBy(id = "creditCardNumber")
    public WebElement inputCreditCardNumber;

    @FindBy(id = "creditCardMonth")
    public WebElement inputMonth;

    @FindBy(id ="creditCardYear")
    public WebElement inputYear;

    @FindBy (id= "nameOnCard")
    public WebElement inputNameOnCard;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement purchaseFlightBtn;

    @FindBy(tagName = "h1")
    public WebElement titleForVerify;

    @FindBy (xpath = "//td[contains(text(),'xxxxxxxxxxxx1111')]")
    public WebElement cardNumber;

    @FindBy (xpath = "(//tr/td)[14]")
    public WebElement date;

    public void addInformationData(){
        inputFirstLastName.sendKeys("David Clark");
        inputAddress.sendKeys("123 Washington ave.");
        inputCity.sendKeys("Austin");
        inputSate.sendKeys("TX");
        inputZipCode.sendKeys("12345");
        BrowserUtils.selectDropDownByValue(selectCardType, "visa");
        inputCreditCardNumber.sendKeys("mycreditcardnumber");
        inputMonth.sendKeys("11");
        inputYear.sendKeys("2025");
        inputNameOnCard.sendKeys("David Clark");
        purchaseFlightBtn.click();
    }




}
