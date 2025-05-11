import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

public class AfterBefore {
    WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Suite started — setup logs or environment configs");
    }

    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void testValidLogin() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement productsTitle = driver.findElement(By.className("title"));
        assertTrue(productsTitle.getText().contains("Products"),
                "Valid login failed: 'Products' page not displayed.");
    }

    @Test
    public void testInvalidLogin() {
        driver.findElement(By.id("user-name")).sendKeys("mohanad");
        driver.findElement(By.id("password")).sendKeys("NTI");
        driver.findElement(By.id("login-button")).click();

        WebElement errorMessage = driver.findElement(By.cssSelector("[data-test='error']"));
        assertTrue(errorMessage.isDisplayed(),
                "Error message not displayed for invalid login.");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Test finished — post-test steps here");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

