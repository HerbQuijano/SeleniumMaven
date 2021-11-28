package JavaCourse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class EnableDisable {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "H:\\Selenium\\Drivers\\geckodriver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());


        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

        //not always work
        //System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());

        //finding enabled state with condition
        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
        {
            System.out.println("Element enabled");
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }

        driver.quit();
    }
}
