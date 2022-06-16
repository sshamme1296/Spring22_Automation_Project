package PageObjects;

import ReusableClasses.Reusable_Actions;
import ReusableClasses.Reusable_Actions_POM_Loggers;
import ReusableClasses.Reusable_Annotations_Class;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HumanaFindADoctorPage extends Reusable_Annotations_Class {

    //Declare the ExtentTest for each page object class
    ExtentTest logger;

    //create a constructor method that will reference the same name as your class, you can make your
    //page object class methods static when you call it in your test class
    public HumanaFindADoctorPage(WebDriver driver) {
        //page factory function for page object
        PageFactory.initElements(driver, this);
        this.logger = Reusable_Annotations_Class.logger;
    }//end of constructor

    @FindBy(xpath = "//*[@class = 'nc-link nb-link--link']")
    WebElement VisionLocatorLink;

    public void clickVisionLocatorLink(int i){
        Reusable_Actions_POM_Loggers.clickByIndexAction(driver, VisionLocatorLink, i, logger,"Medicare Advantage and Medicare Supplement plans Link");
    }

}
