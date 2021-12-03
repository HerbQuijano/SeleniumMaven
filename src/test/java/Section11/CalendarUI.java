package Section11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarUI {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.path2usa.com/travel-companions");
        //select date travel
        driver.findElement(By.cssSelector("#travel_date")).click();
        //switch to months
        driver.findElement(By.xpath("//div[@class='datepicker-days'] //th[@class='datepicker-switch']")).click();
        //switch to years
        driver.findElement(By.xpath("//div[@class='datepicker-months'] //th[@class='datepicker-switch']")).click();
        //select year
        driver.findElement(By.xpath("//div[@class='datepicker-years'] //tbody //td //span[@class='year active']")).click();
        //select month
        driver.findElement(By.xpath("//div[@class='datepicker-months'] //tbody //span[@class='month active']")).click();
        //select day
        driver.findElement(By.xpath("//div[@class='datepicker-days'] //tbody //td[@class='active day']")).click();
        //click on search
        driver.findElement(By.xpath("//button[contains(text(),'SEARCH')]")).click();
        Thread.sleep(7000);
        driver.quit();

    }
}
