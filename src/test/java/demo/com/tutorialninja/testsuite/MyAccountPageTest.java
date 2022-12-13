package demo.com.tutorialninja.testsuite;

import demo.com.tutorialninja.customlisteners.CustomListeners;
import demo.com.tutorialninja.pages.MyAccountPage;
import demo.com.tutorialninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class MyAccountPageTest extends BaseTest {
    MyAccountPage myAccountPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        myAccountPage = new MyAccountPage();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        myAccountPage.clickOnMyAccountLink();
        myAccountPage.selectMyAccountOptions("Register");
        Assert.assertEquals(myAccountPage.getRegisterAccountMessage(),"Register Account","Message not displayed");
    }
    @Test(groups = {"smoke","regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        myAccountPage.clickOnMyAccountLink();
        myAccountPage.selectMyAccountOptions("Login");
        Assert.assertEquals(myAccountPage.getReturningCustomerMessage(),"Returning Customer","Message not displayed");
    }
    @Test(groups = {"regression"})
    public void verifyThatUserRegisterAccountSuccessfully(){
        myAccountPage.clickOnMyAccountLink();
        myAccountPage.selectMyAccountOptions("Register");
        myAccountPage.enterFirstName("Dev");
        myAccountPage.enterLastName("Coldo");
        myAccountPage.enterEmailId("dev123"+getAlphaNumericString(3)+"@gmail.com");
        myAccountPage.enterPhoneNumber("1234567890");
        myAccountPage.enterPassword("Dev123");
        myAccountPage.enterConfirmPassword("Dev123");
        myAccountPage.clickSubscribeOnYesRadioButton();
        myAccountPage.clickOnPrivacyPolicyCheckBox();
        myAccountPage.clickOnContinue1();
        Assert.assertEquals(myAccountPage.getAccountCreatedMessage(),"Your Account Has Been Created!","Message not displayed");
        myAccountPage.clickOnContinueButton2();
        myAccountPage.clickOnMyAccountTab();
        myAccountPage.selectMyAccountOptions("Logout");
        Assert.assertEquals(myAccountPage.getAccountLogoutMessage(),"Account Logout","Message not displayed");
        myAccountPage.clickOnContinueButton3();

    }
    @Test(groups = {"regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        myAccountPage.clickOnMyAccountLink();
        myAccountPage.selectMyAccountOptions("Login");
        myAccountPage.enterEmailId("dev123"+getAlphaNumericString(3)+"@gmail.com");
        myAccountPage.enterPassword("Dev123");
        myAccountPage.clickOnLogin();
       // Assert.assertEquals(myAccountPage.getMyAccountText(),"My Account","My account text not displayed");
        myAccountPage.clickOnMyAccountTab();
        myAccountPage.selectMyAccountOptions("Logout");
        Assert.assertEquals(myAccountPage.getAccountLogoutMessage(),"Account Logout","Account Logout text not displayed");
        myAccountPage.clickOnContinueButton3();
    }

}
