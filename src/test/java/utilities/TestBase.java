package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestBase {
   public WebDriver driver;
    @BeforeMethod(groups = {"regression"})
    public void setUp(){
        driver = Driver.getDriver();
    }

    @AfterMethod(groups = {"regression"})
    public void tearDown() throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();
    }
}
