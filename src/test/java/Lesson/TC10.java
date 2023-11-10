package Lesson;

import POM.AdminPanelPage;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;

import static org.openqa.selenium.OutputType.FILE;
@Test
public class TC10 {
    public void testcase10() {
        String id = "user01";
        String pass = "guru99com";
        String orderID = "100021176";
        String fromDate = "11/6/2023";
        String toDate = "11/8/2023";

        //init web driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {

            //Step1. Go to http://live.techpanda.org/index.php/backendlogin
            driver.get("http://live.techpanda.org/index.php/backendlogin");

            //debug purpose only
            Thread.sleep(2000);

            //Step2. Login the credentials provided
            AdminPanelPage AdminPanelPage = new AdminPanelPage(driver);
            AdminPanelPage.enterUserName(id);

            //debug purpose only
            Thread.sleep(1000);

            AdminPanelPage.enterPassword(pass);

            //debug purpose only
            Thread.sleep(1000);

            AdminPanelPage.clickLogin();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            AdminPanelPage.clickCloseMessage();

            //debug purpose only
            Thread.sleep(2000);

            //Step3. Go to Sales-> Orders menu
            AdminPanelPage.clickSalesMenu();
            AdminPanelPage.clickOrderMenu();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //debug purpose only
            Thread.sleep(2000);

            //Step4. Input OrderId and FromDate -> ToDate
            AdminPanelPage.enterOrderID(orderID);

            //debug purpose only
            Thread.sleep(1000);

            AdminPanelPage.enterFromDate(fromDate);

            //debug purpose only
            Thread.sleep(1000);

            AdminPanelPage.enterToDate(toDate);

            //debug purpose only
            Thread.sleep(1000);

            //Step5. Click Search button
            AdminPanelPage.clickSearchButton();

            //debug purpose only
            Thread.sleep(2000);

            //6. Screenshot capture.
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(FILE);
            String png = ("C:\\Users\\Admin\\IdeaProjects\\SWT301_Lesson\\screenshots" + "TC10" + ".png");
            FileUtils.copyFile(scrFile, new File(png));

            //debug purpose only
            Thread.sleep(1000);

        } catch (Exception e){
            e.printStackTrace();
        }

        //Quit browser session
        driver.quit();

    }
}
