import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;
public class Assertions {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");
        options.addArguments("--ignore-certificate-errors");

        //#1_Title_Check

//        driver.get("https://the-internet.herokuapp.com/login");
//
//
//        // Assert page title
//        String actualTitle = driver.getTitle();
//        String expectedTitle = "The Internet";
//        assertEquals(actualTitle, expectedTitle, "Page title did not match!");
//
//        // Close browser
//        driver.quit();


        //#2_Button_Check


//        driver.get("https://the-internet.herokuapp.com/login");
//
//        // Locate the Login button
//        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/button"));
//        Assert.assertTrue( loginButton.isDisplayed(), "Login button is not found!");



        //#3_Asset_False

        driver.get("https://the-internet.herokuapp.com/login");
        // Check if error message with specific text exists on page load
        boolean isErrorTextPresent = driver.getPageSource().contains("Your username is invalid!");

        // Assert that the error text is NOT present before login
       Assert.assertFalse(isErrorTextPresent, "Error text should not be present before login attempt.");

        driver.quit();

    }
}
