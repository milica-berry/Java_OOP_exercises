package Domaci.domaci5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class DemoqaAnotacije {

    WebDriver driver;
    WebDriverWait wait;
    String validUsername;
    String invalidUsername;
    String validPassword;
    String invalidPassword;


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        validUsername = "milenjivac";
        invalidUsername = "123";
        validPassword = "Ovojemojpassword1!";
        invalidPassword = "password123";
    }

    @BeforeMethod
    public void beforeEveryTest() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
    }

    public void goToBookstoreApp() {
        WebElement bookStoreApp = driver.findElement(By.cssSelector(".avatar.mx-auto.white"));
        bookStoreApp.click();
    }

    public void addCookies() {
        Cookie token = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6Im1pbGVuaml2YWMiLCJwYXNzd29yZCI6Ik92b2plbW9qcGFzc3dvcmQxISIsImlhdCI6MTY4NjMxODIxNn0.uMeS_rNjZFLcbtF5kAUkbxFsU5FYnEXrf1U4Qi9X718");
        Cookie expires = new Cookie("expires","2023-06-16T13%3A43%3A36.017Z");
        Cookie userID = new Cookie("userID", "6d8a4336-4815-42b6-9fcf-b454d3084cfb");
        Cookie userName = new Cookie("userName", "milenjivac");


        driver.manage().addCookie(token);
        driver.manage().addCookie(expires);
        driver.manage().addCookie(userID);
        driver.manage().addCookie(userName);

        driver.navigate().refresh();

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();


        driver.get("https://demoqa.com/login");
    }

    public void logIn(){

        List<WebElement> listLogInCSS = driver.findElements(By.cssSelector(".mr-sm-2.form-control"));
        listLogInCSS.get(0).sendKeys(validUsername);
        listLogInCSS.get(1).sendKeys(validPassword);

        listLogInCSS.get(1).sendKeys(Keys.ENTER);

    }

    @Test(priority = 10)
    public void twoBooksAreInCart() throws InterruptedException {
        goToBookstoreApp();
        addCookies();
        logIn();
        Thread.sleep(3000);

        WebElement book1 = driver.findElement(By.id("see-book-Git Pocket Guide"));
        Assert.assertTrue(book1.isDisplayed());

        WebElement book2 = driver.findElement(By.id("see-book-Learning JavaScript Design Patterns"));
        Assert.assertTrue(book2.isDisplayed());

    }

    @AfterMethod
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.quit();

    }
}
