package chapter05;

public class MethodOverloading {
    public static void main(String[] args) {
        // Function overloading
        
        int x = 3;
        int y = 4;
        int z = 2;
        
        double v = 3.9;
        double r = 4.5;
        
        System.out.println( sum(x, y));
        System.out.println(sum(x, y, z));
        System.out.println(sum(v, r));
        
        greet("Fatema", 20);
        greet(50, "Fatema");
        
        fun();
        fun("Fatema");
    }
    
    static int sum(int a, int b){
        return a + b;
    }
    
    static int sum(int a, int b, int c){  // different types of parameters
        return a + b + c;
    }
    
    static int sum(double a, double b){
        return (int)(a + b);
    }
    
    static void greet(String name, int age){
        System.out.println("Hello " + name + ". Your age is " + age);
    }
    
    static void greet(int age, String name){  // ordering of parameters
        System.out.println("Hello " + name + ". Your age is " + age);
    }
    
    static void fun(){
        System.out.println("Hello from fun");
    }
    
    static int fun(String name){
        System.out.println("Hello from fun another");
        return 5;
    }
    
}
