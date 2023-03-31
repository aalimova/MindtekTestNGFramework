package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WeatherbaseAppPage;
import utilities.ConfigReader;
import utilities.TestBase;

import javax.swing.*;
import java.text.DecimalFormat;

public class WeatherbaseAppTest extends TestBase {

    @Test
    public void verifyIncludingChicago(){
        driver.get(ConfigReader.getProperty("WeatherAppURL"));
        WeatherbaseAppPage weatherAppPage = new WeatherbaseAppPage();
        weatherAppPage.inputSearch.clear();
        weatherAppPage.inputSearch.sendKeys("60656");
        weatherAppPage.submitBtn.click();
        Assert.assertTrue(weatherAppPage.tableContent.getText().contains("Chicago, Illinois"));
    }
    @Test
    public void verifyWithInvalidZipCode(){
        driver.get(ConfigReader.getProperty("WeatherAppURL"));
        WeatherbaseAppPage weatherAppPage = new WeatherbaseAppPage();
        weatherAppPage.inputSearch.clear();
        weatherAppPage.inputSearch.sendKeys("1234");
        weatherAppPage.submitBtn.click();
        Assert.assertTrue(weatherAppPage.invalidMessage.getText().contains("We're sorry."));
    }
    @Test
    public void verifyStates()  {
        driver.get(ConfigReader.getProperty("WeatherAppURL"));
        WeatherbaseAppPage weatherAppPage = new WeatherbaseAppPage();
        Actions actions = new Actions(driver);
        actions.moveToElement(weatherAppPage.NorthAmericaLink);
        actions.click().build().perform();
        actions.moveToElement(weatherAppPage.USALink);
        actions.click().build().perform();
        int size = weatherAppPage.listOfState.size();
        Assert.assertTrue(50 <= size);
    }
    @Test
    public void verifyDisplayCLetter(){
        driver.get(ConfigReader.getProperty("WeatherAppURL"));
        WeatherbaseAppPage weatherAppPage = new WeatherbaseAppPage();
        weatherAppPage.NorthAmericaLink.click();
        weatherAppPage.USALink.click();
        weatherAppPage.CaliforniaLink.click();
        weatherAppPage.SanJoseLink.click();
        weatherAppPage.Fbtn.click();
        Assert.assertTrue(weatherAppPage.Ctxt.getText().contains("C"));
    }
    @Test
    public void verifyFahrenToCel(){
        driver.get(ConfigReader.getProperty("WeatherAppURL"));
        WeatherbaseAppPage weatherAppPage = new WeatherbaseAppPage();
        weatherAppPage.NorthAmericaLink.click();
        weatherAppPage.USALink.click();
        weatherAppPage.CaliforniaLink.click();
        weatherAppPage.SanJoseLink.click();
        weatherAppPage.Fbtn.click();
        double celsius = (60.6 - 32) * 5/9;
        DecimalFormat df = new DecimalFormat("##.0");
        String c=df.format(celsius);
        double convertDouble = Double.parseDouble(c);
        double cel = Double.parseDouble(weatherAppPage.validateFtoC.getText());
        Assert.assertEquals(cel,convertDouble);
    }
}
