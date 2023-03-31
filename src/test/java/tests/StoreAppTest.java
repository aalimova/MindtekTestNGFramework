package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.StoreAppCreateAccountPage;
import pages.StoreAppMainPage;
import pages.StoreAppSignInPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.TestBase;


public class StoreAppTest extends TestBase {



    String email;
    String password;
    String firstName;
    String lastName;

    @DataProvider(name = "signUpTestData")
    public static Object[][] testData(){
        return new Object[][]{
                {"Harsh", "Patel"},
                {"Jhon", "Doe"},
                {"Kim", "Yan"}
        };
    }

    @Test(groups = {"regression", "smoke", "StoreApp", "verifyCreateAccount"}, dataProvider = "signUpTestData")
    public void verifyCreateAccount(String firstName, String lastName){
        driver.get(ConfigReader.getProperty("StoreAppURL"));
        StoreAppMainPage storeAppMainPage = new StoreAppMainPage();
        storeAppMainPage.createAccountLnk.click();
        StoreAppCreateAccountPage createAccountPage = new StoreAppCreateAccountPage();

//        this.firstName = firstName;
//        this.lastName = lastName;

        createAccountPage.inputFirstName.sendKeys(firstName);
        createAccountPage.inputLastName.sendKeys(lastName);
        createAccountPage.subscribeCheckBox.click();
        email = BrowserUtils.getRandomMethods();
        password = BrowserUtils.getRandomStrongPassword();
        createAccountPage.inputEmail.sendKeys(email);
        createAccountPage.inputPassword.sendKeys(password);
        createAccountPage.inputConfirmatioPsw.sendKeys(password);
        createAccountPage.createBtn.click();
        System.out.println(email);
        System.out.println(password);
        Assert.assertTrue(driver.getTitle().contains("My Account"));
    }

    @Test(groups = {"regression", "smoke", "storeApp", "verifySignIn"}, dependsOnMethods = {"verifyCreateAccount"})
    public void verifySignIn(){
        driver.get(ConfigReader.getProperty("StoreAppURL"));
        StoreAppMainPage storeAppMainPage = new StoreAppMainPage();
        storeAppMainPage.singInLink.click();
        StoreAppSignInPage signInPage = new StoreAppSignInPage();
        signInPage.emailInput.sendKeys(email);
        signInPage.passwordInput.sendKeys(password);
        signInPage.signInBtn.click();

        Assert.assertTrue(driver.getTitle().contains("Home Page"));
    }

}
