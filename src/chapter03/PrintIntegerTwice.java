package chapter03;

public class PrintIntegerTwice {
    
    static void PrintIntegerTwicePatterMatching(Number number) {
        if (number instanceof Integer data)
            System.out.println(data.intValue());
//        System.out.println(data.intValue());
    }
    
    public static void main(String[] args) {
        PrintIntegerTwicePatterMatching(5);
        
        System.out.println();

//        PrintIntegerTwicePatterMatching(5.5);
    }
}