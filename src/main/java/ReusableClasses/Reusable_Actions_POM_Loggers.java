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

public class Reusable_Actions_POM_Loggers {

    //set a static timeout variable so it can cover all explicit for all methods
    public static int timeout = 30;

    //resuable function for webdriver as a return method
    public static WebDriver setDriver(){
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
    public static void mouseHover(WebDriver driver,WebElement xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        Actions actions = new Actions(driver);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOf(xpath));
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to hover on element " + elementName + " " + e);
            getScreenShot(driver, elementName, logger);
        }
    }//end of mouseHover

    //create a click method
    public static void clickAction(WebDriver driver,WebElement xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOf(xpath));
            element.click();
            logger.log(LogStatus.PASS,"Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click on element " + elementName + " " + e);
            getScreenShot(driver, elementName, logger);
        }
    }//end of clickAction

    //create a submit method
    public static void submitAction(WebDriver driver, WebElement xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOf(xpath));
            element.submit();
            logger.log(LogStatus.PASS,"Successfully submit on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to submit on element " + elementName + " " + e);
            getScreenShot(driver, elementName, logger);
        }
    }//end of submit


    //create a sendkeys method
    public static void sendKeysAction(WebDriver driver,WebElement xpath, String userValue, ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOf(xpath));
            element.sendKeys(userValue);
            logger.log(LogStatus.PASS,"Successfully enter user value on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click on element " + elementName + " " + e);
            getScreenShot(driver, elementName, logger);
        }
    }//end of sendkeys method

    //create a getText method
    public static String getTextAction(WebDriver driver,WebElement xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        String result = "";
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOf(xpath));
            result = element.getText();
            logger.log(LogStatus.PASS,"Successfully capture text on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to capture text on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to capture text on element " + elementName + " " + e);
            getScreenShot(driver, elementName, logger);
        }
        return result;
    }//end of getTextAction method

    //create a click by index method
    public static void clickByIndexAction(WebDriver driver, WebElement xpath, int indexNumber, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElements(xpath)).get(indexNumber);
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click on element " + elementName + " " + e);
            getScreenShot(driver, elementName, logger);
        }
    }//end of clickByIndexAction

    //create a method to select by text
    public static void selectByText(WebDriver driver, WebElement xpath, String xPath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            //select month from the dropdown
            WebElement dropDown = wait.until(ExpectedConditions.visibilityOf(xpath));
            //clicking on dropdown and its value if the dropdown tag is not under select tag
            dropDown.click();
            //click on the value of the start month
            driver.findElement(By.xpath(xPath)).click();
            logger.log(LogStatus.PASS, "Successfully able to select element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to unable to select by text using element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to select element " + elementName);
            getScreenShot(driver, elementName, logger);
        }

    }

    //create a scroll into view method
    public static void scrollIntoView(WebDriver driver, WebElement xpath, ExtentTest logger, String elementName) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        //handle exception for scroll to bottom
        try {
            //declare a web element variable that we want to scroll into
            WebElement scrollInto = wait.until(ExpectedConditions.visibilityOf(xpath));

            //scroll into this element
            jse.executeScript("arguments[0].scrollIntoView(true);", scrollInto);

            logger.log(LogStatus.PASS, "Successfully able to scroll into element " + elementName);

        } catch (Exception e) {
            System.out.println("Unable to scroll to element " + elementName + " " + e);
            logger.log(LogStatus.PASS, "Unable to scroll into element " + elementName + " " + e);
            getScreenShot(driver, elementName, logger);

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
            getScreenShot(driver, elementName, logger);
        }
    }

    public static Boolean checkCheckBox(WebDriver driver, WebElement xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        Boolean result = null;
        try {
            result = wait.until(ExpectedConditions.visibilityOf(xpath)).isSelected();
            logger.log(LogStatus.PASS, "Is element " + elementName + "located? " +result);
        } catch (Exception e) {
            System.out.println("Unable to identify if element " + elementName + " is checked " + e);
            logger.log(LogStatus.FAIL, "Unable to identify if element " + elementName + " is checked" + e);
        }
        return result;
    }

    //method to capture screenshot when logger fails
    public static void getScreenShot(WebDriver driver,String imageName,ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }//end of getScreenshot method

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

}//end of class
