package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptAlerts {
    public static void main(String[] args) {

        String text = "Herbert";

        System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice");

        //Ok only alert
        //driver.findElement(By.id("name")).sendKeys(text);
        //driver.findElement(By.id("alertbtn")).click();

        //Ok Cancel alert
        driver.findElement(By.id("name")).sendKeys(text);
        driver.findElement(By.id("confirmbtn")).click();

        //Assert.assertEquals(driver.switchTo().alert().getText(), "Hello " + text + ", share this practice page and share your knowledge");
        //driver.switchTo().alert().accept();

        driver.switchTo().alert().accept();
        //driver.switchTo().alert().dismiss();

        driver.quit();
    }
}
