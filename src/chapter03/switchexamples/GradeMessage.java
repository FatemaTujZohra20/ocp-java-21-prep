package chapter03.switchexamples;

public class GradeMessage {
    public static void main(String[] args) {
        char grade = 'B';
        
        switch (grade){
            case 'A':
                System.out.println("Excellent!");
                break;
            case 'B':
                System.out.println("Good Job!");
                break;
            case 'C':
                System.out.println("You passed");
                break;
            default:
                System.out.println("Keep trying");
        }
    }
}
