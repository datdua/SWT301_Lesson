package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SharedPage {
    WebDriver driver;

    By emailaddressInputLocator = By.id("email_address");

    By messageInputLocator = By.id("message");

    By shareWishlist = By.cssSelector("button[title='Share Wishlist']");

    By shareWishListMessage = By.xpath("(//span[normalize-space()='Your Wishlist has been shared.'])[1]");

    By addWishlist = By.xpath("(//a[@class='link-wishlist'][normalize-space()='Add to Wishlist'])[1]");
    public SharedPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmailShared(String emailShare) {
        WebElement emailElement = driver.findElement(emailaddressInputLocator);
        emailElement.clear();
        emailElement.sendKeys(emailShare);
    }

    public void enterMessageShared(String message) {
        WebElement messageElement = driver.findElement(messageInputLocator);
        messageElement.clear();
        messageElement.sendKeys(message);
    }

    public void ShareWishListClick(){
        driver.findElement(shareWishlist).click();
    }

    public String ShareWishListMessageText(){
        WebElement successMessage = driver.findElement(shareWishListMessage);
        return successMessage.getText();
    }

    public void AddToWishListClick(){
        driver.findElement(addWishlist).click();
    }
}