package ReusableClasses;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;

public class Reusable_Actions {

    //resuable function for webdriver as  return method
    public static WebDriver setDriver() {
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-maximized");
        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }//end of setDriver method

    //create a mouse hover method
    public static void mouseHover(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover on element " + elementName + " " + e);
        }
    }//end of mouseHover

    //create a click method
    public static void clickAction(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }
    }//end of clickAction

    //create a sendkeys method
    public static void sendKeysAction(WebDriver driver, String xpath, String userValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.clear();
            element.sendKeys(userValue);
        } catch (Exception e) {
            System.out.println("Unable to send element " + elementName + " " + e);
        }
    }//end of sendkeys method


    //create a verify title method
    public static void verifyTitle(WebDriver driver, String userValue, String elementName) {
        //capture the title of the age and compare it with your expected title
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(userValue)) {
            System.out.println("My title contains '" + userValue + "'");
        } else {
            System.out.println("Title doesn't contain '" + userValue + "'. Actual title is " + actualTitle);
        }
    }

    //create a click by index method
    public static void clickByIndexAction(WebDriver driver, String xpath, int indexNumber, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }
    }//end of clickByIndexAction

    //create a switch tabs by index method
    public static void switchToTabByIndex(WebDriver driver, int tabNum) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNum));
    }

    //create a method to select by text
    public static void selectByText(WebDriver driver, String xpath, String xPath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            //select month from the dropdown
            WebElement dropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            //clicking on dropdown and its value if the dropdown tag is not under select tag
            dropDown.click();
            //click on the value of the start month
            driver.findElement(By.xpath(xPath)).click();
        } catch (Exception e) {
            System.out.println("Unable to unable to select by text using element " + elementName + " " + e);
        }

    }

    //create a submit method
    public static void submitAction(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.submit();
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + " " + e);
        }
    }//end of submit

    public static String captureText(WebDriver driver, String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).getText();

        return text;
    }

    //create a getText method
    public static String getTextAction(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = null;
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            result = element.getText();
        } catch (Exception e) {
            System.out.println("Unable to capture text on element " + elementName + " " + e);
        }//end of exception
        return result;
    }//end of getTextAction method

    //create a capture screen shot method
    public static void captureScreenshot(WebDriver driver, String screenshotName, String elementName) {

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot,
                    new File(System.getProperty("user.dir") + "/Screenshots/" + screenshotName + ".png"));
            System.out.println("Screenshot captured for " +elementName);
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot for " +elementName+ " " +e);
        }
    }


}




























