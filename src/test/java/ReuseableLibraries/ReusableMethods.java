package ReuseableLibraries;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ReusableMethods {

    //create a void method to add two numbers
    public static void addTwoNumbers(int num1, int num2) {
        System.out.println("The result of two numbers is " + (num1 + num2));
    }//end of add two number method

    //create a return integer method to subtract two numbers
    public static int subtractTwoNumbers(int a, int b){
        int result = a-b;
        System.out.println("The result of two numbers for subtraction is " + result
        );

        return result;

    }

}
