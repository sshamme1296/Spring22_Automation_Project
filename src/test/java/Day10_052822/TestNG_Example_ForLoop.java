package Day10_052822;

import ReusableClasses.Reusable_Actions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TestNG_Example_ForLoop {

    //declare the local driver outside so that it can be reusable with other annotation methods
    WebDriver driver;

    //before suite will set the driver you are using
    @BeforeSuite
    public  void SetChromeDriver(){
        driver = Reusable_Actions.setDriver();
    }

    //test case 1: navigate to google and enter a keyword on search field
    @Test
    public void SearchForKeyword(){

        ArrayList<String> artists = new ArrayList();
        artists.add("BTS");
        artists.add("Harry Styles");
        artists.add("Mac Miller");

        for(int i = 0; i<artists.size();i++) {

            driver.navigate().to("https://www.google.com");

            //enter a keyword on search field
            Reusable_Actions.sendKeysAction(driver, "//*[@name='q']", artists.get(i), "Search Field");

            //submit the go button
            Reusable_Actions.submitAction(driver, "//*[@name='btnK']", "Google Search Button");

            //capture search result
            String result = Reusable_Actions.getTextAction(driver, "//*[@id='result-stats']", "Search Result Text");

            //split the result by single space and print out the search number
            String[] arrayResult = result.split(" ");

            System.out.println("Search number for " + artists.get(i) + " is " + arrayResult[1]);
        }//end of loop
    }//end of test

    @AfterSuite
    public void quitSession(){
        driver.quit();
    }//end of after suite


}
