package Section11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        int linksCount = driver.findElements(By.tagName("a")).size();
        System.out.println(linksCount);
        //int footerLinksCount = driver.findElements(By.xpath("//div[@id='gf-BIG'] //a")).size();
        //System.out.println(footerLinksCount);

        //limiting WebDriver scope
        //creating minidriver so scope is only on the footer, extraction of elements
        WebElement footer = driver.findElement(By.id("gf-BIG"));
        System.out.println(footer.findElements(By.tagName("a")).size());

        //WebElement firstColumn = driver.findElement(By.xpath("//tbody/tr/td[1]/ul[1]")); This was my code before learning
        //System.out.println(firstColumn.findElements(By.tagName("a")).size());

        WebElement columnDriver = footer.findElement(By.xpath("//tbody/tr/td[1]/ul[1]"));
        System.out.println(columnDriver.findElements(By.tagName("a")).size());

        for(int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++)
        {
            columnDriver.findElements(By.tagName("a")).get(i).click();
        }


        driver.quit();
    }
}
