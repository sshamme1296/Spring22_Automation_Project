package PageObjects;

import ReusableClasses.Reusable_Actions_POM_Loggers;
import ReusableClasses.Reusable_Annotations_Class;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HumanaVisionHomePage extends Reusable_Annotations_Class {

    //Declare the ExtentTest for each page object class
    ExtentTest logger;

    //create a constructor method that will reference the same name as your class, you can make your
    //page object class methods static when you call it in your test class
    public HumanaVisionHomePage(WebDriver driver){
        //page factory function for page object
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotations_Class.logger;
    }//end of constructor

    //define all the webelements using @find by concept
    @FindBy(xpath = "//*[@name='State']")
    WebElement selectState;
    @FindBy(xpath = "//*[@name='Age']")
    WebElement selectAge;
    @FindBy(xpath = "//*[text()= 'Get a quote']")
    WebElement clickGetAQuote;
    @FindBy(xpath = "//*[@class = 'next-step-cta-container']")
    WebElement findADoctor;
    @FindBy(xpath = "//*[text() = 'Español']")
    WebElement español;

    public void selectState(String xpath){
        Reusable_Actions_POM_Loggers.selectByText(driver,selectState,xpath,logger,"Select State");
    }

    public void inputAge(String userValue){
        Reusable_Actions_POM_Loggers.sendKeysAction(driver, selectAge, userValue, logger, "Input Age");
    }

    public void submitGetQuote(){
        Reusable_Actions_POM_Loggers.submitAction(driver, clickGetAQuote, logger, "Get a Quote");
    }

    public void findADoctor(int i){
        Reusable_Actions_POM_Loggers.clickByIndexAction(driver, findADoctor, i, logger, "Find a Doctor Link");
    }

    public void clickOnEspañol(){
        Reusable_Actions_POM_Loggers.clickAction(driver, español, logger, "Español link");
    }

}
