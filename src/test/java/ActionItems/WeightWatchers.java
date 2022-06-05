package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class WeightWatchers {
    public static void main(String[] args) throws InterruptedException {

        //setup your chomedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-maximized");
        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);
        //declare javascriptexecutor variable
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //Declare arraylist for zipCodes and add them.
        ArrayList<String> zipCodes = new ArrayList<>();
        zipCodes.add("11211");
        zipCodes.add("90010");
        zipCodes.add("12307");

        //capture and print for the zipCodes using for loop
        for(int i = 0; i < zipCodes.size(); i++) {

            //navigate to weightwatchers site
            driver.navigate().to("https://www.weightwatchers.com");
            Thread.sleep(3000);

            //handle exception for 'Attend' dropdown
            try {
                WebElement attend = driver.findElement(By.xpath("//*[@class = 'MenuItem_menu-item__angle-wrapper__upMgD']"));
                attend.click();
            } catch (Exception e) {
                System.out.println("Unable to locate 'attend' " + e);
            }

            Thread.sleep(1000);

            //handle exception for 'Unlimited Workshops' button
            try {
                WebElement workshops = driver.findElements(By.xpath("//*[@class = 'MenuItem_subtitle__1y5kh']")).get(0);
                workshops.click();
            } catch (Exception e) {
                System.out.println("Unable to locate 'Unlimited Workshops' button" + e);
            }

            Thread.sleep(3000);

            //handle exception for 'Studio' button
            try {
                WebElement studio = driver.findElements(By.xpath("//*[@class = 'buttonText-3DCCO']")).get(1);
                studio.click();
            } catch (Exception e) {
                System.out.println("Unable to locate 'Studio' button " + e);
            }

            Thread.sleep(1000);

            //handle exception for entering zipcode
            try {
                WebElement zipcode = driver.findElement(By.xpath("//*[@id = 'location-search']"));
                zipcode.clear();
                zipcode.sendKeys(zipCodes.get(i));
            } catch (Exception e) {
                System.out.println("Unable to locate 'Enter Location' search bar " + e);
            }

            //handle exception for 'arrow' button
            try {
                WebElement arrow = driver.findElement(By.xpath("//*[@class = 'rightArrow-daPRP']"));
                arrow.click();
            } catch (Exception e) {
                System.out.println("Unable to locate 'arrow' button" + e);
            }

            Thread.sleep(3000);

            //handle exception for studio link
            try {
                ArrayList<WebElement> studioLinks = new ArrayList<>(driver.findElements(By.xpath("//*[@class = 'linkContainer-1NkqM']")));
                if (i == 0){
                    studioLinks.get(1).click();
                }
                else if (i == 1){
                    studioLinks.get(2).click();
                }
                else if (i == 2){
                    studioLinks.get(0).click();
                }
            } catch (Exception e) {
                System.out.println("Unable to locate studio link" + e);
            }

            Thread.sleep(3000);

            //handle exception for locating address
            try {
                String address = driver.findElement(By.xpath("//*[@class = 'infoContainer-12kv1']")).getText();
                System.out.println("The address for a Weight Watchers studio for zipcode " + zipCodes.get(1) + " is: ");
                String [] s = address.split("\n");
                System.out.println(s[0] + "\n" + s[1] + "\n" + s[2] + "\n");
            } catch (Exception e) {
                System.out.println("Unable to locate address text " + e);
            }

            //handle exception for scroll to bottom
            try {
                //declare a webelement variable that we want to scroll into
                WebElement workshopSchedule = driver.findElement(By.xpath("//*[@class = 'updates-3MOAQ']"));

                //scroll into share this calculation button
                jse.executeScript("arguments[0].scrollIntoView(true);", workshopSchedule);
            } catch (Exception e) {
                System.out.println("Unable to scroll to Studio Workshop Schedule  " + e);
            }

            //handle exception for studio schedule
            try {
                String studioSchedule = driver.findElements(By.xpath("//*[@class = 'scheduleContainerMobile-1RfmF']")).get(1).getText();
                System.out.println("The schedule for this virtual studio is\n" + studioSchedule);
                System.out.println();
            } catch (Exception e) {
                System.out.println("Unable to find 'Studio Schedule' text " + e);
            }

            Thread.sleep(3000);
        }

        //quit the chrome driver
        driver.quit();

    }//end of main method
}//end of public class
