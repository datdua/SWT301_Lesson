package Lesson;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import java.io.File;

import static org.testng.AssertJUnit.assertEquals;

@Test
public class TC02 {
    public static void testcase02() {
        String tcName ="TC02";
        int scc = 0;

        StringBuffer verificationError = new StringBuffer();
        //init web driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Step1: Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            //Step2: Click on  MOBILE  menu
            driver.findElement(By.linkText("MOBILE")).click();

            //time
            Thread.sleep(1000);

            //Step3: In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)
            String XPeriaPrice = driver.findElement(By.cssSelector("#product-price-1 > span.price")).getText();
            System.out.println(XPeriaPrice);

            //time
            Thread.sleep(1000);

            //Step4: Click on Sony Xperia mobile
            driver.findElement(By.id("product-collection-image-1")).click();

            //time
            Thread.sleep(1000);

            //Step5: Read the Sony Xperia mobile from detail page.
            String detailPrice = driver.findElement(By.cssSelector("span.price")).getText();

            //Step6: Compare Product value in list and details page should be equal ($100).
            assertEquals(XPeriaPrice, detailPrice);
            if (XPeriaPrice.equals(detailPrice))
                System.out.printf("XPeriaPrice = detailPrice and price is: %s", detailPrice);

            //time
            Thread.sleep(2000);

            //Screenshot
            String png = (tcName + ".png");
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(png));

        }catch (Exception e){
            e.printStackTrace();
        }

        // Close
        driver.quit();

    }
}
