package Section12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Assignment7 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        Assignment(driver);
        driver.quit();

    }

    public static void Assignment(WebDriver driver) {
        List<WebElement> numberOfRows = driver.findElements(By.cssSelector(".table-display tr"));
        System.out.println("Number of rows: " + numberOfRows.size());

        List<WebElement> numberOfColumns = driver.findElements(By.cssSelector(".table-display tr th"));
        System.out.println("number of columns: " + numberOfColumns.size());

        for (int i = 1; i < numberOfRows.size(); i++) {
            if (i == 2) {
                System.out.println(numberOfRows.get(i).getText());
            }
        //My note after thinking... I need some sleep, it could be optimized if I only grab the element and print it...
            //.table-display tr:nth-child(3)   LMAO

        }
    }
}
