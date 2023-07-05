package Domaci.domaci6.HerokuappPOM.Tests;

import Domaci.domaci6.HerokuappPOM.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestBasicAuthLogin extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver.manage().window().maximize();
        driver.get(homeURL);
    }

    @Test
    public void logInValidCredentials(){
        homepage.clickOnBasicAuthButton();
        basicAuthURL =  "https://" + validUsername + ":" + validPassword + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(basicAuthURL);
        WebElement message = driver.findElement(By.id("content"));
        Assert.assertTrue(message.isDisplayed());


    }

    @Test
    public void logInInvalidUsername(){
        homepage.clickOnBasicAuthButton();
        basicAuthURL =  "https://" + invalidUsername1 + ":" + validPassword + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(basicAuthURL);
        Assert.assertFalse(messageIsPresent());


    }

    @Test
    public void logInInvalidPassword(){
        homepage.clickOnBasicAuthButton();
        basicAuthURL =  "https://" + validUsername + ":" + invalidPassword1 + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(basicAuthURL);

        Assert.assertFalse(messageIsPresent());

    }

    @Test
    public void logInInvalidCredentials(){
        homepage.clickOnBasicAuthButton();
        basicAuthURL =  "https://" + invalidUsername1 + ":" + invalidPassword1 + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(basicAuthURL);

        Assert.assertFalse(messageIsPresent());

    }

    @Test
    public void logInEmptyUsername(){
        homepage.clickOnBasicAuthButton();
        basicAuthURL =  "https://" + invalidUsername2 + ":" + validPassword + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(basicAuthURL);

        Assert.assertFalse(messageIsPresent());

    }

    @Test
    public void logInEmptyPassword(){
        homepage.clickOnBasicAuthButton();
        basicAuthURL =  "https://" + validUsername + ":" + invalidPassword2 + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(basicAuthURL);

        Assert.assertFalse(messageIsPresent());

    }

    @Test
    public void logInEmptyCredentials(){
        homepage.clickOnBasicAuthButton();
        basicAuthURL =  "https://" + invalidUsername2 + ":" + invalidPassword2 + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(basicAuthURL);

        Assert.assertFalse(messageIsPresent());

    }


}
