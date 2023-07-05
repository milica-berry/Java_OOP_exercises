package Domaci.domaci7.HerokuappPOM.Base;

import Domaci.domaci7.HerokuappPOM.Pages.HomePage;
import Domaci.domaci7.HerokuappPOM.Pages.ProfilePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;

    public String homeURL;
    public HomePage homepage;
    public ProfilePage profilePage;
    public String basicAuthURL;


    public ExcelReader excelReader;



    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homepage = new HomePage(driver);
        profilePage = new ProfilePage(driver);
        excelReader = new ExcelReader("src/test/java/Domaci/domaci7/HerokuappPOM/TestDataHerkouApp.xlsx");
        homeURL = excelReader.getStringData("URLs", 1, 0);

    }

    public void waitForURL(String URL){
        wait.until(ExpectedConditions.urlToBe(URL));
    }

    public void waitForVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClicikability(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public boolean messageIsPresent(){
        boolean elementIsPresent = false;
        try {
            elementIsPresent = driver.findElement(By.id("content")).isDisplayed();

        } catch (Exception e) {
        }
        return elementIsPresent;
    }



    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
