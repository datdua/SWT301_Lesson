package Lesson;

import POM.LoginPage;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import POM.CheckOutPage;
@Test
public class TC06 {
            public static void testcase06() {
                String emailAddress = "nhom6@gmail.com";
                String password= "123456";
                String firstName ="Group";
                String lastName ="Six";
                String address1 ="NVH";
                String city ="HCM";
                String state ="Florida";
                String zip ="5000";
                String country ="United States";
                String telephone ="1234567890";


                //init web driver session
                WebDriver driver = driverFactory.getChromeDriver();
                try {

                    //Go to http://live.techpanda.org/
                    driver.get("http://live.techpanda.org/");

                    //debug purpose only
                    Thread.sleep(2000);

                    //Click on my account link
                    LoginPage loginPage = new LoginPage(driver);
                    loginPage.clickMyAccountLink();

                    // switching to new window
                    for (String handle : driver.getWindowHandles()) {
                        driver.switchTo().window(handle);
                    }

                    //debug purpose only
                    Thread.sleep(2000);

                    //Login in application using previously created credential
                    loginPage.enterEmail(emailAddress);

                    //debug purpose only
                    Thread.sleep(1000);

                    loginPage.enterPassword(password);

                    //debug purpose only
                    Thread.sleep(1000);

                    //Click Login
                    loginPage.clickLogin();

                    // switching to new window
                    for (String handle : driver.getWindowHandles()) {
                        driver.switchTo().window(handle);
                    }

                    //debug purpose only
                    Thread.sleep(2000);

                    //Step11. Click "Proceed to Checkout"
                    driver.findElement(By.xpath("//li[@class='method-checkout-cart-methods-onepage-bottom']//button[@title='Proceed to Checkout']"));
                    Thread.sleep(2000);

                    //Step12. Click "Proceed to Checkout"
                    //Step13. Click "Proceed to Checkout"

                } catch (Exception e){
                    e.printStackTrace();
                }

                //Quit browser session
                driver.quit();

            }

}

