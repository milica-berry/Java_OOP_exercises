package Domaci.domaci6.HerokuappPOM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    public WebDriver driver;
    WebElement basicAuthButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getBasicAuthButton() {
        return driver.findElement(By.linkText("Basic Auth"));
    }

    public void clickOnBasicAuthButton(){
        getBasicAuthButton().click();
    }
}
