package Domaci.domaci2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class passwordUppercase {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://practicetestautomation.com/");

        WebElement practice = driver.findElement(By.id("menu-item-20"));
        practice.click();

        WebElement logInPage = driver.findElement(By.xpath("/html/body/div/div/section/div/div/article/div[2]/div[1]/div[1]/p/a"));
        logInPage.click();

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("PASSWORD123");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        WebElement invalidPassword = driver.findElement(By.id("error"));
        Assert.assertTrue(invalidPassword.isDisplayed());

        String stringInvalidPassword = "Your password is invalid!";
        Assert.assertEquals(invalidPassword.getText(), stringInvalidPassword);

        driver.quit();
    }
}
