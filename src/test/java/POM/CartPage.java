package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CartPage {

    WebDriver driver;

    By myWishListLink = By.linkText("MY WISHLIST");
    By addToCartButton = By.xpath("//span[contains(text(),'Add to Cart')]");

    By checkoutButton = By.cssSelector("li[class='method-checkout-cart-methods-onepage-bottom'] button[title='Proceed to Checkout']");

    By countryDropdown = By.id("country");
    By stateDropdown = By.id("region_id");
    By zipInput = By.id("postcode");
    By estimateLink = By.xpath("//span[contains(text(),'Estimate')]");
    By tickFlatRate = By.cssSelector("label[for='s_method_flatrate_flatrate']");
    By updateTotalButton = By.xpath("//span[contains(text(),'Update Total')]");

    By subtotalText = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(2) > span:nth-child(1)");

    By shippingText = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(2) > td:nth-child(2) > span:nth-child(1)");

    By grandTotal = By.cssSelector("strong span[class='price']");

    By flatRateMoneyText = By.cssSelector("label[for='s_method_flatrate_flatrate'] span[class='price']");

    By qtyText = By.cssSelector("input[title='Qty']");

    By updateqtyButton = By.cssSelector("button[title='Update']");

    By flatrateText = By.cssSelector("label[for='s_method_flatrate_flatrate']");

    By reOderButton = By.cssSelector("tr[class='first odd'] a[class='link-reorder']");

    By orderLink = By.linkText("MY ORDERS");

    By viewOrder = By.xpath("//tr[@class='first odd']//a[contains(text(),'View Order')]");

    By printOrder = By.xpath("//a[normalize-space()='Print Order']");

    By procedToCheckOutButton= By.cssSelector("li[class='method-checkout-cart-methods-onepage-bottom'] button[title='Proceed to Checkout']");



    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMyWishList(){driver.findElement(myWishListLink).click();}
    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void chooseCountry() {
        WebElement dropdownElement = driver.findElement(countryDropdown);
        Select selectOption = new Select(dropdownElement);
        selectOption.selectByVisibleText("United States");
    }

    public void chooseState() {
        WebElement dropdownElement = driver.findElement(stateDropdown);
        Select selectOption = new Select(dropdownElement);
        selectOption.selectByVisibleText("Florida");
    }

    public void zipEmail(String zip) {
        WebElement emailElement = driver.findElement(zipInput);
        emailElement.clear();
        emailElement.sendKeys(zip);
    }

    public void qtyEnter(String qty) {
        WebElement qtyElement = driver.findElement(qtyText);
        qtyElement.clear();
        qtyElement.sendKeys(qty);
    }

    public void clickUpdateQty(){driver.findElement(updateqtyButton).click();};
    public void clickEstimateLink() {
        driver.findElement(estimateLink).click();
    }
    public void clickFlatRate() {
        driver.findElement(tickFlatRate).click();
    }
    public void clickUpdateButton() {
        driver.findElement(updateTotalButton).click();
    }

    public  void clickProcedCheckOut(){ driver.findElement(procedToCheckOutButton).click();}
    public void clickOrder(){driver.findElement(orderLink).click();}

    public void clickCheckoutButton(){driver.findElement(checkoutButton).click();}

    public void clickReOrder(){driver.findElement(reOderButton).click();}

    public void clickViewOrder(){driver.findElement(viewOrder).click();}

    public void clickPrintOrder(){driver.findElement(printOrder).click();}



    public String flatRateMoneyCheck(){
        return driver.findElement(flatRateMoneyText).getText();
    }
    public String getSubtotal() {
        return driver.findElement(subtotalText).getText();
    }

    public String getShipping() {
        return driver.findElement(shippingText).getText();
    }

    public String getGrandTotal() {
        return driver.findElement(grandTotal).getText();
    }




    public String getSuccessMessage() {
        WebElement successMessageElement = driver.findElement(flatrateText);
        return successMessageElement.getText();
    }

    public boolean verifyShippingCost(String expectedText) {
        String successMessage = getSuccessMessage();
        if (successMessage.contains(expectedText)) {
            System.out.println("Shipping cost generated success");
            System.out.println(successMessage);
            return true;
        } else {
            System.out.println("Shipping cost generated unsuccessfully.");
            return false;
        }
    }

    public boolean verifyGrandTotal() {
        String subtotal = getSubtotal();
        String shipping = getShipping();
        String grandTotal = getGrandTotal();

        double subtotalValue = Double.parseDouble(subtotal.replaceAll("[^\\d.]+", ""));
        double shippingValue = Double.parseDouble(shipping.replaceAll("[^\\d.]+", ""));
        double grandTotalValue = Double.parseDouble(grandTotal.replaceAll("[^\\d.]+", ""));

        if (subtotalValue + shippingValue == grandTotalValue) {
            System.out.println("Shipping cost is added to total. Grand Total matches Subtotal + Shipping.");
            System.out.println(grandTotalValue);
            return true;
        } else {
            System.out.println("Shipping cost is not added to total. Grand Total does not match Subtotal + Shipping.");
            return false;
        }
    }


}