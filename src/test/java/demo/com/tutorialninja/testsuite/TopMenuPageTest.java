package demo.com.tutorialninja.testsuite;

import demo.com.tutorialninja.customlisteners.CustomListeners;
import demo.com.tutorialninja.pages.TopMenuPage;
import demo.com.tutorialninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(CustomListeners.class)
public class TopMenuPageTest extends BaseTest {

    TopMenuPage topMenuPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        topMenuPage = new TopMenuPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        topMenuPage.mouseHoverToElementAndClickOnDesktop();
        topMenuPage.selectMenu("Show All Desktops");
        Assert.assertEquals(topMenuPage.getTextDesktop(), "Desktops", "Message not displayed");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        topMenuPage.mouseHoverOnLaptopsAndNotebooksTab();
        topMenuPage.selectMenu("Show All Laptops & Notebooks");
        Assert.assertEquals(topMenuPage.getLaptopsAndNotebooksText(), "Laptops & Notebooks", "Massage not displayed");
    }

    @Test(groups = {"regression"})
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        topMenuPage.mouseHoverToComponentsTab();
        topMenuPage.selectMenu("Show All Components");
        Assert.assertEquals(topMenuPage.getComponentsText(), "Components", "Message not displayed");

    }

}
