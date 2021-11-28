package JavaCourse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {

      public static void main(String[] args) throws InterruptedException {

        String name = "rahul";

        System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //System.setProperty("webdriver.gecko.driver", "H:\\Selenium\\Drivers\\geckodriver\\geckodriver.exe");
        //WebDriver driver = new FirefoxDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        String password = getPassword(driver);

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello " + name + "," );

        driver.findElement(By.xpath("//button[text()='Log Out']")).click();
        driver.close();
      //  driver.quit();

    }

    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String passwordText = driver.findElement(By.cssSelector("form p")).getText();
        String[] passwordArray = passwordText.split("'");
        String password;
        return password = passwordArray[1].split("'")[0];

        //String password = array2[0];








    }

}
