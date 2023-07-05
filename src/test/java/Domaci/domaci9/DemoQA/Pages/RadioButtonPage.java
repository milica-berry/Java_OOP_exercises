package Domaci.domaci9.DemoQA.Pages;

import Domaci.domaci9.DemoQA.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RadioButtonPage extends BaseTest {
    public RadioButtonPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "main-header")
    public WebElement header;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/input")
    public WebElement yesRadioButton;

    @FindBy(id = "impressiveRadio")
    public WebElement impressiveRadioButton;

    @FindBy(id = "noRadio")
    public WebElement noRadioButton;


    @FindBy(className = "text-success")
    public WebElement textSuccessMessage;

    //-----------------

    public void clickOnYesRadioButton(){
        Actions actions = new Actions(driver);
        actions.click(yesRadioButton).perform();
    }

    public void clickOnImpressiveRadioButton(){
        Actions actions = new Actions(driver);
        actions.click(impressiveRadioButton).perform();
    }

    public void clickOnNoRadioButton(){
        Actions actions = new Actions(driver);
        actions.click(noRadioButton).perform();
    }






}

