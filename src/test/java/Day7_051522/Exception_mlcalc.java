package Day7_051522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Exception_mlcalc {
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
        driver.navigate().to("https://www.mlcalc.com");
        Thread.sleep(3000);

        //handle exception for purchase price
        try{
            WebElement pPrice = driver.findElement(By.xpath("//*[@id = 'ma']"));
            pPrice.clear();
            pPrice.sendKeys("450000");
        } catch (Exception e){
            //print out the exception
            System.out.println("Unable to locate purchase price " + e);
        }

        //handle exception for show advance options button
        try{
            driver.findElement(By.xpath("//*[text() = 'Show advanced options']")).click();
        } catch (Exception e){
            //print out the exception
            System.out.println("Unable to locate 'Show Advance Options' button " + e);
        }

        //handle exception for start month drop down
        try{
            WebElement startMonth = driver.findElement(By.xpath("//*[@name = 'sm']"));
            Select dropDown = new Select(startMonth);
            dropDown.selectByVisibleText("Jun");
        } catch (Exception e){
            //print out the exception
            System.out.println("Unable to locate Start month dropdown " + e);
        }

        //handle exception for calculate button
        try{
            driver.findElement(By.xpath("//*[@value = 'Calculate']")).click();
        } catch (Exception e){
            //print out the exception
            System.out.println("Unable to locate calculate button " + e);
        }

        Thread.sleep(3000);

        //handle exception for monthly payment
        try{
            String monthlyPayment = driver.findElements(By.xpath("//div[@style='font-size: 32px']")).get(0).getText();
            System.out.println("Monthly payment is " + monthlyPayment);
        } catch (Exception e){
            //print out the exception
            System.out.println("Unable to locate monthly payment text " + e);
        }

    }
}
