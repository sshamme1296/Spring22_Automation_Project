package Day7_051522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class FedilisCare_Tabs {
    public static void main(String[] args) throws InterruptedException {

        //setup your chomedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-maximized");
        //setting your driver as headless(running on background)
        //options.addArguments("headless");
        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);

        //navigate to mortgagacalculator site
        driver.navigate().to("https://www.fideliscare.org");
        //wait for web page to load, 3 seconds
        Thread.sleep(3000);

        //click on shop for a plan
        //we are clicking on index 0 because there are two elements for this xpath
        driver.findElements(By.xpath("//*[text() = 'Shop For a Plan']")).get(0).click();
        //wait for web page to load, 1 second
        Thread.sleep(1000);

        //click on Medicaid Managed Care
        driver.findElements(By.xpath("//*[text() = 'Medicaid Managed Care']")).get(0).click();
        //wait for web page to load, 1 seconds
        Thread.sleep(1000);

        //click on search under find a doctor card
        driver.findElement(By.xpath("//*[@href = '/findadoctor']")).click();
        //wait for new tab to open, 1 seconds
        Thread.sleep(1000);

        //store new tabs in an array list
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        //switch to a new tab, and it should be at index 1
        driver.switchTo().window(tabs.get(1));

        //click on new search button
        driver.findElement(By.xpath("//*[@class = 'fal fa-search-plus']")).click();
        //wait for the click, 1 seconds
        Thread.sleep(1000);

        //close new tab
        driver.close();

        //switch back to the default tab
        driver.switchTo().window(tabs.get(0));

        //then click on providers card
        driver.findElement(By.xpath("//*[@class = 'fal fa-stethoscope fa-fw']")).click();
        //wait for the provider click, 1 seconds
        Thread.sleep(1000);


    }
}
