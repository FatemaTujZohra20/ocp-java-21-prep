package chapter03;

public class ShowDemoPatternMatching {
    
    static void show(Number box) {
        System.out.println("show(" + box + ") called");
        if (!(box instanceof Integer data)) {   // line 1: is it NOT an Integer?
            System.out.println("  -> not an Integer, leaving with return");
            return;                             // line 2: Losers leave here
        }                                       // line 3
        System.out.println("  -> data = " + data);          // line 4: only Integers get here
        System.out.println("  -> data * 2 = " + (data * 2));
        System.out.println("  -> done");                     // line 5
    }
    
    public static void main(String[] args) {
        show(5);       // Integer -> Winner
        show(5.5);     // Double  -> Loser
        show(7L);      // Long    -> Loser (a Number, but not an Integer)
        show(null);    // null    -> Loser (null instanceof is always false)
        show(-3);      // Integer -> Winner
        System.out.println("back in main, program finished");
    }
}
