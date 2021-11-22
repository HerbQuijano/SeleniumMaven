package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //System.setProperty("webdriver.gecko.driver", "H:\\Selenium\\Drivers\\geckodriver\\geckodriver.exe");
        //WebDriver driver = new FirefoxDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("http://www.google.com"); //until components are fully loaded
        driver.navigate().to("https://www.rahulshettyacademy.com");
        driver.navigate().back();
        driver.navigate().forward();
    }
}
