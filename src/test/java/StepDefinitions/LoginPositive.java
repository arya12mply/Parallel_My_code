package StepDefinitions;

import PageObject.Login_Page;
import Reusable_Functions.Generic_function;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginPositive extends Generic_function {

    Generic_function generic = new Generic_function();
    Login_Page pageObject;

    @Before
    public void startup(){
        generic.initBrowser();
        WebDriver driver = generic.getDriver();
        generic.setDriver(driver);
        pageObject = new Login_Page(driver);

    }

    @When("user try to login with valid credential {string}")
    public void userEntersCountryNameAs(String arg0) throws InterruptedException {
        if(arg0.contains("Test@1.com")){
            Thread.sleep(2000);
            pageObject.usernamefield.sendKeys("Test@1.com");
        }
        else if(arg0.contains("Test@2.com")){
            Thread.sleep(2000);
            pageObject.usernamefield.sendKeys("Test@2.com");
        }
        else
        {
            Thread.sleep(2000);
            pageObject.usernamefield.sendKeys("Test@3.com");
        }
        pageObject.password.sendKeys("Test@123.com");
    }

    @After
    public void teardown(Scenario scenario){
        if(scenario.isFailed())
            System.out.println("FAILED: --------------------- "+scenario.getName());
        else
            System.out.println("PASSED: --------------------- "+scenario.getName());

        generic.getDriver().quit();
    }
}
