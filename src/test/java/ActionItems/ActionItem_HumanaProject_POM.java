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
        BaseClass.humanaVisionHomePage().selectState("//*[@value= 'New York']");
        BaseClass.humanaVisionHomePage().inputAge("76");
        BaseClass.humanaVisionHomePage().submitGetQuote();
        BaseClass.humanaInsurancePlansQuotesPage().scrollToItem();
        BaseClass.humanaInsurancePlansQuotesPage().visionPlansScreenShot("Vision Plans");
    }

    /* 2. As a user after receiving my quote I want to be able to see more info on each plan so that I can buy the right one for me */
    @Test(dependsOnMethods = "ReceiveAQuote")
    public void SeeBenefitsSummary() throws InterruptedException {

        BaseClass.humanaInsurancePlansQuotesPage().visionPlanCheckBox();
        BaseClass.humanaInsurancePlansQuotesPage().seeMoreInfo(1);
        BaseClass.humanaConsumerPlanPage().capturePriceandPrint();
        BaseClass.humanaConsumerPlanPage().clickOnBenefitsSummary();

        //Switch to "Benefits Summary Page"
        Reusable_Actions_Loggers.switchToTabByIndex(driver, 5, logger, "Benefits Summary Page");

        Thread.sleep(3000);

        driver.close();
    }

    /* 3. As a user I want to be able to find a doctor on Humana by zipcode so that I can know of the ophthalmologists in my area.*/
    @Test(priority = 2)
    public void FindADoctorByZipcode() {

        driver.navigate().to("https://www.humana.com/vision-insurance");
        BaseClass.humanaVisionHomePage().findADoctor(0);
        BaseClass.humanaFindADoctorPage().clickVisionLocatorLink(0);

        //Switch tabs
        Reusable_Actions_Loggers.switchToTabByIndex(driver, 1, logger, "Switch to Find a Eye Doctor tab");

        BaseClass.humanaVisionProviderLocatorPage().EnterZipcode("93627");

        BaseClass.humanaVisionProviderLocatorPage().searchByZipCode();

        BaseClass.humanaVisionProviderLocatorByZipPage().getResultsSentByEmail();
        BaseClass.humanaVisionProviderLocatorByZipPage().enterEmail("jojimiller@gmail.com");
        BaseClass.humanaVisionProviderLocatorByZipPage().submitEmail();
    }

    /* 5. As a user I want to be able to find a doctor on Humana by last name so that I can know of specific ophthalmologists in my area.*/
    @Test(dependsOnMethods = "FindADoctorByZipcode")
    public void FindADoctorByName() throws InterruptedException {

        //go back to previous page
        Reusable_Actions_Loggers.goBackOne(driver, logger, "Back to 'Find an Eye Doctor' Page");

        Thread.sleep(3000);

        BaseClass.humanaVisionProviderLocatorPage().clickOnSearchByDoctor(0);
        BaseClass.humanaVisionProviderLocatorPage().enterProviderName("Shah");
        BaseClass.humanaVisionProviderLocatorPage().EnterZipcode("93627");
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
