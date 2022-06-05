package ActionItems;

import java.util.ArrayList;

public class CityChecker {
    public static void main(String[] args) {

        //Declare array of cities
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Brooklyn");
        cities.add("Queens");
        cities.add("Manhattan");
        cities.add("Staten Island");

        //For loop with condition
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i) == "Brooklyn" || cities.get(i) == "Manhattan") {
                System.out.println("My city is " + cities.get(i));
            }
        }

    }//end of main method
}// end of public class
