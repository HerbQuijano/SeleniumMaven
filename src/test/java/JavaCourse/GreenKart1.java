package JavaCourse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class GreenKart1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
       //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6)); //implicit wait - applied globally
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        String[] veggies = {"Cucumber", "Corn", "Onion", "Capsicum"};
        addItems(driver, veggies);

        driver.quit();
    }

    public static void addItems(WebDriver driver, String[] veggies) throws InterruptedException {
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));
        List<WebElement> productAddButton = driver.findElements(By.xpath("//button[@type='button'] [.='ADD TO CART']"));

        for (int i = 0; i < products.size(); i++) {
            //System.out.println(products.get(i).getText());
            for (String veggy : veggies) {
                if (products.get(i).getText().contains(veggy)) {
                    productAddButton.get(i).click();
                }
            }
        }


        driver.findElement(By.cssSelector(".cart-icon")).click();
        driver.findElement(By.xpath("//button[.='PROCEED TO CHECKOUT']")).click();
        //div[@class='cart-preview active'] //div[@class='action-block'] //button[@type='button']
        //Explicit wait
        w.until(ExpectedConditions.urlMatches("https://rahulshettyacademy.com/seleniumPractise/#/cart"));
        driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
        //Explicit wait
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
        String promoInfo = driver.findElement(By.xpath("//span[@class='promoInfo']")).getText();
        Assert.assertEquals(promoInfo, "Code applied ..!");

        driver.findElement(By.xpath("//button[.='Place Order']")).click();

        String countryPage = driver.getCurrentUrl();
        Assert.assertEquals(countryPage, "https://rahulshettyacademy.com/seleniumPractise/#/country");
    }
}

