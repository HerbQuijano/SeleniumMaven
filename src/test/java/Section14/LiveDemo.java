package Section14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class LiveDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //click on column to sort
        driver.findElement(By.xpath("//tr/th[1]")).click();

        //capture elements in the table (Original list)
        List<WebElement> items = driver.findElements(By.xpath("//tr/td[1]"));

        //foreach get text of each element into new List
        List<String> originalOrder = items.stream().map(s -> s.getText()).toList();

        //sort the original list -> sorted list
        List<String> sortedList = originalOrder.stream().sorted().toList();

        //compare the sorted list with the original list
        Assert.assertTrue(originalOrder.equals(sortedList));
        //itemNames.forEach(System.out::println);
        //sortedList.forEach(System.out::println);

        //scan column name with gettext -> Rice -> print price of Rice
        List<String> price;
        do {

            List<WebElement> allItems = driver.findElements(By.xpath("//tr/td[1]"));
            price = allItems.stream().filter(s -> s.getText().contains("Rice")).map(s -> getItemPrice(s)).collect(Collectors.toList());
            price.forEach(System.out::println);
            if (price.size() < 1) {
                driver.findElement(By.xpath("//ul/li[7]")).click();
            }
        }
        while (price.size() < 1);

        driver.quit();
    }

    private static String getItemPrice(WebElement s) {
        //travel so sibling we do not use //td/tr/ because we need to continue FROM the actual element we passed
        return s.findElement(By.xpath("following-sibling::td[1]")).getText();
    }
}
