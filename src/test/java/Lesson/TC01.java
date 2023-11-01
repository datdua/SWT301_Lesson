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

@Test
public class TC01 {
    public static void testcase01() {
        String tcName ="TC01";
        int scc = 0;

        StringBuffer verificationError = new StringBuffer();

        //init web driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Step 1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            //Step 2. Verify Title of the page

            String demoSite = driver.findElement(By.cssSelector("h2")).getText();
            System.out.println(demoSite);

            try {
                AssertJUnit.assertEquals("This is demo site for ", demoSite);
            } catch (Error e) {
                verificationError.append(e.toString());
            }

            //time
            Thread.sleep(2000);

            //Step 3. Click on -> MOBILE -> menu

            driver.findElement(By.linkText("MOBILE")).click();

            //time
            Thread.sleep(2000);

            //Step 4. In the list of all mobile , select SORT BY -> dropdown as name

            new Select(driver.findElement(By.cssSelector("select[title=\"Sort By\"]"))).selectByVisibleText("Name");

            //time
            Thread.sleep(2000);

            //Step 5. Verify all products are sorted by name

            scc = (scc + 1);


            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            String png = (tcName + ".png");

            FileUtils.copyFile(scrFile, new File(png));
        } catch (Exception e){
            e.printStackTrace();
        }

        // End
        driver.quit();

    }
}