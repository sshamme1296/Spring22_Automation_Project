package PageObjects;

import ReusableClasses.Reusable_Actions_POM_Loggers;
import ReusableClasses.Reusable_Annotations_Class;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HumanaVisionProviderLocatorPage extends Reusable_Annotations_Class {

    //Declare the ExtentTest for each page object class
    ExtentTest logger;

    //create a constructor method that will reference the same name as your class, you can make your
    //page object class methods static when you call it in your test class
    public HumanaVisionProviderLocatorPage(WebDriver driver){
        //page factory function for page object
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotations_Class.logger;
    }//end of constructor

    //define all the webelements using @find by concept
    @FindBy(xpath = "//*[@id = 'zip']")
    WebElement enterZipcode;
    @FindBy(xpath = "//*[text() = 'Search by doctor']")
    WebElement searchByDoctor;
    @FindBy(xpath = "//*[@id = 'provider']")
    WebElement enterProvider;


    public void EnterZipcode(String userValue){
        Reusable_Actions_POM_Loggers.sendKeysAction(driver, enterZipcode, userValue, logger, "Enter Zip Code");
    }

    public void searchByZipCode(){
        Reusable_Actions_POM_Loggers.submitAction(driver, enterZipcode, logger, "Search by ZipCode");
    }

    public void clickOnSearchByDoctor(int i){
        Reusable_Actions_POM_Loggers.clickByIndexAction(driver, searchByDoctor, i, logger, "Search by Doctor Link");
    }

    public void enterProviderName(String userValue){
        Reusable_Actions_POM_Loggers.sendKeysAction(driver, enterProvider, userValue, logger, "Doctors Last Name");
    }




}
