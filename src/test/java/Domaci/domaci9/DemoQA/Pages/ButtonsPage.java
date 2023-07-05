package Domaci.domaci9.DemoQA.Pages;

import Domaci.domaci9.DemoQA.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ButtonsPage extends BaseTest {

    public ButtonsPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "doubleClickBtn")
    public WebElement doubleClickButton;

    @FindBy(id = "rightClickBtn")
    public WebElement rightClickButton;

    @FindBy(partialLinkText = "Click Me")
    public WebElement dynamicClickButton;

    @FindBy(id = "doubleClickMessage")
    public WebElement doubleClickMessage;

    @FindBy(id = "rightClickMessage")
    public WebElement rightClickMessage;

    @FindBy(id = "dynamicClickMessage")
    public WebElement dynamicClickMessage;


    @FindBy(css = ".btn.btn-primary")
    public List<WebElement> buttons;

    public void clickOnDynamicButton() {
        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).getText().equals("Click Me")) {
                scrollIntoView(buttons.get(i));
                buttons.get(i).click();
                break;
            }
        }
    }


    //-----------------


    public void doubleClick() {
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickButton).perform();
    }

    public void rightClick(){
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickButton).perform();

    }

    public void dynamicClick(){
        dynamicClickButton.click();

    }









}
