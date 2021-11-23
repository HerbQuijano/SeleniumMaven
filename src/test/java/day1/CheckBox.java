package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class CheckBox {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "H:\\Selenium\\Drivers\\geckodriver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //will return false
        //System.out.println((driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()));
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        //star * is regex
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        //will return true
        //System.out.println((driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()));
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

        //System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
        Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(), 6);
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);

        int i = 1;
        //System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "1 Adult");
        while (i <= 3)
        {
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
//        for (int i = 0; i < 3; i++)
//        {
//            driver.findElement(By.id("hrefIncAdt")).click();
//            i++;
//        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        //System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "4 Adult");
        Thread.sleep(4000);
        driver.quit();



    }
}
