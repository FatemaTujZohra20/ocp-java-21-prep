package chapter04;

public class EqualityInJava {
    public static void main(String[] args) {
        int x = 100;
        int y = 100;
        
        System.out.println(x == y); // true
        
        Integer a = 200;
        Integer b = 200;
        
        System.out.println(a == b); // false
        
        // a == b --> if a and b points to same reference
        
        System.out.println("----using intValue()----");
        System.out.println(a.intValue() == b.intValue()); // true, because value is same
        
        System.out.println("----using .equals()----");
        System.out.println(a.equals(b));
        
    }
}
