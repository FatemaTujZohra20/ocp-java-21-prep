package chapter06;

public class ChainingOfConstructors {
    public static void main(String[] args) {
        
        // Chaining of Constructors
        
        Student4 s1 = new Student4();
        Student4 s2 = new Student4("Meem");
        Student4 s3 = new Student4("Fatema", 22);
        Student4 s4 = new Student4("Zohra", 21, 103);
        Student4 s5 = new Student4("Tuj", 20, 104, "IIT");
        
        System.out.println(s3.name);
        
        System.out.println(s1.name);
        
    }
}

// Chaining of Constructors
class Student3{
    String name;
    int age;
    int rollNumber;
    String college;
    
    Student3(){
        // Default constructor
        
//        this.name = "Unknown";
//        this.age = 0;
//        this.rollNumber = 0;
//        this.college = "Unknown";
        
        // Default constructor after Constructor Chaining
        // We can simply write the following
        this("Unknown", 21, 102, "Unknown");
    }
    
    // Chaining of Constructors
    
    Student3(String name){
        this(name, 0, 0, "Unknown");
    }
    
    Student3(String name, int age){
        this(name, age, 0, "Unknown");
    }
    
    Student3(String name, int age, int rollNumber){
        this(name, age, rollNumber, "Unknown");
    }
    
    Student3(String name, int age, int rollNumber, String college){
        // Parameterized constructor
        this.name = name;
        this.age = age;
        this.rollNumber = rollNumber;
        this.college = college;
    }
    
    void markAttendance(){
        System.out.println("Attendance marked for student " + name);
    }
}