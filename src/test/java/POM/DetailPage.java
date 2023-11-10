package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DetailPage {
    WebDriver driver;

    By mobileMenu = By.linkText("MOBILE");
    By priceText = By.cssSelector("span.price");
    By productImage = By.id("product-collection-image-1"); // Add the product image element here
    // You can add other detail page elements here as needed

    By xpiraPriceText = By.cssSelector("#product-price-1 > span.price");

    By xpiraClick = By.id("product-collection-image-1");

    By xpireDetailPrice = By.cssSelector("span.price");
    public DetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public void moblieClick(){
        driver.findElement(mobileMenu).click();
    }

    public String getDetailPrice() {
        return driver.findElement(priceText).getText();
    }

    public void clickProductImage() {
        driver.findElement(productImage).click();
    }

    public String xpirePriceText(){
        return driver.findElement(xpiraPriceText).getText();
    }

    public void xpiraImageClick(){
        driver.findElement(xpiraClick).click();
    }

    public String xpireDetailText(){
        return driver.findElement(xpireDetailPrice).getText();
    }
    // You can add methods to interact with other detail page elements here
}