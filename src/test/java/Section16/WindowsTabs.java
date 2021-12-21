package Section16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowsTabs {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.switchTo().newWindow(WindowType.TAB);

        Set<String> windows = driver.getWindowHandles(); //parentid, childid
        Iterator<String> it = windows.iterator();
        String parentID = it.next();
        String childID = it.next();

        driver.switchTo().window(childID);

        driver.get("https://rahulshettyacademy.com/#/index");

        String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
        System.out.println(courseName);

        driver.switchTo().window(parentID);
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(courseName);

        Thread.sleep(5000);
        driver.quit();

    }
}
