package Lesson;

import POM.CartPage;
import POM.CheckOutPage;
import POM.LoginPage;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;

import static org.openqa.selenium.OutputType.FILE;

@Test
public class TC08 {

    public static void testcase08() {

        String emailAddress = "nhom6@gmail.com";
        String password = "123456";
        String zip = "5000";
        String qty = "10";

        //init web driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            CheckOutPage checkoutPage = new CheckOutPage(driver);
            CartPage cartPage = new CartPage(driver);

            //Step1: Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            //timing
            Thread.sleep(2000);

            //Step2: Click on my account link
            LoginPage loginPage = new LoginPage(driver);
            loginPage.clickMyAccountLink();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //timing
            Thread.sleep(2000);

            //Step 3: Login in application using previously created credential
            loginPage.enterEmail(emailAddress);

            //timing
            Thread.sleep(1000);

            loginPage.enterPassword(password);

            //timing
            Thread.sleep(1000);

            //Step 4: Click Login
            loginPage.clickLogin();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //timing
            Thread.sleep(2000);

            //Step 4: Click on 'REORDER' link , change QTY & click Update

            cartPage.clickReOrder();
            Thread.sleep(2000);

            cartPage.qtyEnter(qty);
            //timing
            Thread.sleep(2000);

            cartPage.clickUpdateQty();


            //timing
            Thread.sleep(2000);

            //Enter general shipping country, state/province and zip for the shipping cost estimate
            cartPage.chooseCountry();

            //timing
            Thread.sleep(1000);

            cartPage.chooseState();

            //timing
            Thread.sleep(1000);

            cartPage.zipEmail(zip);

            //timing
            Thread.sleep(1000);

            //Click Estimate
            cartPage.clickEstimateLink();

            //Verify Shipping cost generated


            //Step 8. Verify Shipping cost generated
            String expectedShippingCostText = "Fixed - " + cartPage.flatRateMoneyCheck();
            cartPage.verifyShippingCost(expectedShippingCostText);
            Thread.sleep(2000);
            //Screenshot
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(FILE);
            String png = ("C:\\Users\\Admin\\IdeaProjects\\SWT301_Lesson\\screenshots" + "TC06" + "_1.png");
            FileUtils.copyFile(scrFile, new File(png));
//
            //Select Shipping Cost, Update Total
            cartPage.clickFlatRate();

            //timing
            Thread.sleep(2000);

            cartPage.clickUpdateButton();

            //timing
            Thread.sleep(2000);

            //Step5. Verify Grand Total is changed

            cartPage.verifyGrandTotal();


            //Screenshot
            scrFile = ((TakesScreenshot)driver).getScreenshotAs(FILE);
            png = ("C:\\Users\\Admin\\IdeaProjects\\SWT301_Lesson\\screenshots" + "TC08" + "_1.png");
            FileUtils.copyFile(scrFile, new File(png));
            Thread.sleep(2000);

            // Click "Proceed to Checkout"
            cartPage.clickCheckoutButton();
            Thread.sleep(2000);
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }


            //Step6. Complete Billing & Shipping Information
            Thread.sleep(4000);
            checkoutPage.clickUseDifferentAddress();
            Thread.sleep(4000);
            checkoutPage.clickBillingButton();
            Thread.sleep(4000);
            checkoutPage.clickSaveShippingInformation();
            Thread.sleep(4000);
            checkoutPage.clickSaveShippingMethod();
            Thread.sleep(4000);
            checkoutPage.selectPaymentMethod();
            Thread.sleep(4000);
            checkoutPage.clickPaymentButton();
            Thread.sleep(4000);
            checkoutPage.clickPlaceOrder();
            Thread.sleep(2000);

            Thread.sleep(2000);

            //Step7. Verify order is generated and note the order number
            checkoutPage.verifyOrder();
            Thread.sleep(2000);



            Thread.sleep(2000);
            scrFile = ((TakesScreenshot)driver).getScreenshotAs(FILE);
            png = ("C:\\Users\\Admin\\IdeaProjects\\SWT301_Lesson\\screenshots" + "TC08" + "_2.png");
            FileUtils.copyFile(scrFile, new File(png));

            checkoutPage.orderNumber();
            Thread.sleep(2000);

        } catch (Exception e){
            e.printStackTrace();
        }

        //Quit browser session
        driver.quit();

    }
}
