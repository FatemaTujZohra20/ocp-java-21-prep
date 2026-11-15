package chapter06;

public class BasicsOfFinalKeyword {
    public static void main(String[] args) {
        Random r1 = new Random();
        System.out.println(r1.PI);
        
        // Definition and Declaration allowed only once
        final int x;
        x = 4;
        System.out.println(x);
    }
}


class Random{
    final double PI;
    
    Random(){
        this.PI = 3.14;
    }
}