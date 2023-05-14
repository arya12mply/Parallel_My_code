package PageObject;

import Reusable_Functions.Generic_function;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page extends Generic_function {

    WebDriver driver;

    @FindBy(xpath ="//input[@id='email']") public WebElement usernamefield;
    @FindBy (xpath="//input[@id='password-field']") public WebElement password;
    @FindBy(xpath = "//button[contains(text(),'Log in')]") public WebElement loginButton;

    public Login_Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

}
