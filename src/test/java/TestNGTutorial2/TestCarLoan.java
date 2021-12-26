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

    @Parameters({"LOANS URL", "API/key username"})
    @Test
    public void RestAPILoginCarLoan(String urlName, String key) {
        System.out.println("Rest API Login to CarLoan " + urlName + " " + key);

    }

    @Test(groups = {"Smoke"})
    public void TestGroup1() {
        System.out.println("Test Group Smoke 1");
    }

    @Test(groups = {"Smoke"})
    public void TestGroup2() {
        System.out.println("Test Group Smoke 2");
    }

    @Test(groups = {"Smoke"})
    public void TestGroup3() {
        System.out.println("Test Group Smoke 3");
    }

    @Parameters({"LOANS URL"})
    @Test
    public void MobileLoginCarLoan(String urlName) {
        System.out.println("(included) Mobile Login to CarLoan " + urlName);
    }

    @Test(enabled = false)
    public void EnabledDisabledTest() {
        System.out.println("Enabled/Disabled Test");
    }

    @Test
    public void zDependenceTestFirst() {
        System.out.println("Dependence Test Dependable");
    }

    @Test //(dependsOnMethods = {"zDependenceTestFirst"})
    public void aDependenceTestSecond() {
        System.out.println("Dependence Test Dependant");
    }
}
