package JavaCourse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandles {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.findElement(By.cssSelector("a[class='blinkingText']")).click();

        Set<String> windows = driver.getWindowHandles(); //parentid, childid
        Iterator<String> it = windows.iterator();
        String parentID = it.next();
        String childID = it.next();

        driver.switchTo().window(childID);
//        System.out.println(driver.findElement(By.xpath("//p[@class='im-para red'] //strong")).getText());
//        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
        String emailPara = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
        //String email = driver.findElement(By.xpath("//p[@class='im-para red'] //strong")).getText();









        //a[class='blinkingText']



    }
}
