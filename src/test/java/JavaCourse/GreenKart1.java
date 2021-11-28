package JavaCourse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class GreenKart1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));
        List<WebElement> productAddButton = driver.findElements(By.xpath("//button[@type='button'] [.='ADD TO CART']"));
        String[] veggies = {"Cucumber", "Corn", "Onion", "Capsicum"};

        for (int i = 0; i < products.size(); i++) {
            //System.out.println(products.get(i).getText());
            for (String veggy : veggies) {
                if (products.get(i).getText().contains(veggy)) {
                    productAddButton.get(i).click();
                }
            }
        }

        driver.quit();
    }
}

