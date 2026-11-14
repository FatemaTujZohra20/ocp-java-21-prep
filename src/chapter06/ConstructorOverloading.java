package chapter06;

public class ConstructorOverloading {
    public static void main(String[] args) {
        // Constructor Overloading
        
        Student2 s1 = new Student2();
        Student2 s2 = new Student2("Meem");
        Student2 s3 = new Student2("Fatema", 22);
        Student2 s4 = new Student2("Zohra", 21, 103);
        Student2 s5 = new Student2("Tuj", 20, 104, "IIT");
        
    }
}


class Student2{
    String name;
    int age;
    int rollNumber;
    String college;
    
    Student2(){
        // Default constructor
    }
    
    Student2(String name){
        this.name = name;
    }
    
    Student2(String name, int age){
        this.name = name;
        this.age = age;
    }
    
    Student2(String name, int age, int rollNumber){
        this.name = name;
        this.age = age;
        this.rollNumber = rollNumber;
    }
    
    Student2(String name, int age, int rollNumber, String college){
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