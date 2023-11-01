package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class MobilePage {
        WebDriver driver;

        By emailaddressInputLocator = By.id("email_address");

        By messageInputLocator = By.id("message");


        public MobilePage(WebDriver driver) {
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

}
