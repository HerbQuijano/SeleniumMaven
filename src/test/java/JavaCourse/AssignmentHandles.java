package JavaCourse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class AssignmentHandles {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

        driver.findElement(By.xpath("//a[.='Multiple Windows']")).click();
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> id = windows.iterator();
        String parentID = id.next();
        String childID = id.next();

        driver.switchTo().window(childID);
        System.out.println(driver.findElement(By.cssSelector("div[class='example']")).getText());

        driver.switchTo().window(parentID);
        System.out.println(driver.findElement(By.xpath("//div[@class='example'] /h3")).getText());

        driver.quit();


    }
}
