package Domaci.domaci7.HerokuappPOM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {

    WebDriver driver;
    WebElement message;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getMessage() {
        return driver.findElement(By.id("content"));
    }
}
