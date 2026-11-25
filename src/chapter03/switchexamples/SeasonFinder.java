package chapter03.switchexamples;

public class SeasonFinder {
    
    static void printSeason(int month) {
        switch (month) {
            case 12, 1, 2:
                System.out.println(month + " -> Winter");
                break;
            case 3, 4, 5:
                System.out.println(month + " -> Spring");
                break;
            case 6, 7, 8:
                System.out.println(month + " -> Summer");
                break;
            case 9, 10, 11:
                System.out.println(month + " -> Autumn");
                break;
            default:
                System.out.println(month + " -> Not a month");
        }
    }
    
    public static void main(String[] args) {
        int[] months = {1, 4, 7, 10, 12, 13};
        for (int m : months) {
            printSeason(m);
        }
    }
}