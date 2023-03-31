package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

public class BrowserUtils {

    /**
     * This method will accept WebElement of dropdown
     * and String value of dropdown
     * provided value in dropdown
     */

    public static void selectDropDownByValue(WebElement element, String value){
        Select select = new Select(element);
        select.selectByValue(value);
    }

    /*
    This method takes screenshots
       Ex:
        takeScreenshot("SauceDemo Test")
     */

    public static void takeScreenshot(String testName) throws IOException {
        WebDriver driver = Driver.getDriver();
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String path = "src/test/resources/screenshots/"+ testName+".png";
        File file = new File(path);

        FileUtils.copyFile(screenshot, file);
    }

    /*
    This method generated random emails
            Ex:
            getRandomMethods() returns testUser123@gmail.com

     */

    public static String getRandomMethods(){
        String username = "testUser";
        Random random = new Random();
        int number = random.nextInt(999_99);
        return username + number+"@gmail.com";
    }

    /*
    This method generated very strong password
      Ex: getRandomStrongPassword
     */

    public static String getRandomStrongPassword(){
      UUID uuid = UUID.randomUUID();
      String uuidStr = uuid.toString();
      return uuidStr;
    }
}
