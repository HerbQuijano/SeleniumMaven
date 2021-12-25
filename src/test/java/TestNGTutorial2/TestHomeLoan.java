package TestNGTutorial2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestHomeLoan {
    @Test
    public void WebLoginHomeLoan() {
        System.out.println(" (5) Web Login to Home Loan");
    }

    @Test
    public void MobileSignInHomeLoan() {
        System.out.println(" (2) Mobile Sign In to Home Loan");
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("Tear down (Class)");
    }

    @Test
    public void MobileViewActiveHomeLoan() {
        System.out.println(" (3) Mobile View to Home Loan");
    }

    @Test
    public void MobileLoginHomeLoan() {
        System.out.println("(1) Mobile Login to Home Loan");
    }

    @Test
    public void RestAPILoginHomeLoan() {
        System.out.println("(4) Rest API Login to Home Loan");
    }

    @AfterSuite
    public void tearDownSuite() {
        System.out.println("Tear down (Suite)");
    }

    @BeforeClass
    public void setUp() {
        System.out.println("Set up (Class)");
    }

    @Test
    public void ToBeExcludedOne() {
        System.out.println("To be excluded one");
    }

    @Test
    public void ToBeExcludedTwo() {
        System.out.println("To be excluded two");
    }
}
