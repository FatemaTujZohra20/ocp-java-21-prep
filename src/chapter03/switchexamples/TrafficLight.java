package chapter03.switchexamples;

public class TrafficLight {
    public static void main(String[] args) {
        String light = "red";
        
        switch (light){
            case "green":
                System.out.println("Go");
                break;
            case "yellow":
                System.out.println("Slow down");
                break;
            case "red":
                System.out.println("Stop");
                break;
            default:
                System.out.println("Broken light");
        }
    }
}
