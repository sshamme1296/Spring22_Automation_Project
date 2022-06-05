package ActionItems;

import ReusableClasses.Reusable_Actions;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class
ActionItem5_UHC {
    public static void main(String[] args) throws InterruptedException {

        //setting the local driver to reusable setDriver method
        WebDriver driver = Reusable_Actions.setDriver();

        //Create arraylist of first names and add three first names
        ArrayList<String> firstName = new ArrayList<>();
        firstName.add("Jimin");
        firstName.add("Harry");
        firstName.add("Mac");

        //Create arraylist of first names and add three first names
        ArrayList<String> lastName = new ArrayList<>();
        lastName.add("Park");
        lastName.add("Styles");
        lastName.add("Miller");

        //Create arraylist of first names and add three first names
        ArrayList<String> birthMonth = new ArrayList<>();
        birthMonth.add("10");
        birthMonth.add("02");
        birthMonth.add("01");

        //Create arraylist of first names and add three first names
        ArrayList<String> birthDate = new ArrayList<>();
        birthDate.add("13");
        birthDate.add("01");
        birthDate.add("19");

        //Create arraylist of first names and add three first names
        ArrayList<String> birthYear = new ArrayList<>();
        birthYear.add("1995");
        birthYear.add("1994");
        birthYear.add("1992");

        //Create arraylist of first names and add three first names
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("140210");
        zipCode.add("90210");
        zipCode.add("90718");

        //Create arraylist of first names and add three first names
        ArrayList<String> memberID = new ArrayList<>();
        memberID.add("10131995");
        memberID.add("02011994");
        memberID.add("01191992");

        for (int i = 0; i < firstName.size(); i++){

            //navigate to UHC.com
            driver.navigate().to("https://www.uhc.com");

            if(i == 0) {
                //verify that title UHC website contains "Health insurance plans"
                Reusable_Actions.verifyTitle(driver, "Health insurance plans", "Verify Title");
            }

            //click on 'Find a Doctor' button
            Reusable_Actions.clickAction(driver, "//*[text()= 'Find a doctor']", "Find a Doctor");

            //click on 'Sign in' button
            Reusable_Actions.clickAction(driver, "//*[text()= 'Sign in']", "Sign In");

            //click on 'Medicare Plan?' link
            Reusable_Actions.clickAction(driver, "//*[text()= 'Medicare plan?']", "Medicare Plan?");

            //switch to new tab
            Reusable_Actions.switchToTabByIndex(driver, 1);

            //click on 'Register Now' link
            Reusable_Actions.clickAction(driver, "//*[@class= 'uhc-tempo-link uhc-tempo-link--medium registerBtn ng-scope']", "Register Now");

            //Enter first name
            Reusable_Actions.sendKeysAction(driver, "//*[@id= 'firstName']", firstName.get(i), "First Name");

            //Enter last name
            Reusable_Actions.sendKeysAction(driver, "//*[@id= 'lastName']", lastName.get(i), "Last Name");

            //Select birth month
            Reusable_Actions.selectByText(driver, "//*[@name= 'dob_month']", "//*[@value= '" +birthMonth.get(i)+ "']", "Birth Month");

            //Enter birth date
            Reusable_Actions.sendKeysAction(driver, "//*[@id= 'dob_day']", birthDate.get(i), "Birth Day");

            //Enter birth year
            Reusable_Actions.sendKeysAction(driver, "//*[@id= 'dob_year']", birthYear.get(i), "Birth Year");

            //Enter zip code
            Reusable_Actions.sendKeysAction(driver, "//*[@id= 'zipCode']", zipCode.get(i), "Zip Code");

            //Enter member ID
            Reusable_Actions.sendKeysAction(driver, "//*[@id= 'memberId']", memberID.get(i), "Member ID");

            //Click continue
            Reusable_Actions.clickAction(driver, "//*[@id= 'submitBtn']", "Continue");

            //declare string to capture error message and print error message
            String errorMessage = (Reusable_Actions.captureText(driver, "//*[@id= 'plainText_error']"));
            System.out.println("\nUnable to register " +firstName.get(i)+ " " +lastName.get(i)+ ". Please see: \n" + errorMessage);

            //close the current tab
            driver.close();

            //switch back to default tab
            Reusable_Actions.switchToTabByIndex(driver, 0);
        }

        //quit driver
        driver.quit();

    } //end of main
} // end of public class
