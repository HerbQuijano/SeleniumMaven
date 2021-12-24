package TestNGTutorial2;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCarLoan {

    @BeforeTest
    public void setUp()
    {
        System.out.println("Setting up the test");
    }

    @Test
    public void WebLoginCarLoan()
    {
        System.out.println("Web Login to CarLoan");
    }

    @Test
    public void MobileLoginCarLoan()
    {
        System.out.println("Mobile Login to CarLoan");
    }

    @Test
    public void RestAPILoginCarLoan()
    {
        System.out.println("Rest API Login to CarLoan");
    }
}
