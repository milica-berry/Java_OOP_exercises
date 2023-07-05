package Domaci.domaci7.HerokuappPOM.Tests;

import Domaci.domaci7.HerokuappPOM.Base.BaseTest;
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
        basicAuthURL =  excelReader.getStringData("URLs", 1, 1);
        driver.get(basicAuthURL);
        WebElement message = driver.findElement(By.id("content"));
        Assert.assertTrue(message.isDisplayed());


    }

    @Test
    public void logInInvalidUsername(){
        homepage.clickOnBasicAuthButton();
        basicAuthURL =  excelReader.getStringData("URLs", 1, 2);
        driver.get(basicAuthURL);
        Assert.assertFalse(messageIsPresent());


    }

    @Test
    public void logInInvalidPassword(){
        homepage.clickOnBasicAuthButton();
        basicAuthURL =  excelReader.getStringData("URLs", 2, 2);
        driver.get(basicAuthURL);

        Assert.assertFalse(messageIsPresent());

    }

    @Test
    public void logInInvalidCredentials(){
        homepage.clickOnBasicAuthButton();
        basicAuthURL =  excelReader.getStringData("URLs", 3, 2);
        driver.get(basicAuthURL);

        Assert.assertFalse(messageIsPresent());

    }

    @Test
    public void logInUppercaseUsername(){
        homepage.clickOnBasicAuthButton();
        basicAuthURL =  excelReader.getStringData("URLs", 4, 2);
        driver.get(basicAuthURL);

        Assert.assertFalse(messageIsPresent());

    }

    @Test
    public void logInUppercasePassword(){
        homepage.clickOnBasicAuthButton();
        basicAuthURL =  excelReader.getStringData("URLs", 5, 2);
        driver.get(basicAuthURL);

        Assert.assertFalse(messageIsPresent());

    }

    @Test
    public void logInUppercaseCredentials(){
        homepage.clickOnBasicAuthButton();
        basicAuthURL = excelReader.getStringData("URLs", 6, 2);
        driver.get(basicAuthURL);

        Assert.assertFalse(messageIsPresent());

    }


}
