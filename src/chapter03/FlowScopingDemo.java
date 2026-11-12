package chapter03;

/**
 * Flow scoping — full examples you can run.
 * Compile and run:  javac FlowScopingDemo.java  &&  java FlowScopingDemo
 * <p>
 * The question for every line that uses a pattern variable:
 *   "Can an object that FAILED the instanceof check reach this line?"
 *   Yes -> out of scope (does not compile).   No -> in scope (compiles).
 */
public class FlowScopingDemo {
    
    // ------------------------------------------------------------
    // Example 1: inside the if  (in scope)  vs  else  (out of scope)
    // ------------------------------------------------------------
    static String describe(Object obj) {
        if (obj instanceof String text) {
            return "A String with " + text.length() + " letters";   // only Strings get here
        } else {
            // return text.length() + "";   // DNC: non-Strings come here, text is empty
            return "Not a String";
        }
    }
    
    // ------------------------------------------------------------
    // Example 2: && — the right side runs only when the check passed
    // ------------------------------------------------------------
    static void printBigIntegers(Number number) {
        if (number instanceof Integer data && data > 10) {           // data usable on the right of &&
            System.out.println("  Big Integer: " + data);
        }
        // if (number instanceof Integer data || data > 10) { }      // DNC: right of || runs only when the check FAILED
    }
    
    // ------------------------------------------------------------
    // Example 3: early return — failed objects leave the method
    // ------------------------------------------------------------
    static int doubleIt(Number number) {
        if (!(number instanceof Integer data)) {
            return -1;                                   // every non-Integer leaves here
        }
        return data * 2;                                 // only Integers reach this line -> in scope
    }
    
    // Same method WITHOUT the return: does not compile
    // static int doubleItBroken(Number number) {
    //     if (!(number instanceof Integer data)) {
    //         System.out.println("not an Integer");     // non-Integers print...
    //     }
    //     return data * 2;                              // DNC: ...and still walk to here
    // }
    
    // ------------------------------------------------------------
    // Example 4: throw works exactly like return
    // ------------------------------------------------------------
    static String shout(Object obj) {
        if (!(obj instanceof String text)) {
            throw new IllegalArgumentException("Need a String, got " + obj);
        }
        return text.toUpperCase() + "!";                 // only Strings get here
    }
    
    // ------------------------------------------------------------
    // Example 5: the else of a NEGATED check = the match succeeded
    // ------------------------------------------------------------
    static String temperature(Object obj) {
        if (!(obj instanceof Double degrees)) {
            return "No temperature";                     // failed objects come here
        } else {
            return degrees + " degrees C";                      // "not a Double" = a Double -> in scope
        }
    }
    
    // ------------------------------------------------------------
    // Example 6: negated check combined with ||
    // ------------------------------------------------------------
    static String cleanName(Object obj) {
        // Right side of || runs only when the LEFT side is false,
        // left side false = "it IS a String" -> name in scope there.
        if (!(obj instanceof String name) || name.isBlank()) {
            return "(no name)";
        }
        return name.trim();                              // here: it is a String AND not blank
    }
    
    // ------------------------------------------------------------
    // Example 7: ternary operator ? :  (same idea as if/else)
    // ------------------------------------------------------------
    static int lengthOrZero(Object obj) {
        return obj instanceof String s ? s.length() : 0;    // s only used on the "true" side
        // return obj instanceof String s ? 0 : s.length(); // DNC: s used on the "false" side
    }
    
    // ------------------------------------------------------------
    // Example 8: the next line after a brace-less if
    // ------------------------------------------------------------
    static void printTwice(Number number) {
        if (number instanceof Integer data)
            System.out.println("  First: " + data);      // only Integers
        // System.out.println("Second: " + data);        // DNC: Doubles skip the if and arrive here too
    }
    
    // ------------------------------------------------------------
    // Example 9: a realistic loop over mixed objects
    // ------------------------------------------------------------
    static void processOrder(Object[] items) {
        double total = 0;
        for (Object item : items) {
            if (!(item instanceof Number price)) {
                System.out.println("  Skipping non-price: " + item);
                continue;                                // failed objects jump to the next item
            }
            total += price.doubleValue();                // only Numbers reach here -> in scope
        }
        System.out.println("  Total: " + total);
    }
    
    public static void main(String[] args) {
        System.out.println("Example 1:");
        System.out.println("  " + describe("Java"));
        System.out.println("  " + describe(42));
        
        System.out.println();
        
        System.out.println("Example 2:");
        printBigIntegers(25);
        printBigIntegers(5);          // Integer but not > 10 -> nothing printed
        printBigIntegers(25.5);       // Double -> nothing printed
        
        System.out.println();
        
        System.out.println("Example 3:");
        System.out.println("  " + doubleIt(21));
        System.out.println("  " + doubleIt(2.5));
        
        System.out.println();
        
        System.out.println("Example 4:");
        System.out.println("  " + shout("hello"));
        try {
            shout(99);
        } catch (IllegalArgumentException e) {
            System.out.println("  Caught: " + e.getMessage());
        }
        
        System.out.println();
        
        System.out.println("Example 5:");
        System.out.println("  " + temperature(21.5));
        System.out.println("  " + temperature("hot"));
        
        System.out.println();
        
        System.out.println("Example 6:");
        System.out.println("  " + cleanName("  Ada  "));
        System.out.println("  " + cleanName("   "));
        System.out.println("  " + cleanName(7));
        
        System.out.println();
        
        System.out.println("Example 7:");
        System.out.println("  " + lengthOrZero("flow"));
        System.out.println("  " + lengthOrZero(3.14));
        
        System.out.println();
        
        System.out.println("Example 8:");
        printTwice(10);
        printTwice(1.5);              // Double -> nothing printed
        
        System.out.println();
        
        System.out.println("Example 9:");
        processOrder(new Object[] { 10, "coupon", 2.5, null, 7L });
    }
}
