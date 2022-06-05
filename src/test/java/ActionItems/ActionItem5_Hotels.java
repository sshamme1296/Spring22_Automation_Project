package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class ActionItem5_Hotels {
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

        //Declare arraylist for locations and add them.
        ArrayList<String> locations = new ArrayList<>();
        locations.add("Boston");
        locations.add("Los Angeles");
        locations.add("Orlando");

        //Declare arraylist for check in times and add them.
        ArrayList<String> checkIn = new ArrayList<>();
        checkIn.add("Jun 6, 2022");
        checkIn.add("Jun 7, 2022");
        checkIn.add("Jul 15, 2022");

        //Declare arraylist for check in times and add them.
        ArrayList<String> checkOut = new ArrayList<>();
        checkOut.add("Jun 8, 2022");
        checkOut.add("Jun 10, 2022");
        checkOut.add("Jul 18, 2022");

        //for ()

        //navigate to weightwatchers site
        driver.navigate().to("https://www.hotels.com");
        Thread.sleep(3000);

        //handle exception for entering destination
        try {
            WebElement destinationSearch = driver.findElement(By.xpath("//*[@class = 'uitk-fake-input uitk-form-field-trigger']"));
            destinationSearch.click();
        } catch (Exception e) {
            System.out.println("Unable to locate 'Enter Location' search bar " + e);
        }

        Thread.sleep(1000);

        //handle exception for entering destination
        try {
            WebElement destination = driver.findElement(By.xpath("//*[@id = 'location-field-destination']"));
            destination.click();
            destination.sendKeys("Los Angeles");
        } catch (Exception e) {
            System.out.println("Unable to locate 'Enter Location' search bar " + e);
        }

        Thread.sleep(1000);

        //handle exception for clicking first dropdown link
        try {
            WebElement firstDestination = driver.findElements(By.xpath("//*[@data-stid = 'location-field-destination-result-item-button']")).get(0);
            firstDestination.click();
        } catch (Exception e) {
            System.out.println("Unable to click first link " + e);
        }

        Thread.sleep(1000);

        //handle exception for check in date
        try {
            WebElement checkInBox = driver.findElement(By.xpath("//*[@data-name = 'd1']"));
            checkInBox.click();

        } catch (Exception e) {
            System.out.println("Unable to click check in box " + e);
        }

        //handle exception for entering check in date
        try {
            WebElement checkInDate = driver.findElement(By.xpath("//*[@aria-label = 'Jun 8, 2022']"));
            checkInDate.click();

        } catch (Exception e) {
            System.out.println("Unable to select check in date " + e);
        }

        //handle exception for entering check out date
        try {
            WebElement checkOutDate = driver.findElement(By.xpath("//*[@aria-label = 'Jun 15, 2022']"));
            checkOutDate.click();

        } catch (Exception e) {
            System.out.println("Unable to select check out date " + e);
        }

        //handle exception for done button
        try {
            WebElement done = driver.findElement(By.xpath("//*[@data-stid = 'apply-date-picker']"));
            done.click();

        } catch (Exception e) {
            System.out.println("Unable to click done " + e);
        }

        Thread.sleep(1000);

        //handle exception for travelers box
        try {
            WebElement travelersBox = driver.findElement(By.xpath("//*[@data-testid = 'travelers-field-trigger']"));
            travelersBox.click();

        } catch (Exception e) {
            System.out.println("Unable to click check in box " + e);
        }

        //handle exception for entering number of adults
        try {
            WebElement adultsPlusButton = driver.findElement(By.xpath("//*[@aria-label = 'Increase adults in room 1']"));
            adultsPlusButton.click();
            adultsPlusButton.click();
        } catch (Exception e) {
            System.out.println("Unable to click plus button " + e);
        }

        //handle exception for done button for travelers
        try {
            WebElement done = driver.findElement(By.xpath("//*[@data-testid = 'guests-done-button']"));
            done.click();

        } catch (Exception e) {
            System.out.println("Unable to click done button for travelers " + e);
        }

        Thread.sleep(1000);

        //handle exception for search button
        try {
            WebElement done = driver.findElement(By.xpath("//*[@data-testid = 'submit-button']"));
            done.click();

        } catch (Exception e) {
            System.out.println("Unable to click search button " + e);
        }

        Thread.sleep(3000);

        //handle exception for hotel links
        try {
            WebElement hotelLinks = driver.findElements(By.xpath("//*[@data-testid = 'uitk-gallery-item-current-trigger']")).get(0);
            hotelLinks.click();

        } catch (Exception e) {
            System.out.println("Unable to click hotel links " + e);
        }

        //store new tabs in an array list
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        //switch to a new tab, and it should be at index 1
        driver.switchTo().window(tabs.get(1));

        //handle exception for printing resort name
        try {
            String resort = driver.findElement(By.xpath("//*[@class = 'uitk-heading-3']")).getText();
            System.out.println("The first recommended resort for Los Angeles is: " +resort);
        } catch (Exception e) {
            System.out.println("Unable to locate resort name " + e);
        }





    }
}
