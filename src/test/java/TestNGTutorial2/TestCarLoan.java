package TestNGTutorial2;

import org.testng.annotations.*;

public class TestCarLoan {

    @AfterTest
    public void LogoutCarLoan() {
        System.out.println("Logging out of CarLoan");
    }

    @BeforeTest
    public void setUp() {
        System.out.println("Setting up the test");
    }

    @BeforeMethod
    public void setUpMethod() {
        System.out.println("Setting up Method");
    }

    @Test
    public void WebLoginCarLoan() {
        System.out.println("Web Login to CarLoan");
    }

    @BeforeSuite
    public void setUpSuite() {
        System.out.println("Setting up Suite");
    }

    @AfterMethod
    public void tearDownMethod() {
        System.out.println("Tearing down Method");
    }

    @Test
    public void RestAPILoginCarLoan() {
        System.out.println("Rest API Login to CarLoan");
    }

    @Test
    public void MobileLoginCarLoan() {
        System.out.println("(included) Mobile Login to CarLoan");
    }
}
