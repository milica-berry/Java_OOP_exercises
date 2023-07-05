package Domaci.domaci9.DemoQA.Tests;

import Domaci.domaci9.DemoQA.Base.BaseTest;
import Domaci.domaci9.DemoQA.Pages.ButtonsPage;
import Domaci.domaci9.DemoQA.Pages.HomepagePage;
import Domaci.domaci9.DemoQA.Pages.RadioButtonPage;
import Domaci.domaci9.DemoQA.Pages.SidebarPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest {

    public HomepagePage homepagePage;
    public SidebarPage sidebarPage;
    public RadioButtonPage radioButtonPage;
    public ButtonsPage buttonsPage;

    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomepagePage();
        sidebarPage = new SidebarPage();
        radioButtonPage = new RadioButtonPage();
        buttonsPage = new ButtonsPage();
        driver.manage().window().maximize();
        driver.get(homeURL);
    }

    @Test
    public void radioButtonsTest() {
        homepagePage.clickOnElements();
        Assert.assertEquals(driver.getCurrentUrl(), elementsURL);
        sidebarPage.clickOnButton("Radio Button");
        Assert.assertEquals(driver.getCurrentUrl(), radioButtonsURL);
        scrollIntoView(radioButtonPage.yesRadioButton);
        radioButtonPage.clickOnYesRadioButton();
        Assert.assertTrue(radioButtonPage.yesRadioButton.isEnabled());
        Assert.assertTrue(radioButtonPage.textSuccessMessage.isDisplayed());
        Assert.assertEquals(radioButtonPage.textSuccessMessage.getText(), "Yes");

        radioButtonPage.clickOnImpressiveRadioButton();
        Assert.assertTrue(radioButtonPage.impressiveRadioButton.isEnabled());
        Assert.assertTrue(radioButtonPage.textSuccessMessage.isDisplayed());
        Assert.assertEquals(radioButtonPage.textSuccessMessage.getText(), "Impressive");

        radioButtonPage.clickOnNoRadioButton();
        Assert.assertFalse(radioButtonPage.noRadioButton.isEnabled());
        Assert.assertEquals(radioButtonPage.textSuccessMessage.getText(), "Impressive");



    }


    @Test
    public void buttonsTest() {
        homepagePage.clickOnElements();
        Assert.assertEquals(driver.getCurrentUrl(), elementsURL);
        sidebarPage.clickOnButton("Buttons");
        Assert.assertEquals(driver.getCurrentUrl(), buttonsURL);

        buttonsPage.doubleClick();
        Assert.assertTrue(buttonsPage.doubleClickMessage.isDisplayed());
        Assert.assertEquals(buttonsPage.doubleClickMessage.getText(), "You have done a double click");

        buttonsPage.rightClick();
        Assert.assertTrue(buttonsPage.rightClickMessage.isDisplayed());
        Assert.assertEquals(buttonsPage.rightClickMessage.getText(), "You have done a right click");

        buttonsPage.clickOnDynamicButton();
        Assert.assertTrue(buttonsPage.dynamicClickMessage.isDisplayed());
        Assert.assertEquals(buttonsPage.dynamicClickMessage.getText(), "You have done a dynamic click");


    }
}
