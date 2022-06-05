package Day3_043022;

import ReuseableLibraries.ReusableMethods;

public class testingMethods {

    public static void main(String[] args) {

        //call the add two number method a nd execute it
        ReusableMethods.addTwoNumbers(20,30);
        
        //call the return method to subtract two numbers
        int finalResult = ReusableMethods.subtractTwoNumbers(20,10);
        int newResult = finalResult + 10;
        System.out.println("New result is " +newResult);

    }

}
