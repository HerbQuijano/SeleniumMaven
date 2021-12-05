package Section13;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Screenshots {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get("http://www.google.com");

        //1 Convert WebDriver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot)driver);

        //2 Call getScreenshotAs method to create image file
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

        //3 Copy File to Desired Location
        File destFile = new File("H:\\Selenium\\Screenshots\\screenshot.jpg");
        FileUtils.copyFile(srcFile, destFile);




        //File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(src, new File("C:\\Users\\drako\\IdeaProjects\\SeleniumMaven\\src\\test\\java\\Section13\\screenshot.jpg"));



    }
}
