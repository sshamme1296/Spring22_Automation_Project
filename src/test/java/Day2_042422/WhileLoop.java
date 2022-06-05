package Day2_042422;

public class WhileLoop {
    public static void main(String[] args) {
        //iterate through zipcode and its streetNumber using linear array and while loop
        String[] zipCodes = new String[]{"11218", "10001", "11208", "11238"};
        int[] houseNumber = new int[]{222, 333, 444, 555};

        //initialize your starting point before calling while loop
        int i = 0;
        //define the end point while loop
        while (i < houseNumber.length){
            System.out.println("My zip code is " + zipCodes[i] + " house number " + houseNumber[i]);

            //incrementing
            i = i +1;
        }//end of while group

    }//end of main method
}//end of public class
