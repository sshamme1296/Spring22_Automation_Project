package ActionItems;

public class RegionCode {
    public static void main(String[] args) {

        //create string array for regions
        String[] region = new String[]{"North", "South", "Midwest", "West"};

        //create int array for area codes
        int[] areaCode = new int[]{613, 777, 901, 123};

        //initialize your starting point before calling while loop
        int i = 0;
        //define the end point while loop
        while (i < areaCode.length){
            System.out.println("My region is " + region[i] + " and my area code is " + areaCode[i]);
            //incrementing
            i = i +1;
        }//end of while group
    }//end of main method
}//end of public class
