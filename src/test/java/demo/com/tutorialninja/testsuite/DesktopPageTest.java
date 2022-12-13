package demo.com.tutorialninja.testsuite;

import demo.com.tutorialninja.customlisteners.CustomListeners;
import demo.com.tutorialninja.pages.DesktopPage;
import demo.com.tutorialninja.pages.MyAccountPage;
import demo.com.tutorialninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class DesktopPageTest extends BaseTest {
 DesktopPage desktopPage;

 @BeforeMethod(alwaysRun = true)
 public void inIt() {
  desktopPage = new DesktopPage();
 }

 @Test(groups = {"sanity","regression"})
 public void verifyProductsPriceDisplayHighToLowSuccessfully(){
desktopPage.clickOnCurrencyLink();
desktopPage.mouseHoverOnDesktop();
desktopPage.clickOnShowAllDesktop();
desktopPage.sortByPositionNameZtoA("Name (Z - A)");
desktopPage.getProductsArrangeInDescendingOrderText();

 }
 @Test(groups = {"smoke","regression"})
 public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
  desktopPage.clickOnCurrencyLink();
  desktopPage.mouseHoverOnDesktop();
  desktopPage.clickOnShowAllDesktop();
  desktopPage.sortByPositionNameAtoZ("Name (A - Z)");
  desktopPage.clickOnProductHPLP3065();
  String expectedText = "HP LP3065";
  Assert.assertEquals(desktopPage.getHPLP3065TextFromList(),expectedText,"Product not found");
  desktopPage.clickOnDeliveryDate();
  desktopPage.enterQuantity1("1");
  desktopPage.clickOnAdToCart();
  Thread.sleep(5000);
  String expectedProductText = "Success: You have added HP LP3065 to your shopping cart!\n" +
          "×";
  Assert.assertEquals(desktopPage.verifyProductAddedToShoppingCartText(),expectedProductText,"Error message not displayed");
  desktopPage.clickOnShoppingCart();
  Thread.sleep(2000);
  Assert.assertEquals(desktopPage.verifyTextShoppingCart(),"Shopping Cart  (1.00kg)","Error message not displayed");
  Assert.assertEquals(desktopPage.verifyTextProductNameHPLP3065(),"HP LP3065","Product name not displayed");
  Thread.sleep(2000);
  Assert.assertEquals(desktopPage.verifyDeliveryDate(),"Delivery Date: 2023-11-30","Delivery not displayed");
  Assert.assertEquals(desktopPage.verifyTheModelProduct21Text(),"Product 21","Message not displayed");
  Assert.assertEquals(desktopPage.verifyTheTotalPriceText(),"£74.73","Price not displayed");
 }

}
