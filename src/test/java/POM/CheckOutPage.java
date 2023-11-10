package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage {

    WebDriver driver;

    By addressSelector = By.id("billing-address-select");
    By firstNameInputLocator = By.id("billing:firstname");

    By middleNameInputLocator = By.id("billing:middlename");
    By lastNameInputLocator = By.id("billing:lastname");

    By companyInputLocator = By.id("billing:company");

    By address1InputLocator = By.id("billing:street1");

    By address2InputLocator = By.id("billing:street2");

    By cityInputLocator = By.id("billing:city");

    By stateSelector = By.id("billing:region_id");

    By zipInputLocator = By.id("billing:postcode");

    By countrySelector = By.id("billing:country_id");

    By telephoneInputLocator = By.id("billing:telephone");

    By faxInputLocator = By.id("billing:fax");

    By differenceAddressSelector = By.cssSelector("label[for='billing:use_for_shipping_no']");


    By useDifferentAddressLocator = By.cssSelector("label[for='billing:use_for_shipping_no']");
    By billingButtonLocator = By.cssSelector("button[onclick='billing.save()']");

    By shippingButtonLocator = By.cssSelector("button[onclick='shipping.save()']");
    By shippingMethodSaveButtonLocator = By.cssSelector("button[onclick='shippingMethod.save()']");
    By paymentMethodLocator = By.xpath("//label[normalize-space()='Check / Money order']");

    By paymentButtonLocator = By.cssSelector("button[onclick='payment.save()']");
    By placeOrderButtonLocator = By.cssSelector("button[title='Place Order']");

    By successOrderText = By.cssSelector("div[class='page-title'] h1");

    By orderNumberText = By.xpath("//div[@class='main-container col1-layout']//p[1]");



    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Phương thức để click vào "Use Different Address"
    public void clickUseDifferentAddress() {
        driver.findElement(useDifferentAddressLocator).click();
    }

    public void clickBillingButton(){
        driver.findElement(billingButtonLocator).click();
    }
    // Phương thức để click vào nút "Save Shipping Information"
    public void clickSaveShippingInformation() {
        driver.findElement(shippingButtonLocator).click();
    }

    // Phương thức để click vào nút "Save Shipping Method"
    public void clickSaveShippingMethod() {
        driver.findElement(shippingMethodSaveButtonLocator).click();
    }

    // Phương thức để chọn phương thức thanh toán "Check / Money order"
    public void selectPaymentMethod() {
        driver.findElement(paymentMethodLocator).click();
    }

    public void clickPaymentButton(){
        driver.findElement(paymentButtonLocator).click();
    }

    // Phương thức để click vào nút "Place Order"
    public void clickPlaceOrder() {
        driver.findElement(placeOrderButtonLocator).click();
    }

    // Thêm các phương thức khác tương tự cho việc điền thông tin địa chỉ, tên, điện thoại, và các phần tử khác khi cần thiết.




    public void selectAddress(String address){
        WebElement addressElement = driver.findElement(addressSelector);
        Select select = new Select(addressElement);
        select.selectByVisibleText(address);
    }
    public void enterFirstName(String firstName) {
        WebElement firstNameElement = driver.findElement(firstNameInputLocator);
        firstNameElement.clear();
        firstNameElement.sendKeys(firstName);
    }

    public void enterMiddleName(String middleName){
        WebElement middleNameElement = driver.findElement(middleNameInputLocator);
        middleNameElement.clear();
        middleNameElement.sendKeys(middleName);
    }

    public void enterLastName(String lastName) {
        WebElement lastNameElement = driver.findElement(lastNameInputLocator);
        lastNameElement.clear();
        lastNameElement.sendKeys(lastName);
    }

    public void enterCompany(String company){
        WebElement companyElement = driver.findElement(companyInputLocator);
        companyElement.clear();
        companyElement.sendKeys(company);
    }

    public void enterAddress1(String address1){
        WebElement address1Element = driver.findElement(address1InputLocator);
        address1Element.clear();
        address1Element.sendKeys(address1);
    }

    public void enterAddress2(String address2){
        WebElement address2Element = driver.findElement(address2InputLocator);
        address2Element.clear();
        address2Element.sendKeys(address2);
    }

    public void enterCity(String city){
        WebElement cityElement = driver.findElement(cityInputLocator);
        cityElement.clear();
        cityElement.sendKeys(city);
    }

    public void selectState(String state){
        WebElement stateElement = driver.findElement(stateSelector);
        Select select = new Select(stateElement);
        select.selectByVisibleText(state);
    }

    public void enterZip(String zip){
        WebElement zipElement = driver.findElement(zipInputLocator);
        zipElement.clear();
        zipElement.sendKeys(zip);
    }

    public void selectCountry(String country){
        WebElement countryElement = driver.findElement(countrySelector);
        Select select = new Select(countryElement);
        select.selectByVisibleText(country);
    }

    public void enterTelephone(String telephone){
        WebElement telephoneElement = driver.findElement(telephoneInputLocator);
        telephoneElement.clear();
        telephoneElement.sendKeys(telephone);
    }

    public void enterFax(String fax){
        WebElement faxElement = driver.findElement(faxInputLocator);
        faxElement.clear();
        faxElement.sendKeys(fax);
    }

    public void differenceAddressClick(){ driver.findElement(differenceAddressSelector).click();}

    public void verifyOrder() {
        // Sử dụng định danh successOrderText để tìm phần tử
        WebElement successOrderElement = driver.findElement(successOrderText);
        String successOrder = successOrderElement.getText();

        // Kiểm tra order và thực hiện các thao tác khác
        if (successOrder.contains("YOUR ORDER HAS BEEN RECEIVED.")) {
            System.out.println("ORDER SUCCESS");
            System.out.println(successOrder);
        } else {
            System.out.println("ORDER FAILED");
            System.out.println(successOrder);
        }
    }

    public void orderNumber(){
        WebElement orderNumberElement = driver.findElement(orderNumberText);
        String orderNumber = orderNumberElement.getText();
        System.out.println(orderNumber);
    }
}