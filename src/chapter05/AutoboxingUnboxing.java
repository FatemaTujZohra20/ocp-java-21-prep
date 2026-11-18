package chapter05;

public class AutoboxingUnboxing {
    public static void main(String[] args) {
        // ---- usage in assignments -----
        
        System.out.println("--------usage in assignments------------");
        
        // Autoboxing
        int x = 10;
        Integer y = x;  // autoboxing
        // Integer y = Integer.valueOf(x);  // Optional
        
        System.out.println(x);
        System.out.println(y);  // unboxing
        
        System.out.println("----------------------");
        
        // Unboxing
        //Integer a = new Integer(20); // Old way
        // Integer a = Integer.valueOf(20);
        Integer a = 20;  // autoboxing
        int b = a;   // unboxing
        
        System.out.println(a); // unboxing
        System.out.println(b);
        
        System.out.println("-----------usage in method calls-----------");
        
        // ----- method calls -----
        Integer w = 50;
        printInteger(w);
        
        System.out.println("----------------------");
        
        int v = 40;
        printInteger(v);
        
        System.out.println("-----------usage in Arithmetic operations-----------");
        // ---- usage in Arithmetic operations -----
        Integer i = 10;
        Integer j = 20;
        
        int sum = i.intValue() + j.intValue();
        System.out.println(sum);
    }
    
    // usage in method calls
    static void printInteger(int x){
        System.out.println(x);
    }
}
