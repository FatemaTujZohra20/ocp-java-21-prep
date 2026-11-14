package chapter05;

public class FunctionsInJava {
    public static void main(String[] args) {
        int i = 4;
        int j = 5;
        int result = sum(i, j);
        
        System.out.println(result);
        
        // Types of Functions example
        greet();
        sayHello("Fatema");
        System.out.println(getNumber());
        System.out.println(multiply(2, 3));
        
    }
    
    static int sum(int a, int b) {
        int resultOfAandB = a + b;
        return resultOfAandB;
    }
    
    // No Input, No output
    static void greet(){
        System.out.println("Hello World");
        return; // optional
    }
    
    // Input, no output
    static void sayHello(String name){
        System.out.println("Hello " + name);
    }
    
    // No Input, output
    static int getNumber(){
        return 10;
    }
    
    // Input, Output
    static int multiply(int a, int b){
        return (a * b);
    }
}
