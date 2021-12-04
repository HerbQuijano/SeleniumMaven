package Section12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class ScrollAndGridTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        int sum = 0;
        int assignementSum = 0;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

        SumTableExample(driver, sum);
        SumTableAssignment(driver, assignementSum);
        driver.quit();
    }

    private static void SumTableAssignment(WebDriver driver, int assignementSum) {
        List<WebElement> tableDisplayValues = driver.findElements(By.cssSelector(".table-display td:nth-child(3)"));

        for (WebElement tableDisplayValue : tableDisplayValues) {
            assignementSum += Integer.parseInt(tableDisplayValue.getText());
        }

        System.out.println(assignementSum);
    }


    public static void SumTableExample(WebDriver driver, int sum)
    {
        List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

        for(int i = 0; i < values.size(); i++)
        {
            sum += Integer.parseInt(values.get(i).getText());

        }

        String[] totalAmount = driver.findElement(By.cssSelector(".totalAmount")).getText().split(":");

        //Assertion
        Assert.assertEquals(sum, Integer.parseInt(totalAmount[1].trim()));
    }

}
