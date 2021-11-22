package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DynamicDropdown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "H:\\Selenium\\Drivers\\geckodriver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        //ctl00_mainContent_ddl_destinationStation1_CTXT
        Thread.sleep(2000);
        //driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
        //a[@value='MAA'])[2] explicitly indicates second index, second element found
        //a[@value='MAA']
        //a[@value='BLR']

        System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).getText());
        System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).getText());

        Thread.sleep(3000);

        driver.quit();

    }
}