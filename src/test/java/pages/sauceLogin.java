package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class sauceLogin {

    /**
     * Locators TESTS BRANCH_sub_Branchs
     */
    By usernameField = By.id("user-name");
    By passwordField = By.name("password");
    By loginButton = By.xpath("//input[@class='submit-button btn_action']");
    String usernameValue = "standard_user";
    String passwordValue = "secret_sauce";
    String url = "https://www.saucedemo.com/";
    String expectTitle = "Swag Labs";
    By listOrder = By.xpath("//select[@class='product_sort_container']");
    By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");


    /**
     * Login pages methods
     */
    private WebDriver driver;

    public sauceLogin(WebDriver driver) {
        this.driver = driver;
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

    public void quitBrowser() {
        driver.quit();
    }

    public void validateTitle() {
        String actualTitle = driver.getTitle();
        Assertions.assertEquals(actualTitle, expectTitle);
    }

    public void validateUrlDashboard() {
        //
    }

    public void orderByList() {
        Select dropdown = new Select(driver.findElement(listOrder));
        dropdown.selectByVisibleText("Name (A to Z)");
        String valueList = dropdown.getFirstSelectedOption().getText();
        System.out.println("los valores de la lista son: " + valueList);
        Assertions.assertEquals(valueList, "Name (A to Z)");
    }

    public void reverseValue() {
        String labelTextOriginal = driver.findElement(addToCartButton).getText();
        System.out.println("El valor original del texto del boton es: " + labelTextOriginal);
        String newLabelText = "";
        char ch;
        for (int i = 0; i < labelTextOriginal.length(); i++) {
            ch = labelTextOriginal.charAt(i);
            newLabelText= ch+newLabelText;
        }
        System.out.println("El valor al revés del boton addToCar es: " +newLabelText );
    }

}
