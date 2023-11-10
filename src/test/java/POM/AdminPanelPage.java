package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminPanelPage {

    WebDriver driver;

    By userNameInput = By.id("username");
    By passwordInput = By.id("login");
    By loginButton = By.cssSelector("input[title='Login']");
    By closeMessageButton = By.xpath("//span[normalize-space()='close']");
    By salesMenu = By.xpath("//span[normalize-space()='Sales']");
    By orderMenu = By.xpath("//span[normalize-space()='Orders']");
    By orderIdInput = By.id("sales_order_grid_filter_real_order_id");
    By fromDateInput = By.cssSelector("body > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > table:nth-child(1) > thead:nth-child(2) > tr:nth-child(2) > th:nth-child(3) > div:nth-child(1) > div:nth-child(1) > input:nth-child(2)");
    By toDateInput = By.cssSelector("body > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > table:nth-child(1) > thead:nth-child(2) > tr:nth-child(2) > th:nth-child(3) > div:nth-child(1) > div:nth-child(2) > input:nth-child(2)");
    By searchButton = By.xpath("(//span[contains(text(),'Search')])[1]");

    public AdminPanelPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterUserName(String userName) {
        WebElement userNameElement = driver.findElement(userNameInput);
        userNameElement.clear();
        userNameElement.sendKeys(userName);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordInput);
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    public void clickCloseMessage() {
        driver.findElement(closeMessageButton).click();
    }
    public void clickSalesMenu() {
        driver.findElement(salesMenu).click();
    }
    public void clickOrderMenu() {
        driver.findElement(orderMenu).click();
    }
    public void enterOrderID(String orderID) {
        WebElement passwordElement = driver.findElement(orderIdInput);
        passwordElement.clear();
        passwordElement.sendKeys(orderID);
    }
    public void enterFromDate(String FromDate) {
        WebElement passwordElement = driver.findElement(fromDateInput);
        passwordElement.clear();
        passwordElement.sendKeys(FromDate);
    }
    public void enterToDate(String ToDate) {
        WebElement passwordElement = driver.findElement(toDateInput);
        passwordElement.clear();
        passwordElement.sendKeys(ToDate);
    }
    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }
}