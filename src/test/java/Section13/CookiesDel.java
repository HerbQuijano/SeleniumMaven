package Section13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookiesDel {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Just added as a test - Cookie cookie = new Cookie("CookieTest", "test");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //Just added as a test - driver.manage().deleteCookie(Cookie cookie);
        driver.manage().deleteCookieNamed("cookieKey");
        driver.get("http://www.google.com");


        driver.quit();


    }
}
