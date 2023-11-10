package Lesson;

import POM.CartPage;
import POM.CheckOutPage;
import POM.ShoppingCartPage;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;

import static org.openqa.selenium.OutputType.FILE;
@Test
public class TC09 {
    public void testcase09(){

    int scc = 0;
    String code = "GURU50";

    //Init web driver session
    WebDriver driver = driverFactory.getChromeDriver();
        try {
        CheckOutPage checkoutPage = new CheckOutPage(driver);
        CartPage cartPage = new CartPage(driver);

        //Step 1. Go to http://live.techpanda.org/
        driver.get("http://live.techpanda.org");

        Thread.sleep(1000);

        //Step 2. Go to Mobile and add IPHONE to cart
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.MobileClick();

        Thread.sleep(1000);

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        shoppingCartPage.IphoneAddToCartButton();
        String firstTotal = driver.findElement(By.xpath("//strong//span[@class='price'][normalize-space()='$500.00']")).getText();

        Thread.sleep(1000);

        //Step 3. Enter Coupon Code
        shoppingCartPage.enterDiscountCode(code);

        Thread.sleep(1000);

        shoppingCartPage.ApplyClick();

        Thread.sleep(1000);

        //Step 4. Verify the discount generated
        shoppingCartPage.verifyGrandTotal();
        Thread.sleep(1000);
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(FILE);
        String png = ("C:\\Users\\Admin\\IdeaProjects\\SWT301_Lesson\\screenshots" + "Price is not discounted by 5%" + ".png");
        FileUtils.copyFile(scrFile, new File(png));
        Thread.sleep(1000);

    } catch (Exception e) {
        e.printStackTrace();
    }

    //Quit browser session
        driver.quit();
}
}
