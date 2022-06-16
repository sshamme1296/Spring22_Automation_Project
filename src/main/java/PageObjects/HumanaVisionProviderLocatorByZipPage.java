package PageObjects;

import ReusableClasses.Reusable_Actions_POM_Loggers;
import ReusableClasses.Reusable_Annotations_Class;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HumanaVisionProviderLocatorByZipPage extends Reusable_Annotations_Class {

    //Declare the ExtentTest for each page object class
    ExtentTest logger;

    //create a constructor method that will reference the same name as your class, you can make your
    //page object class methods static when you call it in your test class
    public HumanaVisionProviderLocatorByZipPage(WebDriver driver){
        //page factory function for page object
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotations_Class.logger;
    }//end of constructor

    //define all the webelements using @find by concept
    @FindBy(xpath = "//*[@class = 'sm white bordered with-svg btn-email']")
    WebElement getResultsSentByEmail;
    @FindBy(xpath = "//*[@id = 'recipient_email']")
    WebElement enterEmail;
    @FindBy(xpath = "//*[@class = 'sm']")
    WebElement submitEmail;

    public void getResultsSentByEmail(){
        Reusable_Actions_POM_Loggers.clickAction(driver, getResultsSentByEmail, logger, "Get Results Sent By Email");
    }

    public void enterEmail(String userValue){
        Reusable_Actions_POM_Loggers.sendKeysAction(driver, enterEmail, userValue, logger, "Enter Email");
    }

    public void submitEmail(){
        Reusable_Actions_POM_Loggers.clickAction(driver, submitEmail, logger, "Submit Email");
    }
}
