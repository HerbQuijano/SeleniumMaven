package Section16;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class WEScreenshot {
    public static void main(String[] args) throws InterruptedException, IOException {
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

        driver.switchTo().window(parentID);
        WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
        name.sendKeys(courseName);

        //Screenshot
        File file = name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("H:\\Selenium\\course.png"));

        //get height and width of the element
        System.out.println(name.getRect().getHeight());
        System.out.println(name.getRect().getWidth());

        driver.quit();

    }
}
