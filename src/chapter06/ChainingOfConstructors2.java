package chapter06;
/*
   We can define chaining of constructors
   in the following way also
 */
public class ChainingOfConstructors2 {
    public static void main(String[] args) {
        // Chaining of Constructors
        
        Student4 s1 = new Student4();
//        Student4 s2 = new Student4("Meem");
//        Student4 s3 = new Student4("Fatema", 22);
//        Student4 s4 = new Student4("Zohra", 21, 103);
//        Student4 s5 = new Student4("Tuj", 20, 104, "IIT");
        
        System.out.println(s1.name);
        System.out.println(s1.age);
        System.out.println(s1.rollNumber);
        System.out.println(s1.college);
        
    }
}


// Chaining of Constructors
class Student4 {
    String name;
    int age;
    int rollNumber;
    String college;
    
    Student4(){
        // Default constructor
        this("Unknown");
        System.out.println("I am in first constructor");
    }
    
    // Chaining of Constructors in another way
    
    Student4(String name){
        this(name, 0);
        System.out.println("I am in second constructor");
    }
    
    Student4(String name, int age){
        this(name, age, 0);
        System.out.println("I am in third constructor");
    }
    
    Student4(String name, int age, int rollNumber){
        this(name, age, rollNumber, "Unknown");
        System.out.println("I am in fourth constructor");
    }
    
    Student4(String name, int age, int rollNumber, String college){
        // Parameterized constructor
        this.name = name;
        this.age = age;
        this.rollNumber = rollNumber;
        this.college = college;
        System.out.println("I am in fifth constructor");
    }
    
    void markAttendance(){
        System.out.println("Attendance marked for student " + name);
    }
}
