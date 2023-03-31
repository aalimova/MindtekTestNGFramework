package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.TestBase;

public class SauceDemoTests extends TestBase {

    SauceDemoLoginPage sauseDemoLoginPage = new SauceDemoLoginPage();


    @Test(priority = 1, groups = {"regression","smoke","login","verifyLoginFunctionality"})
    public void verifyLoginFunctionality(){
        driver.get(ConfigReader.getProperty("SauceDemoURL"));
        sauseDemoLoginPage.login(ConfigReader.getProperty("SauceUsername"), ConfigReader.getProperty("SaucePassword"));
        String actualTitle = driver.findElement(By.xpath("//span[@class='title']")).getText();
        String expectedTitle = "PRODUCTS";
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @Test(priority = 2, groups = "regression")
    public void verifyPriceHighToLow(){
        driver.get(ConfigReader.getProperty("SauceDemoURL"));
        sauseDemoLoginPage.login(ConfigReader.getProperty("SauceUsername"), ConfigReader.getProperty("SaucePassword"));
        SauceDemoHomePage sauceDemoHomePage = new SauceDemoHomePage();
        Select select = new Select(sauceDemoHomePage.sortingDropDown);
        select.selectByValue("hilo");

        for(int i = 0; i < sauceDemoHomePage.itemPrices.size()-1; i++){
            double itemPrice1 = Double.parseDouble(sauceDemoHomePage.itemPrices.get(i).getText().substring(1));
            double itemPrice2 = Double.parseDouble(sauceDemoHomePage.itemPrices.get(i+1).getText().substring(1));

            System.out.println(itemPrice1 + " is greater than " + itemPrice2);
            Assert.assertTrue(itemPrice1 >= itemPrice2);

        }
    }
        @Test(priority = 3, groups = {"regression", "smoke", "verifyCheckoutTotal"})
             public void verifyCheckoutTotal(){
             driver.get(ConfigReader.getProperty("SauceDemoURL"));
             sauseDemoLoginPage.login(ConfigReader.getProperty("SauceUsername"),ConfigReader.getProperty("SaucePassword") );
             SauceDemoHomePage sauceDemoHomePage = new SauceDemoHomePage();
             sauceDemoHomePage.backpackCartBtn.click();
             sauceDemoHomePage.bikeCartBtn.click();
             sauceDemoHomePage.cartBtn.click();
             SauceDemoCartPage sauceDemoCartPage = new SauceDemoCartPage();
             sauceDemoCartPage.checkoutBtn.click();

            SauceDemoCheckoutInfoPage sauceDemoCheckoutInfoPage = new SauceDemoCheckoutInfoPage();
            sauceDemoCheckoutInfoPage.firstName.sendKeys("Aika");
            sauceDemoCheckoutInfoPage.lastName.sendKeys("Alimova");
            sauceDemoCheckoutInfoPage.zipCode.sendKeys("60656");
            sauceDemoCheckoutInfoPage.continueBtn.click();
            SauceDemoCheckoutOverviewPage sauceDemoCheckoutOverviewPage = new SauceDemoCheckoutOverviewPage();
            String totalPrice = sauceDemoCheckoutOverviewPage.subtotalPrice.getText();
            double subtotalPriceDouble = Double.parseDouble(totalPrice.substring(totalPrice.indexOf("$")+1));

            double sumOfItemPrices = 0;
            for(int i = 0; i < sauceDemoCheckoutOverviewPage.cartItemPrice.size()-1; i++){

                double price1 = Double.parseDouble(sauceDemoCheckoutOverviewPage.cartItemPrice.get(i).getText().substring(1));
                double price2 = Double.parseDouble(sauceDemoCheckoutOverviewPage.cartItemPrice.get(i+1).getText().substring(1));
                sumOfItemPrices = price1+price2;
            }
            Assert.assertEquals(sumOfItemPrices,subtotalPriceDouble, "This prices did not match");


        }

        @Test(groups = {"regression","smoke", "login"})
        public void verifyLoginFunctionalityNegative(){
        driver.get(ConfigReader.getProperty("SauceDemoURL"));
        sauseDemoLoginPage.login(ConfigReader.getProperty("SauceLockedOutUser"), ConfigReader.getProperty("SaucePassword"));
        Assert.assertEquals(sauseDemoLoginPage.errorMessage.getText(),"Epic sadface: Sorry, this user has been locked out.");

            }

        }





