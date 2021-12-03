package Section11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Iterator;
import java.util.Set;

public class Scope {
    public static void main(String[] args) throws InterruptedException {
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

        for (int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++) { //optimized open links
            String clickOnLinkTab = (Keys.chord(Keys.CONTROL, Keys.ENTER)); //string that saves the keys pressed
            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab); //keys pressed passed as a parameter for sendkeys method

        }

        //Get window handles
        Set<String> windows = driver.getWindowHandles(); //Create a Set of strings that contain the window handles
        Iterator<String> it = windows.iterator(); //Stores the Set of window handles in an Iterator
        Thread.sleep(5000);

        while (it.hasNext()) //if the iterator has a following index
        {
            driver.switchTo().window(it.next()); //move the next index, first index is 0
            System.out.println(driver.getTitle());
        }
        driver.quit();
    }

    //Thread.sleep(5000); //Do NOT use Thread.sleep from java, just used to verify that the windows opened in a new tab


}

