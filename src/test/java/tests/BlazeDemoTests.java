package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BlazeDemoHomePage;
import pages.BlazeDemoPhotoTitlePage;
import pages.EnterDataIntoFormPage;
import pages.InformationPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.TestBase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class BlazeDemoTests extends TestBase {
    String fromCity = "Boston";
    String toCity = "Rome";

    BlazeDemoHomePage blazeDemoHomePage = new BlazeDemoHomePage();
    InformationPage infoPage = new InformationPage();

    @Test(groups = {"regression", "smoke","selectingCities","MB-10648", "verifyDestinationCities"})
    public void verifyDestinationCities(){
        blazeDemoHomePage.chooseFlight();
        Assert.assertEquals( blazeDemoHomePage.verifyText.getText(), "Flights from " + fromCity + " to " + toCity + ":");
    }

    @Test(priority = 1)
    public void verifyMainTitle(){
        BlazeDemoPhotoTitlePage photoTitlePage = new BlazeDemoPhotoTitlePage();
        photoTitlePage.photoOfBeach();
        String actualTest = driver.getTitle();
        String expectedTest = "BlazeDemo - vacation";
        Assert.assertEquals(expectedTest,actualTest);
    }

    @Test(groups = {"regression", "flights", "verifyMainTitle"})
    public void veriyFlightInfo() throws IOException {

        blazeDemoHomePage.chooseFlight();
        String expectedFlightNo = driver.findElement(By.xpath("//tr[1]/td[2]")).getText();
        String expectedAirline = driver.findElement(By.xpath("//tr[1]/td[3]")).getText();
        String expectedPrice = driver.findElement(By.xpath("//tr[1]/td[6]")).getText();
        infoPage.chooseFlightBtn1.click();
        String actualAirline = driver.findElement(By.xpath("//div//p[1]")).getText();
        String actualFlightNo = driver.findElement(By.xpath("//div//p[2]")).getText();
        String actualPrice = driver.findElement(By.xpath("//div//p[3]")).getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAirline.substring(actualAirline.indexOf(" ")+1), expectedAirline);
        softAssert.assertEquals(actualFlightNo.substring(actualFlightNo.lastIndexOf(" ")+1), expectedFlightNo);
        softAssert.assertEquals(actualPrice.substring(actualPrice.indexOf(" ")+1), expectedPrice.substring(expectedPrice.indexOf("$")));
        BrowserUtils.takeScreenshot("BlazeDemo");
        softAssert.assertAll();
    }

    @Test
    public void verifySuccessMessage() throws IOException {
        blazeDemoHomePage.chooseFlight();
        infoPage.chooseFlightBtn2.click();
        EnterDataIntoFormPage dataIntoFormPage = new EnterDataIntoFormPage();
        dataIntoFormPage.addInformationData();
        BrowserUtils.takeScreenshot("verifyMessage");
        Assert.assertEquals(dataIntoFormPage.titleForVerify.getText(), "Invalid credit card number!");



    }



}
