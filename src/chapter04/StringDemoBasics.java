package chapter04;

public class StringDemoBasics {
    public static void main(String[] args) {
        //Strings
        String firstName = "Fatema";
        String lastName = "Zohra";
        
        String emptyStr = ""; // an empty space is also a valid String
        String str = " ";  // a space is also a valid String
        
        String fullName = firstName + " " + lastName;
        
        System.out.println(firstName + " " + lastName);
        System.out.println(fullName);
    }
}
