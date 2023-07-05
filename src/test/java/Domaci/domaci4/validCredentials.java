package Domaci.domaci4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class validCredentials {

    public static void main(String[] args) throws InterruptedException {



        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/");

        WebElement basicAuthButton = driver.findElement(By.linkText("Basic Auth"));
        basicAuthButton.click();

        String validURLBasicAuth = "https://the-internet.herokuapp.com/basic_auth";

        Assert.assertEquals(driver.getCurrentUrl(), validURLBasicAuth);

        String validUsername = "admin";
        String validPassword = "admin";

        String invalidUsername1 = "invalidUsername";
        String invalidPassword1 = "invalidPassword";

        String invalidUsername2 = "";
        String invalidPassword2 = "";

        String invalidUsername3 = "ADMIN";
        String invalidPassword3 = "ADMIN";


        String URL = "https://" + validUsername + ":" + validPassword + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(URL);


        WebElement message = driver.findElement(By.id("content"));

        Assert.assertTrue(message.isDisplayed());


        driver.manage().deleteAllCookies();
        driver.quit();
















    }
}
