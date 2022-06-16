package ActionItems;

import PageObjects.BaseClass;
import ReusableClasses.Reusable_Actions_Loggers;
import ReusableClasses.Reusable_Annotations_Class;
import org.jsoup.Connection;
import org.testng.annotations.Test;

public class ActionItem_HumanaProject_POM extends Reusable_Annotations_Class {

    /* 1. As a user I want to be able to select my state and input my age so that I can receive a quote.*/
    @Test(priority = 1)
    public void ReceiveAQuote() {
        driver.navigate().to("https://www.humana.com/vision-insurance");

        //select state
        BaseClass.humanaVisionHomePage().selectState("//*[@value= 'New York']");

        //input age
        BaseClass.humanaVisionHomePage().inputAge("76");

        //click on "Get a Quote"
        BaseClass.humanaVisionHomePage().submitGetQuote();

        //scroll to view plans
        BaseClass.humanaInsurancePlansQuotesPage().scrollToItem();

        //take a screenshot of vision plan quote
        BaseClass.humanaInsurancePlansQuotesPage().visionPlansScreenShot("Vision Plans");
    }

    /* 2. As a user after receiving my quote I want to be able to see more info on each plan so that I can buy the right one for me */
    @Test(dependsOnMethods = "ReceiveAQuote")
    public void SeeBenefitsSummary() throws InterruptedException {

        //make sure vision plan is checked
        BaseClass.humanaInsurancePlansQuotesPage().visionPlanCheckBox();

        //get more information by clicking "see more about this plan"
        BaseClass.humanaInsurancePlansQuotesPage().seeMoreInfo(1);

        //print the price for the plan
        BaseClass.humanaConsumerPlanPage().capturePriceandPrint();

        //Open the "Benefits Summary"
        BaseClass.humanaConsumerPlanPage().clickOnBenefitsSummary();

        //Switch to "Benefits Summary Page"
        Reusable_Actions_Loggers.switchToTabByIndex(driver, 5, logger, "Benefits Summary Page");

        Thread.sleep(3000);

        //close current tab
        driver.close();
    }

    /* 3. As a user I want to be able to find a doctor on Humana by zipcode so that I can know of the ophthalmologists in my area.*/
    @Test(priority = 2)
    public void FindADoctorByZipcode() {

        driver.navigate().to("https://www.humana.com/vision-insurance");

        //Click on find a doctor link
        BaseClass.humanaVisionHomePage().findADoctor(0);

        //click on 'Medicare Advantage and Medicare Supplement plans'
        BaseClass.humanaFindADoctorPage().clickVisionLocatorLink(0);

        //Switch tabs
        Reusable_Actions_Loggers.switchToTabByIndex(driver, 1, logger, "Switch to Find a Eye Doctor tab");

        //Enter zipcode
        BaseClass.humanaVisionProviderLocatorPage().EnterZipcode("93627");

        //submit to search by zipcode
        BaseClass.humanaVisionProviderLocatorPage().searchByZipCode();

        //click to get results sent to email
        BaseClass.humanaVisionProviderLocatorByZipPage().getResultsSentByEmail();

        //enter email
        BaseClass.humanaVisionProviderLocatorByZipPage().enterEmail("jojimiller@gmail.com");

        //submit 'Send Search Results'
        BaseClass.humanaVisionProviderLocatorByZipPage().submitEmail();
    }

    /* 5. As a user I want to be able to find a doctor on Humana by last name so that I can know of specific ophthalmologists in my area.*/
    @Test(dependsOnMethods = "FindADoctorByZipcode")
    public void FindADoctorByName() throws InterruptedException {

        //go back to previous page
        Reusable_Actions_Loggers.goBackOne(driver, logger, "Back to 'Find an Eye Doctor' Page");

        Thread.sleep(3000);

        //click on search by doctor
        BaseClass.humanaVisionProviderLocatorPage().clickOnSearchByDoctor(0);

        //Enter doctors last name
        BaseClass.humanaVisionProviderLocatorPage().enterProviderName("Shah");

        //Enter zipcode
        BaseClass.humanaVisionProviderLocatorPage().EnterZipcode("93627");

        //submit to search
        BaseClass.humanaVisionProviderLocatorPage().searchByZipCode();

        Thread.sleep(3000);

        //take a screenshot of map
        Reusable_Actions_Loggers.captureScreenshot(driver, "Map", logger, "Map of Results");

        //close current tab
        driver.close();

        //switch back to previous tab
        Reusable_Actions_Loggers.switchToTabByIndex(driver, 0, logger, "Original Tab");

        Thread.sleep(3000);
    }

    /* 5. As a user I want to change the website language to Spanish so that I can read the website in Spanish*/
    @Test (priority = 3)
    public void EnglishtoSpanish() throws InterruptedException {

        driver.navigate().to("https://www.humana.com/vision-insurance");

        //get title name of Eng page
        String engTitle = Reusable_Actions_Loggers.getTitle(driver, logger, "English Title");

        //click on link to change site language to spanish
        BaseClass.humanaVisionHomePage().clickOnEspañol();

        Thread.sleep(5000);

        //translate english title to spanish title
        String esTitle = Reusable_Actions_Loggers.translate(driver2, engTitle, logger, "Translate Title");
        driver2.quit();

        System.out.println();

        //verify that title of spanish page matches translated title
        Reusable_Actions_Loggers.verifyTitle(driver, esTitle, logger, "Verify Spanish Title");
    }





}
