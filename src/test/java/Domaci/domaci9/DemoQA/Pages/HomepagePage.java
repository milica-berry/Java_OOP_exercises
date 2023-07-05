package Domaci.domaci9.DemoQA.Pages;

import Domaci.domaci9.DemoQA.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomepagePage extends BaseTest {

    public HomepagePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".card.mt-4.top-card")
    public List<WebElement> cards;

    //-----------------

    public void clickOnElements() {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getText().equals("Elements")) {
                scrollIntoView(cards.get(i));
                cards.get(i).click();
                break;
            }
        }
    }
}
