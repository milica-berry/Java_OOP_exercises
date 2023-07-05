package Domaci.domaci4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SaAnotacijama {

    WebDriver driver;
    String validUsername;
    String validPassword;

    String invalidUsername1;
    String invalidPassword1;

    String invalidUsername2;
    String invalidPassword2;

    String invalidUsername3;
    String invalidPassword3;
    String URL;



    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        validUsername = "admin";
        validPassword = "admin";
        invalidUsername1 = "invalidUsername";
        invalidPassword1 = "invalidPassword";
        invalidUsername2 = "";
        invalidPassword2 = "";
        invalidUsername3 = "ADMIN";
        invalidPassword3 = "ADMIN";

    }

    @BeforeMethod
    public void beforeEveryTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }

    public void goToBasicAuth(){
        WebElement basicAuthButton = driver.findElement(By.linkText("Basic Auth"));
        basicAuthButton.click();
    }

    @Test
    public void logInValidCredentials() {
        goToBasicAuth();
        URL = "https://" + validUsername + ":" + validPassword + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(URL);


        WebElement message = driver.findElement(By.id("content"));
        Assert.assertTrue(message.isDisplayed());
    }

    @Test
    public void logInInvalidUsername() {
        goToBasicAuth();
        URL = "https://" + invalidUsername1 + ":" + validPassword + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(URL);

        boolean logOut = false;
        try {
            logOut = driver.findElement(By.linkText("Log out")).isDisplayed();

        } catch (Exception e) {
        }

        Assert.assertFalse(logOut);
    }

    @Test
    public void logInInvalidPassword() {
        goToBasicAuth();
        URL = "https://" + validUsername + ":" + invalidPassword1 + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(URL);

        boolean logOut = false;
        try {
            logOut = driver.findElement(By.linkText("Log out")).isDisplayed();

        } catch (Exception e) {
        }

        Assert.assertFalse(logOut);
    }

    @Test
    public void logInInvalidCredentials() {
        goToBasicAuth();
        URL = "https://" + invalidUsername1 + ":" + invalidPassword1 + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(URL);

        boolean logOut = false;
        try {
            logOut = driver.findElement(By.linkText("Log out")).isDisplayed();

        } catch (Exception e) {
        }

        Assert.assertFalse(logOut);
    }


    @Test
    public void logInEmptyUsername() {
        goToBasicAuth();
        URL = "https://" + invalidUsername2 + ":" + validPassword + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(URL);

        boolean logOut = false;
        try {
            logOut = driver.findElement(By.linkText("Log out")).isDisplayed();

        } catch (Exception e) {
        }

        Assert.assertFalse(logOut);
    }

    @Test
    public void logInEmptyPassword() {
        goToBasicAuth();
        URL = "https://" + validUsername + ":" + invalidPassword2 + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(URL);

        boolean logOut = false;
        try {
            logOut = driver.findElement(By.linkText("Log out")).isDisplayed();

        } catch (Exception e) {
        }

        Assert.assertFalse(logOut);
    }


    @Test
    public void logInEmptyCredentials() {
        goToBasicAuth();
        URL = "https://" + invalidUsername2 + ":" + invalidPassword2 + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(URL);

        boolean logOut = false;
        try {
            logOut = driver.findElement(By.linkText("Log out")).isDisplayed();

        } catch (Exception e) {
        }

        Assert.assertFalse(logOut);
    }

    @Test
    public void logInUppercaseUsername() {
        goToBasicAuth();
        URL = "https://" + invalidUsername3 + ":" + validPassword + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(URL);

        boolean logOut = false;
        try {
            logOut = driver.findElement(By.linkText("Log out")).isDisplayed();

        } catch (Exception e) {
        }

        Assert.assertFalse(logOut);
    }

    @Test
    public void logInUppercasePassword() {
        goToBasicAuth();
        URL = "https://" + validUsername + ":" + invalidPassword3 + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(URL);

        boolean logOut = false;
        try {
            logOut = driver.findElement(By.linkText("Log out")).isDisplayed();

        } catch (Exception e) {
        }

        Assert.assertFalse(logOut);
    }

    @Test
    public void logInUppercaseCredentials() {
        goToBasicAuth();
        URL = "https://" + invalidUsername3 + ":" + invalidPassword3 + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(URL);

        boolean logOut = false;
        try {
            logOut = driver.findElement(By.linkText("Log out")).isDisplayed();

        } catch (Exception e) {
        }

        Assert.assertFalse(logOut);
    }



    @AfterMethod
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
