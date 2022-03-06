package pages;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class sauceLogin {

    /**
     * Locators
     */
    By usernameField = By.id("user-name");
    By passwordField = By.name("password");
    By loginButton = By.xpath("//input[@class='submit-button btn_action']");
    String usernameValue = "standard_user";
    String passwordValue = "secret_sauce";
    String url = "https://www.saucedemo.com/";
    String expectTitle="Swag Labs";


    /**
     * Login pages methods
     */
   private WebDriver driver;
   public sauceLogin(WebDriver driver){
       this.driver=driver;
   }

    public void configDriver() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        driver.get(url);
        Thread.sleep(2000);
    }

    public void loginPageOk() {
        driver.findElement(usernameField).sendKeys(usernameValue);
        driver.findElement(passwordField).sendKeys(passwordValue);
        driver.findElement(loginButton).click();
    }

    public void quitBrowser(){
       driver.quit();
    }

    public void validateTitle() {
        String actualTitle= driver.getTitle();
        Assertions.assertEquals(actualTitle, expectTitle);
    }

    public void validateUrlDashboard() {
        //
    }
}
