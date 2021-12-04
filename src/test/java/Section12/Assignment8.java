package Section12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class Assignment8 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        AutoSuggestive(driver);

        driver.quit();

    }

    public static void AutoSuggestive(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(By.cssSelector(".ui-autocomplete-input")).sendKeys("uni");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='ui-menu-item']")));
        List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));

        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase("Tunisia")) {
                option.click();
                break;
            }
        }
        String actualCountry = js.executeScript("return document.getElementById('autocomplete').value").toString();
        //System.out.println(actualCountry);

        Assert.assertEquals(actualCountry, "Tunisia");
    }
}
