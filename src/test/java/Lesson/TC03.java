package Lesson;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TC03 {
    @Test
    public void testcase03() {
        int scc = 0;
        String testCaseName = "TC03";

        StringBuffer verificationError = new StringBuffer();
        // Init web driver session

        WebDriver driver = driverFactory.getChromeDriver();
        try {
            // Step1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org");
            Thread.sleep(1000);

            // Step2. Click on MOBILE menu
            driver.findElement(By.linkText("MOBILE")).click();
            Thread.sleep(1000);

            // Step3. Click on "ADD TO CART" for Sony Xperia mobile
            driver.findElement(By.xpath("(//button[@title='Add to Cart'])[2]")).click();
            Thread.sleep(1000);

            // Step4. Change "QTY" value to 1000 and click "UPDATE" button.Expected that an error is displayed "The requested quantity for "Sony Xperia" is not available.
            WebElement qtyInput = driver.findElement(By.xpath("(//input[@title='Qty'])[1]"));
            qtyInput.clear();
            qtyInput.sendKeys("1000");
            driver.findElement(By.cssSelector("button[title='Update']")).click();
            Thread.sleep(1000);

            // Step5. Verify the error message
            WebElement errorElement = driver.findElement(By.xpath("(//span[contains(text(),'Some of the products cannot be ordered in requeste')])[1]"));
            if (errorElement.isDisplayed()) {
                System.out.println("Error message displayed: " + errorElement.getText());
                captureScreenshot(driver, "error_screenshot");
            } else {
                verificationError.append("Error message is not displayed. ");
            }
            Thread.sleep(1000);

            // Step6. Then click on �EMPTY CART� link in the footer of list of all mobiles. A message "SHOPPING CART IS EMPTY" is shown.
            driver.findElement(By.xpath("(//span[contains(text(),'Empty Cart')])[1]")).click();
            Thread.sleep(1000);

            // Step7. Verify cart is empty
            WebElement emptyCartMessage = driver.findElement(By.xpath("(//h1[normalize-space()='Shopping Cart is Empty'])[1]"));
            if (emptyCartMessage.isDisplayed()) {
                System.out.println("Shopping cart is empty message displayed.");
                captureScreenshot(driver, "empty_cart_screenshot");
            } else {
                verificationError.append("Shopping cart is not empty. ");
            }
            Thread.sleep(1000);

            // Check for any verification errors
            if (verificationError.length() > 0) {
                throw new AssertionError("Test case failed: " + verificationError.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // End
            driver.quit();
        }
    }

    private void captureScreenshot(WebDriver driver, String screenshotName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotFileName = screenshotName + "_" + timeStamp + ".png";
        File destination = new File(System.getProperty("user.dir") + "/screenshots/" + screenshotFileName);
        try {
            FileUtils.copyFile(source, destination);
            System.out.println("Screenshot saved: " + screenshotFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}