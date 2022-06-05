package Day9_052222;

import ReusableClasses.Reusable_Actions;
import org.openqa.selenium.WebDriver;

public class USPS_Reusable_Concepts {
    public static void main(String[] args) throws InterruptedException {

        //setting the local driver to reusable setDriver method
        WebDriver driver = Reusable_Actions.setDriver();

        //navigate to usps
        driver.navigate().to("https://www.usps.com");

        //hovering to the quick tools
        Reusable_Actions.mouseHover(driver,"//*[text()= 'Quick Tools']","Quick Tools");

        //Thread.sleep(3000);

        //hover to send tab
        Reusable_Actions.mouseHover(driver, "//*[@id= 'mail-ship-width']", "Send Tab");

        //click on calculate a price
        //Thread.sleep(3000);
        Reusable_Actions.clickAction(driver, "//*[@class= 'tool-calc']", "Calculate a Price");

        //enter the zipcode
        Reusable_Actions.sendKeysAction(driver, "//*[@id= 'Origin']", "11208", "Zip Code");


    }
}
