package PageObjects;

import ReusableClasses.Reusable_Actions_POM_Loggers;
import ReusableClasses.Reusable_Annotations_Class;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HumanaInsurancePlansQuotesPage extends Reusable_Annotations_Class {

    //Declare the ExtentTest for each page object class
    ExtentTest logger;

    //create a constructor method that will reference the same name as your class, you can make your
    //page object class methods static when you call it in your test class
    public HumanaInsurancePlansQuotesPage(WebDriver driver) {
        //page factory function for page object
        PageFactory.initElements(driver, this);
        this.logger = Reusable_Annotations_Class.logger;
    }//end of constructor

    //define all the webelements using @find by concept
    @FindBy(xpath = "//*[@id= 'vision-plans']")
    WebElement visionPlans;
    @FindBy(xpath = "//*[@id = 'vision-check']")
    WebElement visionPlanCheckBox;
    @FindBy(xpath = "//*[@data-loc= 'Vision']")
    WebElement seeMoreInfo;

    public void scrollToItem(){
        Reusable_Actions_POM_Loggers.scrollIntoView(driver, visionPlans, logger, "Scroll to Vision Plans");
    }

    public void visionPlansScreenShot(String screenShotName){
        Reusable_Actions_POM_Loggers.captureScreenshot(driver, screenShotName, logger, "Vision Plans Screen Shot");
    }

    public void visionPlanCheckBox(){
        Boolean visionPlanCheck = Reusable_Actions_POM_Loggers.checkCheckBox(driver, visionPlanCheckBox, logger, "Vision Plan checkbox");
        System.out.println("Is vision plan checked? " + visionPlanCheck);
    }

    public void seeMoreInfo(int i){
        Reusable_Actions_POM_Loggers.clickByIndexAction(driver, seeMoreInfo, i, logger, "See more about this plan");
    }

}
