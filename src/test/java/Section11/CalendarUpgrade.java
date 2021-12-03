package Section11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CalendarUpgrade {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.path2usa.com/travel-companions");
        //April 23
        String findDay = "23";
        String findMonth = "April";

        FindTripDate(driver, findDay, findMonth);

        driver.quit();
    }

    public static void FindTripDate(WebDriver driver, String findDay, String findMonth)
    {
        driver.findElement(By.xpath(".//*[@id='travel_date']")).click();

        //mientras no encuentre el mes, sigue clickeando
        while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains(findMonth)) {
            driver.findElement(By.cssSelector("[class='datepicker-days'] [class='next']")).click();
        }

        //Crea una lista de elementos para iterar entre todos ellos
        List<WebElement> dates = driver.findElements(By.cssSelector(".day"));
        //Guarda el conteo de los elementos, identificar si se puede usar el size en el ciclo for
        int datesCount = driver.findElements(By.cssSelector(".day")).size();

        //recorre los elementos y compara la cadena provista con la cadena a buscar y se detiene y clickea el elemento si la encuentra
        for (int i = 0; i < datesCount; i++) {
            String text = dates.get(i).getText();
            if (text.equalsIgnoreCase((findDay))) {
                dates.get(i).click();
                break;
            }
        }
    }
}
