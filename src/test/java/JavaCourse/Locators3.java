package JavaCourse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //sibling child to parent traverse

        //parent to child
        // header/div/button[1]/following-sibling::button[1]

        //child to parent
        //header/div/button[1]/parent::div
        //header/div/button[1]/parent::div/parent::header

        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());



    }
}
