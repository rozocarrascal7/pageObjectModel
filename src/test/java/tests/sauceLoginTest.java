package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.sauceLogin;


public class sauceLoginTest {

    WebDriver driver;
    sauceLogin loginSauceTest = new sauceLogin(driver);


    @Test
    public void loginSauce() throws InterruptedException {
        loginSauceTest.configDriver();
        loginSauceTest.validateTitle();
        loginSauceTest.loginPageOk();
        loginSauceTest.orderByList();
        loginSauceTest.quitBrowser();
    }
    @Test
    public void reverseButtonName() throws InterruptedException{
        loginSauceTest.configDriver();
        loginSauceTest.validateTitle();
        loginSauceTest.loginPageOk();
        loginSauceTest.reverseValue();
        loginSauceTest.quitBrowser();
    }
}
