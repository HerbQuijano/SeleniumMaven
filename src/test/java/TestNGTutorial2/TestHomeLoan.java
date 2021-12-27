package TestNGTutorial2;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestHomeLoan {
    @Test
    public void WebLoginHomeLoan() {
        System.out.println(" (5) Web Login to Home Loan");
        Assert.assertTrue(false);
    }

    @Test
    public void MobileSignInHomeLoan() {
        System.out.println(" (2) Mobile Sign In to Home Loan");
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("Tear down (Class)");
    }

    @Test(groups = {"Smoke"})
    public void MobileViewActiveHomeLoan() {
        System.out.println(" (3) Mobile View to Home Loan (Smoke group)");
    }

    @Parameters({"username", "password"})
    @Test
    public void MobileLoginHomeLoan(String username, String password) {
        System.out.println("(1) Mobile Login to Home Loan " + username + " " + password);
    }

    @Test(dataProvider = "getData") // calling dataprovider method
    public void RestAPILoginHomeLoan(String username, String password) {
        System.out.println("(4) Rest API Login to Home Loan " + username + " " + password);
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

    @Test(timeOut = 4000)  // timeOut annotation is used to specify the time out for the test
    public void ToBeExcludedTwo() {
        System.out.println("To be excluded two");
    }

    @DataProvider // DataProvider annotation is used to provide the test data from the specified method
    public Object[][] getData() {
        //1st combination - username, password - good credit history
        //2nd combination - username, password - no credit history
        //3rd combination - fraud
        Object[][] data = new Object[3][2];
        data[0][0] = "firstUsername";
        data[0][1] = "password";

        data[1][0] = "secondUsername";
        data[1][1] = "secondPassword";

        data[2][0] = "thirdUsername";
        data[2][1] = "thirdPassword";

        return data;
    }

}
