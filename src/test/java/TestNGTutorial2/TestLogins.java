package TestNGTutorial2;

import org.testng.annotations.Test;

public class TestLogins {

    @Test
    public void WebLogin() {
        System.out.println("Web Login");
    }

    @Test
    public void MobileLogin() {
        System.out.println("Appium Login");
    }

    @Test(groups = {"Smoke"})
    public void LoginAPICarLoan() {
        System.out.println("REST API Login (Smoke group)");
    }
}
