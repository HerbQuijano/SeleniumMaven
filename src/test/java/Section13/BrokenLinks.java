package Section13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //Broken URL
        //get status code
        //1 Get links list
        List<WebElement> links = driver.findElements(By.xpath("//li //a"));

        Connection(links);


        driver.quit();


    }

    private static void Connection(List<WebElement> links) throws IOException {
        SoftAssert softAssert = new SoftAssert();
        for (WebElement link : links) {
            String url = link.getAttribute("href");

            //Opens connection to the url provided
            //java.net Class HttpURLConnection, cast java.net URL Class into HttpURLConnection and uses method openConnection
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            int responseCode = connection.getResponseCode();
            //soft Assert
            softAssert.assertTrue(responseCode < 400, "Link " + link.getText() + "is broken with code " + responseCode);
        }
        softAssert.assertAll();
    }
}


