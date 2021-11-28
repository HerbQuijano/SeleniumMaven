package JavaCourse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;


public class CalendarUI {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "H:\\Selenium\\Drivers\\geckodriver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']\n")).click();

        Thread.sleep(2000);

        driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

//        System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).getText());
//        System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).getText());

        Thread.sleep(1000);
        //driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
        //.ui-state-default. ui-state-highlight
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
        Thread.sleep(3000);

        driver.quit();
    }
}
