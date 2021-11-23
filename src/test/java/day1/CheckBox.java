package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //will return false
        System.out.println((driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()));
        //star * is regex
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        //will return true
        System.out.println((driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()));

        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        Thread.sleep(2000);

        int i = 1;
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        while (i <= 3)
        {
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
//
        driver.findElement(By.id("btnclosepaxoption")).click();
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        Thread.sleep(4000);
        driver.quit();

    }
}
