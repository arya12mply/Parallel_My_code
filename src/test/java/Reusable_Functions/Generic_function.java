package Reusable_Functions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Generic_function {

    private WebDriver driver;
    public void initBrowser(){
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("");
            System.out.println("Started Chromedriver...");
        }
        catch(Exception ex)
        {
            System.out.println("EXCEPTION OCCURED "+ex.getLocalizedMessage());
        }
    }

    public void setDriver(WebDriver driver){
        this.driver = driver;
    }
    public void waitForVisibility(WebElement element, int waitInSeconds){
        WebDriverWait wait=new WebDriverWait(this.driver,waitInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void staticWait(int seconds){
        this.driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }



    public void closeBrowser(){
        try {
            driver.quit();
            System.out.println("Closed Browser...");
        }
        catch(Exception ex)
        {
            System.out.println("EXCEPTION OCCURED "+ex.getMessage());
        }
    }

    public WebDriver getDriver(){
        if(driver == null)
            initBrowser();
        return driver;
    }

}
