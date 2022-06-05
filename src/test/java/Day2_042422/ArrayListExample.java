package Day2_042422;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        //create an ArrayList for countries
        ArrayList<String> countries = new ArrayList<>();
        countries.add("USA");
        countries.add("Bangladesh");
        countries.add("Korea");
        countries.add("Ethiopia");
        countries.add("Singapore");

        //I want to print 4th value from the list
        System.out.println("My last country is " + countries.get(3) + " and my third country is " + countries.get(2));


    }//main method ending


}//class ending
