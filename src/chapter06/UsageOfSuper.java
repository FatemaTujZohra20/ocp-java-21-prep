package chapter06;

public class UsageOfSuper {
    public static void main(String[] args) {
    
        EngineeringStudent es2 = new EngineeringStudent("Meem", 21, 103, "IIT");
        es2.print();
    }
}

class OldStudent{
    String name;
    int age;
    int rollNo;
    
    OldStudent(){
    }
    
    OldStudent(String name,int age,int rollNo){
        this.name = name;
        this.age = age;
        this.rollNo = rollNo;
    }
    
    void print(){
        System.out.println(name + " , " + age + " , " + rollNo);
    }
}

class EngineeringStudent extends OldStudent{
    String college;
    
    EngineeringStudent(String name,int age,int rollNo, String college){
        super(name, age, rollNo);
        this.college = college;
    }
    
    void print(){
        super.print();
        System.out.println(college);
    }
}
