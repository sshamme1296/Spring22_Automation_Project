package ActionItems;

import ReusableClasses.Reusable_Actions;
import org.openqa.selenium.WebDriver;

public class test {
    public static void main(String[] args) throws InterruptedException {

        //setting the local driver to reusable setDriver method
        WebDriver driver = Reusable_Actions.setDriver();

            driver.navigate().to("https://www.twitter.com");
            Thread.sleep(3000);
            Reusable_Actions.captureScreenshot(driver, "twitter","Twitter");
            driver.quit();

    }
}
