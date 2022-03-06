package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.sauceLogin;

import java.util.concurrent.TimeUnit;


public class sauceLoginTest {

    WebDriver driver;
    sauceLogin loginSauceTest = new sauceLogin(driver);

    @Test
    public void loginSauce() throws InterruptedException {
        loginSauceTest.configDriver();
        loginSauceTest.validateTitle();
        loginSauceTest.loginPageOk();
        loginSauceTest.quitBrowser();
    }
}
