package POM;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {

    WebDriver driver;

    By mobileLink = By.xpath("//a[normalize-space()='Mobile']");

    By iphoneCart = By.xpath("(//button[@title='Add to Cart'])[1]");

    By discountCode = By.id("coupon_code");

    By applyButton = By.cssSelector("button[title='Apply'] span span");

    By subTotalText = By.xpath("(//td)[13]");

    By discountText = By.xpath("(//td)[15]");

    By grandTotalText = By.xpath("(//td[@class='a-right'])[2]");

    By qtyInput = By.xpath("(//input[@title='Qty'])[1]");
    By errorMessage = By.xpath("(//span[contains(text(),'Some of the products cannot be ordered in requeste')])[1]");
    By emptyCartLink = By.xpath("(//span[contains(text(),'Empty Cart')])[1]");
    By emptyCartMessage = By.xpath("(//h1[normalize-space()='Shopping Cart is Empty'])[1]");

    By addToCart = By.xpath("(//button[@title='Add to Cart'])[2]");

    By UpdateCart = By.cssSelector("button[title='Update']");

    By ErrorMessage = By.xpath("(//span[contains(text(),'Some of the products cannot be ordered in requeste')])[1]");

    By sonyXperiaCompare = By.xpath("(//a[@class='link-compare'][normalize-space()='Add to Compare'])[3]");

    By iPhoneCompare = By.xpath("(//a[@class='link-compare'][normalize-space()='Add to Compare'])[1]");

    By compareButton = By.xpath("(//span[contains(text(),'Compare')])[2]");

    By popupHeading = By.xpath("(//h1[normalize-space()='Compare Products'])[1]");

    By sonyXperiaInPopup = By.xpath("(//a[normalize-space()='Sony Xperia'])[1]");

    By iPhoneInPopup = By.cssSelector("h2[class='product-name'] a[title='IPhone']");

    By tvMenu = By.linkText("TV");

    By wishListAdd = By.xpath("(//span[contains(text(),'Share Wishlist')])[1]");

    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
    }

    public void MobileClick(){
        driver.findElement(mobileLink).click();
    }

    public void IphoneAddToCartButton(){
        driver.findElement(iphoneCart).click();
    }

    public void ApplyClick(){
        driver.findElement(applyButton).click();
    }

    public void enterDiscountCode(String code) {
        WebElement codeElement = driver.findElement(discountCode);
        codeElement.clear();
        codeElement.sendKeys(code);
    }

    public String getSubtotal() {
        return driver.findElement(subTotalText).getText();
    }

    public String getDiscount() {
        return driver.findElement(discountText).getText();
    }

    public String getGrandTotal() {
        return driver.findElement(grandTotalText).getText();
    }


    public boolean verifyGrandTotal() {
        String subtotal = getSubtotal();
        String shipping = getDiscount();
        String grandTotal = getGrandTotal();

        double subtotalValue = Double.parseDouble(subtotal.replaceAll("[^\\d.]+", ""));
        double discountValue = Double.parseDouble(shipping.replaceAll("[^\\d.]+", ""));
        double grandTotalValue = Double.parseDouble(grandTotal.replaceAll("[^\\d.]+", ""));

        if (subtotalValue - discountValue == grandTotalValue) {
            System.out.println("Price is discounted by 5%.");
            System.out.println(grandTotalValue);
            return true;
        } else {
            System.out.println("Price is not discounted by 5%");
            System.out.println(grandTotalValue);
            return false;
        }
    }

    public void changeQuantity(String quantity) {
        WebElement qtyElement = driver.findElement(qtyInput);
        qtyElement.clear();
        qtyElement.sendKeys(quantity);
    }



    public void clickEmptyCartLink() {
        driver.findElement(emptyCartLink).click();
    }

    public boolean verifyEmptyCart() {
        WebElement emptyCartMessageElement = driver.findElement(emptyCartMessage);
        return emptyCartMessageElement.isDisplayed();
    }

    public void AddToCartClick(){
        driver.findElement(addToCart).click();
    }

    public void UpdateClick(){
        driver.findElement(UpdateCart).click();
    }

    public boolean VerifyErrorMessage(){
        WebElement errorElement = driver.findElement(ErrorMessage);
        return errorElement.isDisplayed();
    }

    public String GetErrorMessage(){
        WebElement errorElement = driver.findElement(ErrorMessage);
        return errorElement.getText();
    }

    public void sonyXperiaCompareClick() {
        driver.findElement(sonyXperiaCompare).click();
    }

    public void iPhoneCompareClick() {
        driver.findElement(iPhoneCompare).click();
    }

    public void compareButtonClick() {
        driver.findElement(compareButton).click();
    }

    public boolean verifyPopupHeading() {
        WebElement popupHeadingElement = driver.findElement(popupHeading);
        return popupHeadingElement.isDisplayed();
    }

    public String verifyPopupHeadingText() {
        WebElement popupHeadingElement = driver.findElement(popupHeading);
        return popupHeadingElement.getText();
    }

    public boolean verifySonyXperiaInPopup() {
        WebElement sonyXperiaInPopupElement = driver.findElement(sonyXperiaInPopup);
        return sonyXperiaInPopupElement.isDisplayed();
    }

    public boolean verifyIPhoneInPopup() {
        WebElement iPhoneInPopupElement = driver.findElement(iPhoneInPopup);
        return iPhoneInPopupElement.isDisplayed();
    }

    public String verifySonyXperiaInPopupText() {
        WebElement sonyXperiaInPopupElement = driver.findElement(sonyXperiaInPopup);
        return sonyXperiaInPopupElement.getText();
    }

    public String verifyIPhoneInPopupText() {
        WebElement iPhoneInPopupElement = driver.findElement(iPhoneInPopup);
        return iPhoneInPopupElement.getText();
    }

    public void TVMenuClick(){
        driver.findElement(tvMenu).click();
    }

    public void WishListClick(){
        driver.findElement(wishListAdd).click();
    }
}
