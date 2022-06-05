package Day8_05212022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class getTitle_Example {
    public static void main(String[] args) {

        //setup your chomedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to ingognito mode
        //options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        //options.addArguments("start-maximized");
        //setting your driver as headless(running on background)
        options.addArguments("headless");
        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);
        //go to Google home page
        driver.navigate().to("https://www.google.com");

        //capture the title of the age and compare it with your expected title 'GOOGLE'
        String actualTitle = driver.getTitle();
        if (actualTitle.equals("GOOGLE")){
            System.out.println("My title matches");
        } else {
            System.out.println("Title doesnt match. Actual title is " +actualTitle);
        }

    }

}
