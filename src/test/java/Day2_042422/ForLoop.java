package Day2_042422;

import java.util.ArrayList;

public class ForLoop {
    public static void main(String[] args) {
        //create an arraylist for cities and loop/iterating through all the values for loop
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Brooklyn");
        cities.add("Queens");
        cities.add("Manhattan");
        cities.add("Bronx");
        cities.add("Staten Island");

        //iterate through array of cities
        for (int i = 0; i < cities.size(); i++){
            System.out.println("i is now " + i);
            System.out.println("My city is " + cities.get(i));
        }//end of for loop

    }//end of main
}//end of java class
