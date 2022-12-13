package demo.com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
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

public class LaptopsAndNotebooksPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currencyLink;

    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopsAndDesktopTab;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Show All Laptops & Notebooks')]")
    WebElement showAllLaptopsAndNotebooksTab;

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-sort']")
    WebElement sortByPriceHighToLow;

    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    WebElement getSortByHighToLowOrder;

    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement macBookTab;

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCartButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement getSuccessMessage;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Shopping Cart')]")
    WebElement shoppingCartLink;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Shopping Cart')]")
    WebElement getShoppingCartText;

    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement getProductMacBookText;

    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    WebElement changeQuantityTo2;

    @CacheLookup
    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")
    WebElement updateTab;

    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
    WebElement getMessageModifiedCart;

    @CacheLookup
    @FindBy(xpath = "//tbody/tr[1]/td[6]")
    WebElement getTotalPriceText;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Checkout')]")
    WebElement checkoutButton;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Checkout')]")
    WebElement getCheckoutText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='col-sm-6']//h2")
    WebElement getNewCustomerText;

    @CacheLookup
    @FindBy(xpath = "//input[@name='account' and @value='guest']")
    WebElement guestCheckoutRadioButton;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-account']")
    WebElement continueTab;

    @CacheLookup
    @FindBy(name = "firstname")
    WebElement nameField;

    @CacheLookup
    @FindBy(name = "lastname")
    WebElement lastnameField;

    @CacheLookup
    @FindBy(id = "input-payment-email")
    WebElement emailField;

    @CacheLookup
    @FindBy(name = "telephone")
    WebElement telephone;

    @CacheLookup
    @FindBy(name = "address_1")
    WebElement address1;

    @CacheLookup
    @FindBy(name = "city")
    WebElement cityName;

    @CacheLookup
    @FindBy(name = "postcode")
    WebElement postCode;

    @CacheLookup
    @FindBy(id = "input-payment-country")
    WebElement countryName;

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-payment-zone']")
    WebElement zoneName;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-guest']")
    WebElement continueButton;

    @CacheLookup
    @FindBy(xpath = "//textarea[@name='comment']")
    WebElement addCommentsToTextArea;

    @CacheLookup
    @FindBy(xpath = "//input[@name='agree']")
    WebElement termsAndConditionsCheckBox;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-payment-method']")
    WebElement finalContinueButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement getPaymentMethodMessage;


    public void mouseHoverOnLaptopsAndDesktopTab() {
        Reporter.log("MouseHover On LaptopsAndDesktopTab" + laptopsAndDesktopTab.toString());
        mouseHoverToElementAndClick(laptopsAndDesktopTab);
        CustomListeners.test.log(Status.PASS,"MouseHover On LaptopsAndDesktopTab");
    }

    public void clickOnShowAllLaptopsAndNotebooks() {
        Reporter.log("clickOnShowAllLaptopsAndNotebooks" + showAllLaptopsAndNotebooksTab.toString());
        clickOnElement(showAllLaptopsAndNotebooksTab);
        CustomListeners.test.log(Status.PASS,"clickOnShowAllLaptopsAndNotebooks");
    }

    public void sortByPriceHighToLow() {
        Reporter.log("Sort By PriceHighToLow" + sortByPriceHighToLow.toString());
        selectByVisibleTextFromDropDown(sortByPriceHighToLow, "Price (High > Low)");
        CustomListeners.test.log(Status.PASS,"Sort By PriceHighToLow");
    }

    public String GetSortByHighToLowOrder() {
        // Get all the products price and stored into array list
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(originalProductsPrice);
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        System.out.println(originalProductsPrice);
        // Select sort by Price (High > Low)
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (Low > High)");
        // After filter Price (High > Low) Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(afterSortByPrice);
        // Assert.assertEquals("Product not sorted by price High to Low",
        // originalProductsPrice, afterSortByPrice);

        return null;

    }

    public void clickOnCurrencyLink() {
        clickOnElement(currencyLink);
        List<WebElement> currencyList = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu']/li"));
        for (WebElement e : currencyList) {
            if (e.getText().equalsIgnoreCase("£ Pound Sterling")) {
                e.click();
                break;
            }
        }
    }

    public void clickOnMacBookTab() {
        Reporter.log("Click On MacBookTab" + macBookTab.toString());
        clickOnElement(macBookTab);
        CustomListeners.test.log(Status.PASS,"Click On MacBookTab");
    }

    public void clickOnAddToCartButton() {
        Reporter.log("Click On AddToCartButton" + addToCartButton.toString());
        clickOnElement(addToCartButton);
        CustomListeners.test.log(Status.PASS,"Click On AddToCartButton");
    }

    public String getSuccessTextFromLink() {
        Reporter.log("Get SuccessText From Link" + getSuccessMessage.toString());
        CustomListeners.test.log(Status.PASS,"Get SuccessText From Link");
        return getTextFromElement(getSuccessMessage);
    }

    public void clickOnShoppingCart() {
        Reporter.log("Click On ShoppingCart" + shoppingCartLink.toString());
        clickOnElement(shoppingCartLink);
        CustomListeners.test.log(Status.PASS,"Click On ShoppingCart");
    }

    public String getShoppingCartMessage() {
        Reporter.log("get ShoppingCart Message" + getShoppingCartText.toString());
        CustomListeners.test.log(Status.PASS,"get ShoppingCart Message");
        return getTextFromElement(getShoppingCartText);
    }

    public String getVerifyProductMacbook() {
        Reporter.log("Get VerifyProduct Macbook" + getProductMacBookText.toString());
        CustomListeners.test.log(Status.PASS,"Get VerifyProduct Macbook");
        return getTextFromElement(getProductMacBookText);
    }

    public void changeQuantityTo2() {
        driver.findElement(By.xpath("//input[contains(@name, 'quantity')]")).clear();
    }

    public void sendTextChangeQuantityTo2(String text) {
        Reporter.log("sendTextChangeQuantityTo2" + changeQuantityTo2.toString());
        sendTextToElement(changeQuantityTo2, "text");
        CustomListeners.test.log(Status.PASS,"sendTextChangeQuantityTo2" + text);
    }

    public void clickOnUpdateCart() {
        Reporter.log("Click On UpdateCart" + updateTab.toString());
        clickOnElement(updateTab);
        CustomListeners.test.log(Status.PASS,"Click On UpdateCart");
    }

    public String getSuccessModifiedCartMessage() {
        Reporter.log("getSuccessModifiedCartMessage" + getMessageModifiedCart.toString());
        return getTextFromElement(getMessageModifiedCart);
    }

    public String getVerifyTotal() {
        Reporter.log("Get VerifyTotal" + getTotalPriceText.toString());
        return getTextFromElement(getTotalPriceText);
    }

    public void clickOnCheckoutButton() {
        Reporter.log("Click On CheckoutButton" + checkoutButton.toString());
        clickOnElement(checkoutButton);
        CustomListeners.test.log(Status.PASS,"Click On CheckoutButton");
    }

    public String getCheckoutText() {
        Reporter.log("Get Checkout Text" + getCheckoutText.toString());
        return getTextFromElement(getCheckoutText);
    }

    public String getNewCustomerText() {
        Reporter.log("Get NewCustomer Text" + getNewCustomerText.toString());
        return getTextFromElement(getNewCustomerText);
    }

    public void clickOnGuestCheckoutRadioButton() {
        Reporter.log("Click On GuestCheckoutRadioButton" + guestCheckoutRadioButton.toString());
        clickOnElement(guestCheckoutRadioButton);
        CustomListeners.test.log(Status.PASS,"Click On GuestCheckoutRadioButton");
    }

    public void clickOnContinueTab() {
        Reporter.log("Click On ContinueTab" + continueTab.toString());
        clickOnElement(continueTab);
        CustomListeners.test.log(Status.PASS,"Click On ContinueTab");
    }

    public void enterName(String name) {
        Reporter.log("Enter Name " + name + " in firstname field" + nameField.toString());
        sendTextToElement(nameField, name);
        CustomListeners.test.log(Status.PASS,"Enter Name" + name);
    }

    public void enterLastName(String lastname) {
        Reporter.log("Enter LastName " + lastname + " in lastname field " + lastnameField.toString());
        sendTextToElement(lastnameField, lastname);
        CustomListeners.test.log(Status.PASS,"Enter LastName" + lastname);
    }

    public void enterEmail(String email) {
        Reporter.log("Enter Email  " + email + " to email field" + emailField.toString());
        sendTextToElement(emailField, email);
        CustomListeners.test.log(Status.PASS,"Enter Email " + email);
    }

    public void enterTelephone(String phone) {
        Reporter.log("Enter Telephone " + phone + " in telephone field " + phone);
        sendTextToElement(telephone, phone);
        CustomListeners.test.log(Status.PASS,"Enter Telephone" + phone);
    }

    public void enterAddress(String street) {
        Reporter.log("enter Address" + address1);
        sendTextToElement(address1, street);
        CustomListeners.test.log(Status.PASS,"enter Address" + street);
    }

    public void enterCity(String city) {
        Reporter.log("Enter City " + cityName.toString());
        sendTextToElement(cityName, city);
        CustomListeners.test.log(Status.PASS,"Enter City" + city);
    }

    public void enterPostcode(String code) {
        Reporter.log("Enter Postcode" + postCode.toString());
        sendTextToElement(postCode, code);
        CustomListeners.test.log(Status.PASS,"Enter Postcode" + code);
    }

    public void enterCountry(String country) {
        Reporter.log("enter Country" + countryName.toString());
        sendTextToElement(countryName, country);
        CustomListeners.test.log(Status.PASS,"enter Country" + country);
    }

    public void enterZone(String state) {
        Reporter.log("enter Zone" + zoneName.toString());
        sendTextToElement(zoneName, state);
        CustomListeners.test.log(Status.PASS,"enter Zone" + state);
    }

    public void clickOnContinueButton() {
        Reporter.log("clickOnContinueButton" + continueButton.toString());
        clickOnElement(continueButton);
        CustomListeners.test.log(Status.PASS,"clickOnContinueButton");
    }

    public void enterTextToTextArea(String message) {
        Reporter.log("enterTextToTextArea" + addCommentsToTextArea.toString());
        sendTextToElement(addCommentsToTextArea, message);
        CustomListeners.test.log(Status.PASS,"enterTextToTextArea" + message);
    }

    public void clickOnTermsAndConditionsCheckbox() {
        Reporter.log("clickOnTermsAndConditionsCheckbox" + termsAndConditionsCheckBox.toString());
        clickOnElement(termsAndConditionsCheckBox);
        CustomListeners.test.log(Status.PASS,"clickOnTermsAndConditionsCheckbox");
    }

    public void clickOnFinalContinueButton() {
        Reporter.log("clickOnFinalContinueButton" + finalContinueButton.toString());
        clickOnElement(finalContinueButton);
        CustomListeners.test.log(Status.PASS,"clickOnFinalContinueButton");
    }

    public String getWarningPaymentMethodRequiredText() {
        Reporter.log("getWarningPaymentMethodRequiredText" + getPaymentMethodMessage.toString());
        return getTextFromElement(getPaymentMethodMessage);
    }
}

