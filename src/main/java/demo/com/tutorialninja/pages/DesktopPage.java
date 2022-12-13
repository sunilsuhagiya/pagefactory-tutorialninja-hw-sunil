package demo.com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import com.sun.org.apache.regexp.internal.RE;
import demo.com.tutorialninja.customlisteners.CustomListeners;
import demo.com.tutorialninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currencyLink;

    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktopsTab;

    @CacheLookup
    @FindBy(linkText = "Show All Desktops")
    WebElement showAllDesktop;

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-sort']")
    WebElement sortByNameZtoA;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    WebElement productsInDescendingOrderText;

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-sort']")
    WebElement sortByNameAtoZ;

    @CacheLookup
    @FindBy(linkText = "HP LP3065")
    WebElement productHpLP3065;


    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'HP LP3065')]")
    WebElement getHPLP3065Text;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'input-group date']//button")
    WebElement deliveryDate;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-quantity']")
    WebElement enterQuantity;

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCart;


    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement getProductAddedToShoppingCartText;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Shopping Cart')]")
    WebElement shoppingCart;

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement getShoppingCartText;

    @CacheLookup
    @FindBy(linkText = "HP LP3065")
    WebElement getHPLP3065Message;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement getDeliveryDateText;

    @CacheLookup
    @FindBy(xpath = "//td[contains(text(),'Product 21')]")
    WebElement getProduct21Text;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement getTotalPriceText;

    public void clickOnCurrencyLink(){
        clickOnElement(currencyLink);
        List<WebElement> currencyList = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu']/li"));
        for (WebElement e : currencyList) {
            if (e.getText().equalsIgnoreCase("£ Pound Sterling")) {
                e.click();
                break;
            }
        }
    }
    public void mouseHoverOnDesktop(){
        Reporter.log("Mouse Hover On Desktop" + desktopsTab.toString());
        mouseHoverToElementAndClick(desktopsTab);
        CustomListeners.test.log(Status.PASS,"Mouse Hover On Desktop");
    }
    public void clickOnShowAllDesktop(){
        Reporter.log("click On Show All Desktop" + showAllDesktop.toString());
        clickOnElement(showAllDesktop);
        CustomListeners.test.log(Status.PASS,"click On Show All Desktop");
    }
    public void sortByPositionNameZtoA(String text){
        Reporter.log("Sort " + text + " By Position NameZtoA" + sortByNameZtoA.toString());
        selectByVisibleTextFromDropDown(sortByNameZtoA,text);
        CustomListeners.test.log(Status.PASS,"sortByPositionNameZtoA" + text);
    }
    public void getProductsArrangeInDescendingOrderText(){
        // Get all the products name and stored into array list
        List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);
        // Select sort by Name Z - A
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (Z - A)");
        // After filter Z -A Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        System.out.println(afterSortByZToAProductsName);
        //Assert.assertEquals("Product not sorted into Z to A order",
        //  originalProductsName, afterSortByZToAProductsName);

    }
    public void sortByPositionNameAtoZ(String text){
        Reporter.log("Sort " + text + " By Position NameAtoZ" + sortByNameAtoZ.toString());
        selectByVisibleTextFromDropDown(sortByNameAtoZ,text);
        CustomListeners.test.log(Status.PASS,"sortByPositionNameAtoZ" + text);
    }
    public void clickOnProductHPLP3065(){
        Reporter.log("Click On Product HPLP3065" + productHpLP3065.toString());
        clickOnElement(productHpLP3065);
        CustomListeners.test.log(Status.PASS,"Click On Product HPLP3065");
    }
    public String getHPLP3065TextFromList(){
        Reporter.log("Get HPLP3065Text From List" + getHPLP3065Text.toString());
        CustomListeners.test.log(Status.PASS,"Get HPLP3065Text From List");
        return getTextFromElement(getHPLP3065Text);
    }
    public void clickOnDeliveryDate(){
        Reporter.log("Select Delivery Date" );
        String year = "2023";
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        //desktops.selectDeliveryDate();
        //clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        while (true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']"));
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }

    }
    public void enterQuantity1(String  num){
        Reporter.log("enter Quantity1" + enterQuantity.toString());
        driver.findElement(By.xpath("//input[@id='input-quantity']")).clear();
        sendTextToElement(enterQuantity,num);
        CustomListeners.test.log(Status.PASS,"enterQuantity1" + num);
    }
    public void clickOnAdToCart() {
        Reporter.log("Click On Add To Cart" + addToCart.toString());
        clickOnElement(addToCart);
        CustomListeners.test.log(Status.PASS,"Click On Add To Cart");
    }
    public String verifyProductAddedToShoppingCartText(){
        Reporter.log("verifyProductAddedToShoppingCartText" + getProductAddedToShoppingCartText.toString());
        return getTextFromElement(getProductAddedToShoppingCartText);
    }
    public void clickOnShoppingCart(){
        Reporter.log("clickOnShoppingCart" + shoppingCart.toString());
        clickOnElement(shoppingCart);
        CustomListeners.test.log(Status.PASS,"clickOnShoppingCart");
    }
    public String verifyTextShoppingCart(){
        Reporter.log("Verify Text ShoppingCart" + getShoppingCartText.toString());
        return getTextFromElement(getShoppingCartText);
    }
    public String verifyTextProductNameHPLP3065(){
        Reporter.log("VerifyTextProductNameHPLP3065" + getHPLP3065Message.toString());
        CustomListeners.test.log(Status.PASS,"VerifyTextProductNameHPLP3065");
        return getTextFromElement(getHPLP3065Message);
    }
    public String verifyDeliveryDate(){
        Reporter.log("verifyDeliveryDate" + getDeliveryDateText.toString());
        CustomListeners.test.log(Status.PASS,"verifyDeliveryDate");
        return getTextFromElement(getDeliveryDateText);
    }
    public String verifyTheModelProduct21Text(){
        Reporter.log("Verify TheModelProduct21 Text" + getProduct21Text.toString());
        CustomListeners.test.log(Status.PASS,"Verify TheModelProduct21 Text");
        return getTextFromElement(getProduct21Text);
    }
    public String verifyTheTotalPriceText(){
        Reporter.log("verifyTheTotalPriceText" + getTotalPriceText.toString());
        CustomListeners.test.log(Status.PASS,"verifyTheTotalPriceText");
        return getTextFromElement(getTotalPriceText);
    }
}


