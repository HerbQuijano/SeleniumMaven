package JavaCourse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class FrameHandling {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");

        Actions a = new Actions(driver);

//        int size = driver.findElements(By.tagName("iframe")).size(); //snippet to find frames index
//        System.out.println(size);

        driver.switchTo().frame(0);
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement dropHere = driver.findElement(By.id("droppable"));

        System.out.println(driver.findElement(By.id("droppable")).getText());
        Assert.assertEquals(driver.findElement(By.id("droppable")).getText(), "Drop here");
        a.dragAndDrop(draggable, dropHere).build().perform();
        System.out.println(driver.findElement(By.id("droppable")).getText());
        Assert.assertEquals(driver.findElement(By.id("droppable")).getText(), "Dropped!");

        driver.switchTo().parentFrame();
        driver.quit();



    }
}
