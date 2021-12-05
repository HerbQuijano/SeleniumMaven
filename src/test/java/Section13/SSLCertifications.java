package Section13;

import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class SSLCertifications {
    public static void main(String[] args) {

        //SSL Certificates

        //Setting Arguments
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.setAcceptInsecureCerts(true);
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);

        //set predefined capability
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        //pass the chromeoption to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://badssl.com/");
        driver.findElement(By.linkText("expired")).click();

        driver.quit();


    }
}
