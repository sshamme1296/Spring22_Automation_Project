package ActionItems;

import ReusableClasses.Reusable_Actions_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ActionItem6_HumanaProject {

    //declare the local driver outside so that it can be reusable with other annotation methods
    WebDriver driver, driver2;
    ExtentReports reports;
    ExtentTest logger;

    //before suite will set the driver you are using
    @BeforeSuite
    public void SetChromeDriver() {
        driver = Reusable_Actions_Loggers.setDriver();
        driver2 = Reusable_Actions_Loggers.setDriver2();
        //define the path to the report
        reports = new ExtentReports("src/main/java/HTML_Report/Automation.html", true);
    }

    /* 1. As a user I want to be able to select my state and input my age so that I can receive a quote.*/
    @Test(priority = 1)
    public void Select_State_Input_Age() {

        logger = reports.startTest("Test No. 1: Receive a quote");

        driver.navigate().to("https://www.humana.com/vision-insurance");

        //select state
        Reusable_Actions_Loggers.selectByText(driver, "//*[@name= 'State']", "//*[@value= 'New York']", logger, "Select State");

        //input age
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@name= 'Age']", "76", logger, "Input Age");

        //click on "Get a Quote"
        Reusable_Actions_Loggers.clickAction(driver, "//*[text()= 'Get a quote']", logger, "Get a Quote");

        //scroll to view plans
        Reusable_Actions_Loggers.scrollIntoView(driver, "//*[@id= 'vision-plans']", logger, "Scroll to Plan");

        //Take a screenshot of vision plan quote
        Reusable_Actions_Loggers.captureScreenshot(driver, "Vision Plan Quote", logger, "Vision Plan Quote");

        //end the logger per test
        reports.endTest(logger);
    } // end of test 1

    /* 2. As a user after receiving my quote I want to be able to see more info on each plan so that I can buy the right one for me */
    @Test(dependsOnMethods = "Select_State_Input_Age")
    public void View_Detailed_Plan() throws InterruptedException {

        logger = reports.startTest("Test No. 2: View Detailed Plan Information");

        //Make sure vision plan is check
        Boolean visionPLanCheck = Reusable_Actions_Loggers.checkCheckBox(driver, "//*[@id = 'vision-check']", logger, "Vision Plan checkbox");
        System.out.println("Is vision plan checked? " + visionPLanCheck);

        //get more information of the plan by clicking "See more about this plan"
        Reusable_Actions_Loggers.clickByIndexAction(driver, "//*[@data-loc= 'Vision']", 1, logger, "See more about this plan");

        //print the price for the plan
        String price = Reusable_Actions_Loggers.getTextAction(driver, "//*[@class= 'add-to-cart-container']", logger, "Vision Plan Price");
        String[] arrayResult = price.split("\n");
        System.out.println("Price of " + arrayResult[1] + " for quote is " + arrayResult[0] + "\n");

        //Open the "Benefits Summary"
        Reusable_Actions_Loggers.clickAction(driver, "//*[@class= 'underline-link x2-right']", logger, "Benefits Summary");

        //Switch to "Benefits Summary Page"
        Reusable_Actions_Loggers.switchToTabByIndex(driver, 1, logger, "Benefits Summary Page");

        Thread.sleep(3000);

        driver.close();

        //end the logger per test
        reports.endTest(logger);
    } //end of test 2

    /* 3. As a user I want to be able to buy a plan so that I can have a vision insurance plan */
    //@Test(dependsOnMethods = "View_Detailed_Plan")
    /* public void Buy_Plan() throws InterruptedException {

        logger = reports.startTest("Test No. 3: Buy a Vision Insurance Plan");

        //switch back to previous tab
        Reusable_Actions_Loggers.switchToTabByIndex(driver, 0, logger, "Switch back to plan page");

        //Click add to cart
        Reusable_Actions_Loggers.clickAction(driver, "//*[@id= 'plan-details-add-to-cart']", logger, "Add to cart button");
        Thread.sleep(3000);

        //scroll to view different plans
        Reusable_Actions_Loggers.scrollByPixels(driver, "0", "800", logger, "Scroll");
        Thread.sleep(3000);
        Reusable_Actions_Loggers.scrollByPixels(driver, "0", "1500", logger, "Scroll");
        Thread.sleep(3000);
        Reusable_Actions_Loggers.scrollByPixels(driver, "0", "2200", logger, "Scroll");
        Thread.sleep(3000);

        //add click to handle popups
        Reusable_Actions_Loggers.clickByCoordinates(driver, 10, 10, logger, "click");

        //click 'Add applicant details'
        Reusable_Actions_Loggers.clickAction(driver, "//*[@id= 'save-and-continue']", logger, "Add applicant details button");

        //Enter applicant information
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id= 'firstname']", "George", logger, "First Name");
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id= 'lastname']", "Miller", logger, "Last Name");
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id= 'dob']", "09181945", logger, "Date of Birth");
        Reusable_Actions_Loggers.selectByText(driver, "//*[@id= 'applicant-type']", "//*[text() = 'Male']", logger, "Applicant Type");

        //Save
        Reusable_Actions_Loggers.clickAction(driver, "//*[@id= 'save-details']", logger, "Save Button");

        //verify that applicant details were saved by printing them
        String applicantDetails = Reusable_Actions_Loggers.getTextAction(driver, "//*[@id= 'rhr-applicants']", logger, "Applicant Details");
        String[] arrayResult = applicantDetails.split("\n");
        System.out.println("Applicant details: \n" + arrayResult[0] + "\n" + arrayResult[1] + "\n" + arrayResult[2] + "\n");

        //Save and continue
        Reusable_Actions_Loggers.clickAction(driver, "//*[@id= 'save-and-continue']", logger, "Save and Continue Button");
        Thread.sleep(3000);

        //Enter applicant address info
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id= 'address1']", "810 Grand St", logger, "Street Name");
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id= 'zipcode']", "11206", logger, "ZipCode");
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id= 'email']", "jojimiller@gmail.com", logger, "Email");
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id= 'confirmemail']", "jojimiller@gmail.com", logger, "Email Confirmation");
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id= 'phone']", "9171234567", logger, "Phone Number");
        Thread.sleep(3000);

        //add click to handle popups
        Reusable_Actions_Loggers.clickByCoordinates(driver, 10, 10, logger, "click");
        Reusable_Actions_Loggers.clickByCoordinates(driver, 10, 10, logger, "click");

        //Save and continue
        Reusable_Actions_Loggers.clickAction(driver, "//*[@id= 'next-cta']", logger, "Save and Continue Button");
        Thread.sleep(3000);

        //Answer Survey Questions
        Reusable_Actions_Loggers.clickAction(driver, "//*[@id= 'uniform-StateSurveyDetailsModel_surveyQuestions_0__101284562']", logger, "Save and Continue Button");
        Reusable_Actions_Loggers.clickAction(driver, "//*[@id= 'uniform-StateSurveyDetailsModel_surveyQuestions_1__141284567']", logger, "Save and Continue Button");
        Reusable_Actions_Loggers.clickAction(driver, "//*[@id= 'uniform-StateSurveyDetailsModel_surveyQuestions_2__181284572']", logger, "Save and Continue Button");
        Reusable_Actions_Loggers.clickAction(driver, "//*[@id= 'uniform-StateSurveyDetailsModel_surveyQuestions_3__191284574']", logger, "Save and Continue Button");

        //Save and continue
        Reusable_Actions_Loggers.clickAction(driver, "//*[@id= 'submit-survey']", logger, "Save and Continue to payment Button");
        Thread.sleep(3000);

        //Print Payment for monthly and annual payment details
        String monthlyPayment = Reusable_Actions_Loggers.getTextAction(driver, "//*[@class= 'box-shadow-inner seven columns x3-top']", logger, "Monthly Payment");
        String[] arrayResult2 = monthlyPayment.split("\n");
        System.out.println("Plan break down for monthly plan is: ");
        System.out.println(arrayResult2[4] + " " + arrayResult2[5] + "\n" + arrayResult2[6] + " " + arrayResult2[7] + "\n" + arrayResult2[8] + " " + arrayResult2[9] + "\n"
                + arrayResult2[10] + " " + arrayResult2[11] + "\n" + arrayResult2[12] + " " + arrayResult2[13] + "\n"
                + arrayResult2[14] + " " + arrayResult2[15] + "\n" + arrayResult2[16] + " " + arrayResult2[17] + "\n");

        //click yearly payment button
        Reusable_Actions_Loggers.clickByIndexAction(driver, "//*[@id= 'uniform-PaymentFrequency_PaymentMode']", 1, logger, "Yearly Radio Button");
        String yearlyPayment = Reusable_Actions_Loggers.getTextAction(driver, "//*[@class= 'box-shadow-inner seven columns x3-top']", logger, "Yearly Payment");
        String[] arrayResult3 = monthlyPayment.split("\n");
        System.out.println("Plan break down for yearly plan is: ");
        System.out.println(arrayResult3[4] + " " + arrayResult3[5] + "\n" + arrayResult3[6] + " " + arrayResult3[7] + "\n" + arrayResult3[8] + " " + arrayResult3[9] + "\n"
                + arrayResult3[10] + " " + arrayResult3[11] + "\n" + arrayResult3[12] + " " + arrayResult3[13] + "\n"
                + arrayResult3[14] + " " + arrayResult3[15] + "\n" + arrayResult3[16] + " " + arrayResult3[17] + "\n");

        Thread.sleep(3000);

        //end the logger per test
        reports.endTest(logger);

    } //end of test 3 */

    /* 4. As a user I want to be able to find a doctor on Humana by zipcode so that I can know of the ophthalmologists in my area.*/
    //@Test(priority = 2)
   /* public void Find_A_Doctor_By_Zipcode() {
        logger = reports.startTest("Test No. 4: Find a Doctor by Zipcode");

        driver.navigate().to("https://www.humana.com/vision-insurance");

        //Click on find a doctor link
        Reusable_Actions_Loggers.clickByIndexAction(driver, "//*[@class = 'next-step-cta-container']", 0, logger, "Find a Doctor Link");

        //click on 'Medicare Advantage and Medicare Supplement plans'
        Reusable_Actions_Loggers.clickByIndexAction(driver, "//*[@class = 'nc-link nb-link--link']", 0, logger, "Medicare Advantage and Medicare Supplement plans Link");

        //Switch tabs
        Reusable_Actions_Loggers.switchToTabByIndex(driver, 1, logger, "Switch to Find a Eye Doctor tab");

        //Enter zipcode
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id = 'zip']", "93627", logger, "Enter Zipcode");

        //submit to search by zipcode
        Reusable_Actions_Loggers.submitAction(driver, "//*[@class = 'sm']", logger, "Submit ZipCode");

        //click to get results sent to email
        Reusable_Actions_Loggers.clickAction(driver, "//*[@class = 'sm white bordered with-svg btn-email']", logger, "Email link");

        //enter email
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id = 'recipient_email']", "jojimiller@gmail.com", logger, "Email Bar");

        //submit 'Send Search Results'
        Reusable_Actions_Loggers.submitAction(driver, "//*[@class = 'sm']", logger, "Send Search Results");

        //end the logger per test
        reports.endTest(logger);

    } //end of test 4

    /* 5. As a user I want to be able to find a doctor on Humana by last name so that I can know of specific ophthalmologists in my area.*/
    //@Test(dependsOnMethods = "Find_A_Doctor_By_Zipcode")
   /* public void Find_A_Doctor_By_Name() throws InterruptedException {
        logger = reports.startTest("Test No. 5: Find a Doctor by Name");

        //go back to previous page
        Reusable_Actions_Loggers.goBackOne(driver, logger, "Back to 'Find an Eye Doctor' Page");

        Thread.sleep(3000);

        //click on search by doctor
        Reusable_Actions_Loggers.clickByIndexAction(driver, "//*[text() = 'Search by doctor']", 0, logger, "Search by Doctor Link");

        //Enter doctors last name
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id = 'provider']", "Shah", logger, "Doctors Last Name");

        //Enter zipcode
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id = 'zip']", "93627", logger, "Enter Zipcode");

        //submit to search
        Reusable_Actions_Loggers.submitAction(driver, "//*[@class = 'sm']", logger, "Submit ZipCode");

        Thread.sleep(3000);

        //take a screenshot of map
        Reusable_Actions_Loggers.captureScreenshot(driver, "Map", logger, "Map of Results");

        //close current tab
        driver.close();

        //switch back to previous tab
        Reusable_Actions_Loggers.switchToTabByIndex(driver, 0, logger, "Original Tab");

        Thread.sleep(3000);

        //end the logger per test
        reports.endTest(logger);

    } //end of test 5

    /* 6. As a user I want to change the website language to Spanish so that I can read the website in Spanish*/
    //@Test (priority = 3)
   /* public void English_to_Spanish() throws InterruptedException {

        logger = reports.startTest("Test No. 6: Translate page to Spanish");

        driver.navigate().to("https://www.humana.com/vision-insurance");

        //get title name of Eng page
        String engTitle = Reusable_Actions_Loggers.getTitle(driver, logger, "English Title");

        //click on link to change site language to spanish
        Reusable_Actions_Loggers.clickAction(driver, "//*[text() = 'Español']", logger, "Español link");

        Thread.sleep(5000);

        //translate english title to spanish title
        String esTitle = Reusable_Actions_Loggers.translate(driver2, engTitle, logger, "Translate Title");
        driver2.quit();

        System.out.println();

        //verify that title of spanish page matches translated title
        Reusable_Actions_Loggers.verifyTitle(driver, esTitle, logger, "Verify Spanish Title");

        //end the logger per test
        reports.endTest(logger);

    } //end of test 6
*/
    @AfterSuite
    public void quitSession() {
        driver.quit();
        reports.flush();
    }//end of after suite

}
