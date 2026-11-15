package chapter06;

public class BasicsOfStaticKeyword {
    public static void main(String[] args) {
        Student5 s1 = new Student5("Meem", 23, 101);
        Student5 s2 = new Student5("Lily", 22, 102);
        
        // Student5.college = "IIT G";
        
        System.out.println(s1.name + " , " + s2.age + " , " + s1.rollNumber + " , " + Student5.college);
        System.out.println(s1.name + " , " + s2.age + " , " + s2.rollNumber + " , " + Student5.college);
    }
}

class Student5{
    String name;
    int age;
    int rollNumber;
    static String college;
    static int grade;
    
    Student5(String name, int age, int rollNumber){
        this.name = name;
        this.age = age;
        this.rollNumber = rollNumber;
    }
    
    // Static block
    static{
        college = "IIT G";
        grade = 10;
    }
}
