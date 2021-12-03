package Section11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //1 Select any checkbox from the three displayed, in this case, Option 3
        driver.findElement(By.xpath("//div[@id='checkbox-example'] //label[3] //input")).click();
        WebElement checkboxLabel = driver.findElement(By.xpath("//div[@id='checkbox-example'] //label[3]"));
        checkboxLabel.click();
        String checkBoxLabelText = checkboxLabel.getText();

        //2 Without hardcoding, select the option from step 1 in the dropdown selector
        WebElement dropdownSelector = driver.findElement(By.id("dropdown-class-example"));
        Select dropdown = new Select(dropdownSelector);
        dropdown.selectByVisibleText(checkBoxLabelText);

        //3 Enter label in edit box
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(checkBoxLabelText);

        //4 Click on alert and verify if text present from step 2 is present in popup message
        driver.findElement(By.cssSelector("#alertbtn")).click();
        String alertText = driver.switchTo().alert().getText();

        String[] splitAlert = alertText.split(" ");
        String[] splitAlert2 = splitAlert[1].split(",");

        Assert.assertEquals(splitAlert2[0], checkBoxLabelText, "Option displayed in alert matches with Option selection.");
        driver.quit();


    }
}
