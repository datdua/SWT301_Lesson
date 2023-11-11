package Lesson;

import POM.MobilePage;
import POM.RegisterPage;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;

public class TC05 {
        @Test
        public static void testcase05() {
            // Init web driver session
            String firstName="Nguyen";
            String middleName="Tan Dat";
            String lastName="Dat";
            String emailAddress = "toimqn27@gmail.com";
            String password= "123456";
            String confirmPassword= password;
            String emailShared= "toimqn08@gmail.com";
            String message = "Checking";

            WebDriver driver = driverFactory.getChromeDriver();
            try {
                // Step1. Go to http://live.techpanda.org/
                driver.get("http://live.techpanda.org");
                Thread.sleep(2000);

                // Step2. Click on my account link
                RegisterPage registerPage = new RegisterPage(driver);
                registerPage.clickMyAccountLink();
                Thread.sleep(2000);
                for (String handle : driver.getWindowHandles()) {
                    driver.switchTo().window(handle);
                }
                Thread.sleep(2000);

                // Step3. Click Create an Account link and fill New User information excluding the registered Email ID
                registerPage.clickCreateAccountLink();
                for (String handle : driver.getWindowHandles()) {
                    driver.switchTo().window(handle);
                }
                Thread.sleep(2000);
                registerPage.enterFirstName(firstName);
                registerPage.enterMiddleName(middleName);
                registerPage.enterLastName(lastName);
                registerPage.enterEmail(emailAddress);
                registerPage.enterPassword(password);
                registerPage.enterConfirmPassword(confirmPassword);


                Thread.sleep(2000);


                // Step4: click Register
                registerPage.clickRegister();
                Thread.sleep(2000);
                for (String handle : driver.getWindowHandles()) {
                    driver.switchTo().window(handle);
                }
                Thread.sleep(2000);

                // Step5. Verify Registration is done. Expected account registration done.
                String successMessage = driver.findElement(By.cssSelector("li.success-msg span")).getText();
                String successWelcome = driver.findElement(By.cssSelector("p[class='welcome-msg']")).getText();
                if (successMessage.contains("Thank you for registering with Main Website Store.") && successWelcome.contains("WELCOME, " + firstName.toUpperCase() +" "+ middleName.toUpperCase() +" " + lastName.toUpperCase() + "!")) {
                    System.out.println("Account registration done.");
                    captureScreenshot(driver, "Account_Register_Success");
                } else {
                    System.out.println("Account registration failed.");
                }
                Thread.sleep(2000);

                // Step6. Go to TV menu
                driver.findElement(By.linkText("TV")).click();
                Thread.sleep(2000);
                for (String handle : driver.getWindowHandles()) {
                    driver.switchTo().window(handle);
                }
                Thread.sleep(2000);

                // Step7. Add product in your wish list - use product - LG LCD
                driver.findElement(By.xpath("(//a[@class='link-wishlist'][normalize-space()='Add to Wishlist'])[1]")).click();
                Thread.sleep(2000);
                for (String handle : driver.getWindowHandles()) {
                    driver.switchTo().window(handle);
                }
                Thread.sleep(2000);

                // Step8. Click SHARE WISHLIST
                driver.findElement(By.xpath("(//span[contains(text(),'Share Wishlist')])[1]")).click();
                Thread.sleep(2000);
                for (String handle : driver.getWindowHandles()) {
                    driver.switchTo().window(handle);
                }
                Thread.sleep(2000);

                // Step9. In the next page, enter Email and a message, and click SHARE WISHLIST

                MobilePage mobilePage = new MobilePage(driver);
                mobilePage.enterEmailShared(emailShared);
                mobilePage.enterMessageShared(message);
                driver.findElement(By.cssSelector("button[title='Share Wishlist']")).click();
                Thread.sleep(2000);


                // Step10. Check wishlist is shared. Expected wishlist shared successfully.
                String successMessage2 = driver.findElement(By.xpath("(//span[normalize-space()='Your Wishlist has been shared.'])[1]")).getText();
                if (successMessage2.contains("Your Wishlist has been shared.")) {
                    System.out.println("Wishlist shared successfully.");
                    captureScreenshot(driver, "Wishlist_Sharing_Success");
                } else {
                    System.out.println("Wishlist sharing failed.");

                }
                Thread.sleep(2000);

            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                // End
                driver.quit();
            }
        }

        private static void captureScreenshot(WebDriver driver, String screenshotName) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String screenshotFileName = screenshotName + "_"  + ".png";
            File destination = new File(System.getProperty("user.dir") + "/screenshots/" + screenshotFileName);
            try {
                FileUtils.copyFile(source, destination);
                System.out.println("Screenshot saved: " + screenshotFileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
