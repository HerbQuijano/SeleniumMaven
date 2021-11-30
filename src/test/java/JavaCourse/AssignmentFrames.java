package JavaCourse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentFrames {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.cssSelector("a[href='/nested_frames']")).click();

        int outFrameIndex = driver.findElements(By.tagName("frame")).size();
        //System.out.println(frameIndex);
        driver.switchTo().frame(0);
        int inFrameIndex = driver.findElements(By.tagName("frame")).size();
        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.cssSelector("div[id='content']")).getText());
        driver.switchTo().defaultContent();

        driver.quit();

    }
}
