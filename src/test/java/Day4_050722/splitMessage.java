package Day4_050722;

public class splitMessage {
    public static void main(String[] args) {

        //declare string variable
        String splitMessage = "My name is Tae";

        //declare an array of string to store the string
        String[] splitMessageArray = splitMessage.split(" ");

        //print out Tae to the console
        System.out.println("My first name is " +splitMessageArray[3]);

    }
}
