package Section14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector("#search-field")).sendKeys("ber");

        List<WebElement> itemsInColumn = driver.findElements(By.xpath("//tr/td[1]"));
        //gets 1 element
        List<WebElement> filteredList = itemsInColumn.stream().filter(s -> s.getText().contains("ber")).collect(Collectors.toList());
        //gets 1 element

        Assert.assertEquals(filteredList.size(), itemsInColumn.size());

        driver.quit();



        //#search-field
    }
}
