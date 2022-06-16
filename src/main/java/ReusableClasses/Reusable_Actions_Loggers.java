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

public class Reusable_Actions_Loggers {

    //set a static timeout variable so it can cover all explicit for all methods
    public static int timeout = 60;

    //resuable function for webdriver as a return method
    public static WebDriver setDriver() {
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-maximized");
        //for mac use full screen
        //options.addArguments("start-fullscreen");
        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }//end of setDriver method

    //resuable function for webdriver as a return method
    public static WebDriver setDriver2() {
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to run driver in background
        options.addArguments("headless");
        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }//end of setDriver method

    //create a mouse hover method
    public static void mouseHover(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover on element " + elementName + " " + e);
        }
    }//end of mouseHover

    //create a click method
    public static void clickAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
            logger.log(LogStatus.PASS, "Successfully click on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to click on element " + elementName + " " + e);
        }
    }//end of clickAction

    //create a submit method
    public static void submitAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.submit();
            logger.log(LogStatus.PASS, "Successfully submit on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to submit on element " + elementName + " " + e);
        }
    }//end of submit


    //create a sendkeys method
    public static void sendKeysAction(WebDriver driver, String xpath, String userValue, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.sendKeys(userValue);
            logger.log(LogStatus.PASS, "Successfully enter user value on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to click on element " + elementName + " " + e);
        }
    }//end of sendkeys method

    //create a getText method
    public static String getTextAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        String result = "";
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            result = element.getText();
            logger.log(LogStatus.PASS, "Successfully capture text on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to capture text on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to capture text on element " + elementName + " " + e);
        }
        return result;
    }//end of getTextAction method

    public static Boolean checkCheckBox(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        Boolean result = null;
        try {
            result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).isSelected();
            logger.log(LogStatus.PASS, "Is element " + elementName + "located? " +result);
        } catch (Exception e) {
            System.out.println("Unable to identify if element " + elementName + " is checked " + e);
            logger.log(LogStatus.FAIL, "Unable to identify if element " + elementName + " is checked" + e);
        }
        return result;
    }

    //create a click by index method
    public static void clickByIndexAction(WebDriver driver, String xpath, int indexNumber, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            element.click();
            logger.log(LogStatus.PASS, "Successfully click on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to click on element " + elementName + " " + e);
        }
    }//end of clickByIndexAction

    public static void clickByCoordinates(WebDriver driver, int x, int y, ExtentTest logger, String elementName) {
        Actions actions = new Actions(driver);
        try {
            //actions.moveToElement(driver.findElement(By.tagName("body")), 0,0);
            actions.moveByOffset(x, y).click().build().perform();
            logger.log(LogStatus.PASS, "Successfully able to click by coordinates " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click by coordinates for " + elementName + " " +e);
            logger.log(LogStatus.PASS, "Unable to click by coordinates " + elementName  + " " +e);
        }
    }

    //create a method to select by text
    public static void selectByText(WebDriver driver, String xpath, String xPath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            //select month from the dropdown
            WebElement dropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            //clicking on dropdown and its value if the dropdown tag is not under select tag
            dropDown.click();
            //click on the value of the start month
            driver.findElement(By.xpath(xPath)).click();
            logger.log(LogStatus.PASS, "Successfully able to select element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to unable to select by text using element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to select element " + elementName);
        }
    }

    //create a switch tabs by index method
    public static void switchToTabByIndex(WebDriver driver, int tabNum, ExtentTest logger, String elementName) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNum));
        logger.log(LogStatus.PASS, "Successfully able to switch tab " + elementName);
    }

    //create a scroll into view method
    public static void scrollIntoView(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        //handle exception for scroll to bottom
        try {
            //declare a web element variable that we want to scroll into
            WebElement scrollInto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

            //scroll into this element
            jse.executeScript("arguments[0].scrollIntoView(true);", scrollInto);

            logger.log(LogStatus.PASS, "Successfully able to scroll into element " + elementName);

        } catch (Exception e) {
            System.out.println("Unable to scroll to element " + elementName + " " + e);
            logger.log(LogStatus.PASS, "Unable to scroll into element " + elementName + " " + e);
        }

    }

    //create a scroll by pixels method
    public static void scrollByPixels(WebDriver driver, String x, String y, ExtentTest logger, String elementName) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //handle exception for scroll to bottom
        try {
            //scroll into this element
            jse.executeScript("scroll(" +x+ "," +y+")");
            logger.log(LogStatus.PASS, "Successfully able to scroll to pixels " + elementName);

        } catch (Exception e) {
            System.out.println("Unable to scroll to pixels " + elementName + " " + e);
            logger.log(LogStatus.PASS, "Unable to scroll into pixels " + elementName + " " + e);
        }

    }

    //create a capture screen shot method
    public static void captureScreenshot(WebDriver driver, String screenshotName, ExtentTest logger, String elementName) {

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot,
                    new File(System.getProperty("user.dir") + "/Screenshots/" + screenshotName + ".png"));
            System.out.println("Screenshot captured for " +elementName);
            logger.log(LogStatus.PASS, "Successfully able to capture screenshot for " + elementName);
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot for " +elementName+ " " +e);
            logger.log(LogStatus.PASS, "Unable to capture screenshot for " + elementName + " " + e);
        }
    }

    //create a go back to previous page method
    public static void goBackOne(WebDriver driver, ExtentTest logger, String elementName) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            js.executeScript("window.history.go(-1)");
            logger.log(LogStatus.PASS, "Successfully able to go back a page " + elementName);
        } catch (Exception e) {
            System.out.println("Exception while back to previous page " +elementName+ " " +e);
            logger.log(LogStatus.PASS, "Unable to go back to previous page " + elementName + " " + e);
        }
    }

    //create a verify title method
    public static void verifyTitle(WebDriver driver, String userValue, ExtentTest logger, String elementName) {
        //capture the title of the age and compare it with your expected title
        String actualTitle = null;
        try {
            actualTitle = driver.getTitle();
            if (actualTitle.contains(userValue)) {
                System.out.println("My title contains '" + userValue + "'");
            } else {
                System.out.println("Title doesn't contain '" + userValue + "'. \nActual title is '" + actualTitle + "'.");
            }
            logger.log(LogStatus.PASS, "Title matches user value" + elementName);
        } catch (Exception e) {
            System.out.println("Exception while matching title " +elementName+ " " +e);
            logger.log(LogStatus.PASS, "Unable to match title " + elementName + " " + e);
        }
    }

    //create a get title method
    public static String getTitle(WebDriver driver, ExtentTest logger, String elementName) {
        String title = null;
        try {
            title = driver.getTitle();
            logger.log(LogStatus.PASS, "Successfully get title " + elementName);
        } catch (Exception e) {
            System.out.println("Exception while getting title " +elementName+ " " +e);
            logger.log(LogStatus.PASS, "Unable to get title " + elementName + " " + e);
        }
        return title;
    }

    //translate
    public static String translate(WebDriver driver, String userInput, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        String result = null;
        try {
            driver.navigate().to("https://translate.google.com/");
            Reusable_Actions.sendKeysAction(driver, "//*[@aria-label= 'Source text']", userInput, elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@jsname= 'ksKsZd']"))).get(5);
            element.click();
            result = Reusable_Actions.getTextAction(driver, "//*[@class= 'J0lOec']", elementName);
            logger.log(LogStatus.PASS, "Successfully able to translate " + elementName);
        } catch (Exception e) {
            System.out.println("Exception while translating " +elementName+ " " +e);
            logger.log(LogStatus.PASS, "Unable to translate " + elementName + " " + e);
        }
        driver.quit();
        return result;
    }

    public static void verifyStatusOfElement(WebDriver driver, String xpath, Boolean expectedStatus, ExtentTest logger, String ElementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            Boolean actualStatus = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='checkbox']"))).isSelected();
            if(expectedStatus == actualStatus){
                logger.log(LogStatus.PASS,"Element is selected as expected");
            } else {
                logger.log(LogStatus.FAIL,"Element is not selected");
            }
        } catch (Exception e) {

        }

    }//end of method

}




























