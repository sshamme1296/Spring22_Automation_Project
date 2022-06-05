package ActionItems;

import java.util.ArrayList;

public class CountryCode {
    public static void main(String[] args) {

        //create an ArrayList for countries
        ArrayList<String> country = new ArrayList<>();
        country.add("USA");
        country.add("Bangladesh");
        country.add("South Korea");
        country.add("Ethiopia");
        country.add("Singapore");

        //create an Arraylist for country code
        ArrayList<Integer> countryCode = new ArrayList<>();
        countryCode.add(1);
        countryCode.add(880);
        countryCode.add(82);
        countryCode.add(251);
        countryCode.add(65);

        //iterate through array of cities
        for (int i = 0; i < country.size(); i++){
            System.out.println("My country is " + country.get(i) + " and my country code is " + countryCode.get(i) + ".");
        }//end of for loop

    }//end of main method
}//end of public class
