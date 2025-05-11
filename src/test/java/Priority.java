import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;
public class Priority {
    @Test(priority = 1)
    public void testB() {
        System.out.println("Login URL: https://www.saucedemo.com/");
    }

    @Test(priority = 2)
    public void testA() {
        String expectedTitle = "Swag Labs";
        System.out.println("Verifying page title: Expected = " + expectedTitle);
        // This is where you'd typically use WebDriver to fetch and assert title.
    }

    @Test(enabled = false)
    public void testC() {
        System.out.println("This test is disabled and should be skipped.");
    }

    @Test(invocationCount = 3)
    public void testD() {
        System.out.println("Running status check - system is responsive.");
    }
}
