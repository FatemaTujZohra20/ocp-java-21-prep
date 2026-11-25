package chapter06;

/**
 * ============================================================
 * PROJECT: Abstract Animal - Understanding Abstract Classes
 * ============================================================
 * <p>
 * OBJECTIVE:
 * This program demonstrates:
 * <p>
 * 1. Abstract classes and abstract methods.
 * 2. Concrete methods inside abstract classes.
 * 3. Inheritance using the extends keyword.
 * 4. Constructor chaining using super().
 * 5. Method overriding using @Override.
 * 6. Runtime polymorphism (Dynamic Method Dispatch).
 * 7. Encapsulation using private fields and getters/setters.
 * 8. Upcasting and downcasting.
 * 9. The instanceof operator for safe type checking.
 * <p>
 * IMPORTANT:
 * An abstract class cannot be instantiated directly.
 * However, we can create a reference of an abstract class
 * that points to an object of its concrete subclass.
 */

public class AbstractAnimal {
    
    /**
     * MAIN METHOD
     * <p>
     * Program execution starts here.
     */
    public static void main(String[] args) {
        
        // ====================================================
        // 1. CREATING A DOG OBJECT USING AN ANIMAL REFERENCE
        // ====================================================
        
        /*
         * Animal is the reference type.
         * Dog is the actual object type.
         *
         * This is called UPCASTING.
         *
         * Java automatically allows upcasting because Dog
         * inherits from Animal.
         */
        
        Animal animal = new Dog("Hachico", 3);
        
        /*
         * Although the reference type is Animal,
         * the actual object is Dog.
         *
         * Java decides which overridden method to execute
         * at runtime based on the actual object.
         */
        
        System.out.println("========== DOG INFORMATION ==========");
        
        animal.showInfo();
        
        // ====================================================
        // 2. RUNTIME POLYMORPHISM
        // ====================================================
        
        System.out.println("\n========== ANIMAL BEHAVIOURS ==========");
        
        /*
         * makeSound() is an abstract method in Animal.
         * Dog provides its own implementation.
         *
         * Therefore, Dog's makeSound() executes.
         */
        
        animal.makeSound();
        
        /*
         * sleep() is a concrete method in Animal.
         * Dog inherits it without needing to override it.
         */
        
        animal.sleep();
        
        // ====================================================
        // 3. ACCESSING CHILD-CLASS-SPECIFIC METHODS
        // ====================================================
        
        /*
         * The Animal reference cannot directly access methods
         * that exist only in Dog.
         *
         * For example:
         *
         * animal.wagTail(); // Compilation error
         *
         * Why?
         * Because wagTail() is not declared in Animal.
         *
         * We need downcasting to access Dog-specific methods.
         */
        
        System.out.println("\n========== DOWNCASTING ==========");
        
        if (animal instanceof Dog) {
            
            /*
             * DOWNCASTING:
             *
             * Converting an Animal reference into a Dog reference.
             *
             * Both references point to the same Dog object.
             * No new object is created.
             */
            
            Dog dog = (Dog) animal;
            
            // Now we can access Dog-specific methods.
            
            dog.wagTail();
            
            dog.fetch();
            
            // Accessing the getter method.
            
            System.out.println("Dog's name: " + dog.getName());
            
            // Updating the dog's name using the setter.
            
            dog.setName("Tommy");
            
            System.out.println("Updated name: " + dog.getName());
            
            // Updating the dog's age.
            
            dog.setAge(4);
            
            System.out.println("Updated age: " + dog.getAge());
            
            /*
             * The original animal reference still points
             * to the same object.
             *
             * Therefore, changes made through dog are also
             * visible through animal.
             */
            
            System.out.println("\n========== UPDATED INFORMATION ==========");
            
            animal.showInfo();
        }
        
        // ====================================================
        // 4. CREATING ANOTHER DOG OBJECT
        // ====================================================
        
        /*
         * Here, both the reference type and actual object type
         * are Dog.
         *
         * Therefore, all accessible Dog methods can be called
         * directly without downcasting.
         */
        
        System.out.println("\n========== SECOND DOG OBJECT ==========");
        
        Dog dog2 = new Dog("Bruno", 5);
        
        dog2.showInfo();
        dog2.makeSound();
        dog2.wagTail();
        dog2.sleep();
        
        System.out.println("\n========== PROGRAM FINISHED ==========");
    }
}

/**
 * ============================================================
 * ABSTRACT PARENT CLASS: Animal
 * ============================================================
 * <p>
 * Animal is an abstract class.
 * <p>
 * WHY ABSTRACT?
 * <p>
 * We want to define common properties and behaviors
 * for all animals without creating a generic Animal object.
 * <p>
 * Every animal has:
 * - A name.
 * - An age.
 * - The ability to make a sound.
 * - The ability to sleep.
 * <p>
 * Some behaviors can have a common implementation,
 * while others must be implemented differently by subclasses.
 */

abstract class Animal {
    
    // ========================================================
    // ENCAPSULATED FIELDS
    // ========================================================
    
    /*
     * private protects these fields from direct access
     * outside the Animal class.
     *
     * Subclasses can access them through getters/setters.
     */
    
    private String name;
    private int age;
    
    
    // ========================================================
    // CONSTRUCTOR
    // ========================================================
    
    /**
     * Constructor of the Animal class.
     *
     * @param name the animal's name
     * @param age  the animal's age
     * <p>
     * This constructor initializes the common properties
     * of every animal.
     */
    
    Animal(String name, int age) {
        
        this.name = name;
        this.age = age;
    }
    
    
    // ========================================================
    // ABSTRACT METHOD
    // ========================================================
    
    /**
     * Abstract method: makeSound()
     * <p>
     * It has no method body.
     * <p>
     * Every concrete subclass must provide its own
     * implementation of this method.
     */
    
    abstract void makeSound();
    
    
    // ========================================================
    // CONCRETE METHODS
    // ========================================================
    
    /**
     * sleep() is a concrete method.
     * <p>
     * It has an implementation in the parent class.
     * All subclasses can inherit and use it.
     */
    
    void sleep() {
        
        System.out.println(name + " is sleeping.");
    }
    
    
    /**
     * showInfo() displays the animal's information.
     * <p>
     * This method is also inherited by subclasses.
     */
    
    void showInfo() {
        
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
    }
    
    
    // ========================================================
    // GETTERS AND SETTERS
    // ========================================================
    
    /**
     * Getter for the name field.
     *
     * @return the animal's name
     */
    
    public String getName() {
        
        return name;
    }
    
    
    /**
     * Setter for the name field.
     *
     * @param name the new animal name
     */
    
    public void setName(String name) {
        
        this.name = name;
    }
    
    
    /**
     * Getter for the age field.
     *
     * @return the animal's age
     */
    
    public int getAge() {
        
        return age;
    }
    
    
    /**
     * Setter for the age field.
     *
     * @param age the new animal age
     */
    
    public void setAge(int age) {
        
        if (age >= 0) {
            
            this.age = age;
            
        } else {
            
            System.out.println("Age cannot be negative.");
        }
    }
}


/**
 * ============================================================
 * CHILD CLASS: Dog
 * ============================================================
 * <p>
 * Dog inherits from Animal.
 * <p>
 * Dog automatically receives accessible methods from Animal.
 * <p>
 * However, Dog must implement the abstract makeSound()
 * method because Dog is a concrete class.
 */

class Dog extends Animal {
    
    
    // ========================================================
    // CONSTRUCTOR
    // ========================================================
    
    /**
     * Dog constructor.
     *
     * @param name the dog's name
     * @param age  the dog's age
     * <p>
     * super(name, age) calls the parent Animal constructor.
     *
     * The parent constructor initializes the common fields.
     */
    
    Dog(String name, int age) {
        
        super(name, age);
    }
    
    
    // ========================================================
    // METHOD OVERRIDING
    // ========================================================
    
    /**
     * Implementation of the abstract makeSound() method.
     *
     * @Override tells the compiler that this method
     * overrides a method inherited from the parent class.
     */
    
    @Override
    void makeSound() {
        
        System.out.println(getName() + " says: Woof! Woof!");
    }
    
    
    // ========================================================
    // DOG-SPECIFIC METHODS
    // ========================================================
    
    /**
     * wagTail() is specific to Dog.
     * <p>
     * It does not exist in the Animal class.
     * <p>
     * Therefore, it cannot be called directly through
     * an Animal reference.
     */
    
    void wagTail() {
        
        System.out.println(getName() + " is wagging its tail.");
    }
    
    
    /**
     * fetch() is another Dog-specific behavior.
     */
    
    void fetch() {
        
        System.out.println(getName() + " is fetching the ball.");
    }
}
