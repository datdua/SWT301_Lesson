package Lesson;

import POM.ShoppingCartPage;
import driver.driverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.openqa.selenium.OutputType.FILE;
public class TC04 {
    @Test
    public void testcase04() {
        int scc = 0;
        String testCaseName = "Test04";

        // Init web driver session
        WebDriver driver = driverFactory.getChromeDriver();

        try {
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
            // Bước 1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org");
            Thread.sleep(1000);

            // Bước 2. Click on MOBILE menu
            shoppingCartPage.MobileClick();

            // Timing
            Thread.sleep(1000);

            // Bước 3. In mobile products list, click on "Add To Compare" for Sony Xperia & iPhone
            shoppingCartPage.sonyXperiaCompareClick();
            shoppingCartPage.iPhoneCompareClick();
            Thread.sleep(1000);

            // Bước 4. Click on "COMPARE" button. A popup window opens
            shoppingCartPage.compareButtonClick();

            // Chuyển tới cửa sổ popup
            String parentWindowHandle = driver.getWindowHandle();
            for (String windowHandle : driver.getWindowHandles()) {
                if (!windowHandle.equals(parentWindowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }
            Thread.sleep(1000);

            // Bước 5. Verify the pop-up window and check that the products are reflected in it

            if (shoppingCartPage.verifyPopupHeading()) {
                System.out.println("Popup window opened with heading: " + shoppingCartPage.verifyPopupHeadingText());
            } else {
                System.out.println("Popup window not displayed.");

            }
            Thread.sleep(2000);


            if (shoppingCartPage.verifySonyXperiaInPopup() && shoppingCartPage.verifyIPhoneInPopup()) {
                System.out.println("Products are reflected in the popup window:" + shoppingCartPage.verifySonyXperiaInPopupText() + " - " + shoppingCartPage.verifyIPhoneInPopupText());
            } else {
                System.out.println("Products are not reflected in the popup window.");

            }
            Thread.sleep(2000);
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(FILE);
            String png = ("C:\\Users\\Admin\\IdeaProjects\\SWT301_Lesson\\screenshots" + "TC04" + "-Popup-Screen.png");
            FileUtils.copyFile(scrFile, new File(png));

            Thread.sleep(1000);

            // Bước 6. Close the Popup Window
            driver.close();

            // Chuyển lại cửa sổ gốc
            driver.switchTo().window(parentWindowHandle);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // End
            driver.quit();
        }
    }


}