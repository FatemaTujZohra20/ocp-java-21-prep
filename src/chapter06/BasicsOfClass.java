package chapter06;

public class BasicsOfClass {
    public static void main(String[] args) {
        
        // Creating object
        Student s1 = new Student();
        
        Student s2 = new Student("Meem", 21, 101, "BUET");
        
        s1.name = "Fatema";
        s1.age = 22;
        s1.rollNumber = 102;
        s1.college = "BUET";
        
        System.out.println("name: " + s1.name + ", age: " + s1.age +
                ", roll number: " + s1.rollNumber + ", College name: " + s1.college);
        
        System.out.println(s2);  // address of s2 Student pointed by s2 reference variable
    
    }
}

class Student{
    String name;
    int age;
    int rollNumber;
    String college;
    
    Student(){
        // Default constructor
    }
    
    Student(String name, int age, int rollNumber, String college){
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
