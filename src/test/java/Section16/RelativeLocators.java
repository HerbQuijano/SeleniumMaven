package Section16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocators {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));

        System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());

        WebElement bdayEditBox = driver.findElement(By.cssSelector(("[for='dateofBirth']")));
        //clicks on button because it does not support flex
        driver.findElement(with(By.tagName("input")).below(bdayEditBox)).click();

        WebElement exampleCheck = driver.findElement(By.cssSelector("[for='exampleCheck1']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(exampleCheck)).click();

        WebElement radioButton1 = driver.findElement(By.cssSelector("#inlineRadio1"));
        System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radioButton1)).getText());
        driver.findElement(with(By.tagName("input")).toRightOf(radioButton1)).click();

        Thread.sleep(5000);
        driver.quit();

    }
}
