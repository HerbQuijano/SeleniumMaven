package JavaCourse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//TestNG is one of the testing frameworks that uses selenium

public class UpdatedDropdown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "H:\\Selenium\\Drivers\\geckodriver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);

        int i = 1;
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
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
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        Thread.sleep(4000);
        driver.quit();

    }
}
