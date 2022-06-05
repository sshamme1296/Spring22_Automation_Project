package Day11_052922;

import ReusableClasses.Reusable_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Boolean_With_Checkbox {

    //declare the local driver outside so that it can be reusable with other annotation methods
    WebDriver driver;

    //before suite will set the driver you are using
    @BeforeSuite
    public void SetChromeDriver() {
        driver = Reusable_Actions.setDriver();
    }

    @Test
    public void Yahoo_Stay_Signed_In_Checkbox_Verification() {

        driver.navigate().to("https//www.yahoo.com");

        Reusable_Actions.clickAction(driver, "", "Sign In");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        Boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type= 'checkbox']"))).isSelected();

        System.out.println("Is element located? " + elementState);

    }



    @AfterSuite
    public void quitSession() {
        driver.quit();
    }//end of after suite
}
