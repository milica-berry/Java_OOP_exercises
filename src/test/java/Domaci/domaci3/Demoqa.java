package Domaci.domaci3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Demoqa {

    public static void main(String[] args) throws InterruptedException {

        //Domaci Zadatak 2:
        //Ulogujte se na demoqa(https://demoqa.com/ -> Book Store Application) preko cookies-a, dodati dve knjig
        //e na svoj nalog, zatim se izlogovati brisanjem cookies-a.
        //Ulogovati se ponovo preko log-in forme i potvrditi da se knjige i dalje nalaze na nalogu.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/");

        String username = "milenjivac";
        String password = "Ovojemojpassword1!";



        WebElement bookStoreApp = driver.findElement(By.cssSelector(".avatar.mx-auto.white"));
        bookStoreApp.click();



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

        List<WebElement> listLogInCSS = driver.findElements(By.cssSelector(".mr-sm-2.form-control"));


        listLogInCSS.get(0).sendKeys(username);
        listLogInCSS.get(1).sendKeys(password);

        listLogInCSS.get(1).sendKeys(Keys.ENTER);


        Thread.sleep(3000);

        WebElement book1 = driver.findElement(By.id("see-book-Git Pocket Guide"));

        Assert.assertTrue(book1.isDisplayed());

        WebElement book2 = driver.findElement(By.id("see-book-Learning JavaScript Design Patterns"));

        Assert.assertTrue(book2.isDisplayed());


    }
}
