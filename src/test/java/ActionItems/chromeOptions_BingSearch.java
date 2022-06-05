package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class chromeOptions_BingSearch {
    public static void main(String[] args) throws InterruptedException {

        //setup your chomedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        //options.addArguments("start-maximized");
        //setting your driver as headless(running on background)
        options.addArguments("headless");
        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);

        //Declare arraylist for hobbies and add them.
        ArrayList<String> hobbies = new ArrayList<>();
        hobbies.add("live action role playing");
        hobbies.add("gaming");
        hobbies.add("knitting");
        hobbies.add("gardening");
        hobbies.add("baking");

        //Prints out hobbies that will be searched
        System.out.println("\nHere are the number of search results from Bing.com for the following hobbies:");

        for (int i = 0; i < hobbies.size(); i ++){
            System.out.println("\t-" + hobbies.get(i));
        }

        System.out.println();

        //capture search number and print for the hobbies using for loop
        for(int i = 0; i < hobbies.size(); i++) {

            //go to Bing home page
            driver.navigate().to("https://www.bing.com");

            Thread.sleep(3000);

            //locate element for search field and type keyword 'hobbies'
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(hobbies.get(i));

            //submit on bing search button
            driver.findElement(By.xpath("//*[@name='search']")).submit();

            Thread.sleep(3000);

            //capture the bing search and print it
            String searchResult = driver.findElement(By.xpath("//*[@id='b_tween']")).getText();

            //extract out the number and print the search number only
            //String[] arrayResult = searchResult.split(" ");

            //System.out.println("There are about " + arrayResult[0] + " results when '" +hobbies.get(i)+ "' is searched" );

            System.out.println("There are about " + searchResult.substring(0,10) + " results when '" +hobbies.get(i)+ "' is searched" );
        }

        //quit the driver
        driver.quit();

    }//end of main
}//end of public class
