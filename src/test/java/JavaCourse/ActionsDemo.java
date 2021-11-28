package JavaCourse;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        WebElement loginB = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        Actions a = new Actions(driver ); //Actions definition
        //a.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).build().perform(); //build prepares, perform executes
        a.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("this is a test").build().perform(); //composite action
        //a.moveToElement(loginB).click().build().perform(); //using composite action


    }
}
