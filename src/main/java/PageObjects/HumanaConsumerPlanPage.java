package PageObjects;

import ReusableClasses.Reusable_Actions_POM_Loggers;
import ReusableClasses.Reusable_Annotations_Class;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HumanaConsumerPlanPage extends Reusable_Annotations_Class {

    //Declare the ExtentTest for each page object class
    ExtentTest logger;

    //create a constructor method that will reference the same name as your class, you can make your
    //page object class methods static when you call it in your test class
    public HumanaConsumerPlanPage(WebDriver driver) {
        //page factory function for page object
        PageFactory.initElements(driver, this);
        this.logger = Reusable_Annotations_Class.logger;
    }//end of constructor

    @FindBy(xpath = "//*[@class= 'add-to-cart-container']")
    WebElement priceOfPlan;
    @FindBy(xpath = "//*[@class= 'underline-link x2-right']")
    WebElement benefitsSummary;

    public void capturePriceandPrint(){
        String price = Reusable_Actions_POM_Loggers.getTextAction(driver, priceOfPlan, logger, "Vision Plan Price");
        String[] arrayResult = price.split("\n");
        System.out.println("Price of " + arrayResult[1] + " for quote is " + arrayResult[0] + "\n");
    }

    public void clickOnBenefitsSummary(){
        Reusable_Actions_POM_Loggers.clickAction(driver, benefitsSummary, logger, "Benefits Summary");
    }
}
