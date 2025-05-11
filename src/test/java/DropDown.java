import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;

public class DropDown {
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");
        options.addArguments("--ignore-certificate-errors");

        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();
        WebElement DropDown = driver.findElement(By.id("dropdown"));
        //dropdown.click();
        /*WebElement option1 = driver.findElement(By.xpath("//[@id=\"dropdown\"]/option[2]"));
        option1.click();
        dropdown.click();*/

        Select select = new Select(DropDown);
        select.selectByValue("2");
}
}


