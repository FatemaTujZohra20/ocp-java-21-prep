package chapter06;

public class AbstractAnimal2 {
    public static void main(String[] args) {
        Animal2 animal = new Dog2("Hachigo", 4);
        
        System.out.println("========== DOG INFORMATION ==========");
        animal.showInfo();
        
        System.out.println("\n========== ANIMAL BEHAVIOURS ==========");
        animal.makeSound();
        animal.sleep();
        
        System.out.println("\n========== DOWNCASTING ==========");
        
        if(animal instanceof Dog2) {
            Dog2 dog = (Dog2) animal;
            
            dog.wagTail();
            dog.fetch();
            
            System.out.println("Dog's name: " + dog.getName());
            
            dog.setName("Tommy");
            System.out.println("Updated name: " + dog.getName());
            
            dog.setAge(4);
            System.out.println("Updated age: " + dog.getAge());
            
            System.out.println("\n========== UPDATED INFORMATION ==========");
            
            animal.showInfo();
            
        }
            System.out.println("\n========== SECOND DOG OBJECT ==========");
            
            Dog2 dog2 = new Dog2("Bruno", 5);
            
            dog2.showInfo();
            dog2.makeSound();
            dog2.wagTail();
            dog2.sleep();
            
            // ====================================================
            // 5. UPCASTING: IMPLICIT VS EXPLICIT
            // ====================================================
            
            /*
             * Upcasting is always safe, so the cast is optional.
             * Both lines below do exactly the same thing.
             */
            
            System.out.println("\n========== UPCASTING: IMPLICIT VS EXPLICIT ==========");
            
            Dog2 dog3 = new Dog2("Rocky", 2);
            
            Animal2 a1 = dog3;  // Implicit upcasting
            Animal2 a2 = (Animal2) dog3;   // explicit upcasting (allowed, but not needed)
            
            // Upcasting does not create a new object
            
            System.out.println("Same object? " + (a1 == dog3));
            
            a2.makeSound();              // still runs Dog's makeSound()
            
            // a1.fetch();               // Compilation error: Animal has no fetch()
            
            
            
            // ====================================================
            // 6. UPCASTING IN METHOD PARAMETERS
            // ====================================================
            
            System.out.println("\n========== UPCASTING IN METHOD PARAMETERS ==========");
            
            Animal2.letAnimalSpeak(dog3);                 // Dog -> Animal
            Animal2.letAnimalSpeak(new Cat("Kitty", 1));  // Cat -> Animal
            
            
            // ====================================================
            // 7. UPCASTING IN ARRAYS
            // ====================================================
            
            /*
             * One Animal array can hold Dogs and Cats together.
             * Each element is upcast to Animal when stored.
             */
            
            System.out.println("\n========== UPCASTING IN ARRAYS ==========");
            
            Animal2[] animals = {
                    new Dog2("Max", 4),
                    new Cat("Luna", 2),
                    new Dog2("Charlie", 6)
            };
            
            for (Animal2 a : animals) {
                
                a.makeSound();   // runtime polymorphism decides Woof or Meow
            }
            
            
            // ====================================================
            // 8. UPCASTING IN RETURN TYPES
            // ====================================================
            
            System.out.println("\n========== UPCASTING IN RETURN TYPES ==========");
            
            Animal2 pet = Animal2.adoptAnimal("cat");
            
            pet.showInfo();
            pet.makeSound();
            
            
            // ====================================================
            // 9. SAFE DOWNCASTING WITH PATTERN MATCHING (Java 16+)
            // ====================================================
            
            /*
             * instanceof with a pattern variable checks the type
             * and downcasts in one step.
             */
            
            System.out.println("\n========== SAFE DOWNCASTING WITH PATTERN MATCHING ==========");
            
            for (Animal2 a : animals) {
                
                if (a instanceof Dog2 d) {
                    
                    d.fetch();
                    
                } else if (a instanceof Cat c) {
                    
                    c.climbTree();
                }
            }
            
            /*
             * Downcasting to the wrong type compiles,
             * but fails at runtime:
             *
             * Animal someAnimal = new Cat("Tom", 3);
             * Dog wrongDog = (Dog) someAnimal;  // ClassCastException
             */
            
            Animal2 someAnimal = new Cat("Tom", 3);
            
            if (!(someAnimal instanceof Dog2)) {
                
                System.out.println(someAnimal.getName() + " is not a Dog, so it cannot be downcast to Dog.");
            }
            
            
            
            System.out.println("\n========== PROGRAM FINISHED ==========");
        
        
    }
}

abstract class Animal2 {
    private String name;
    private int age;
    
    Animal2(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    abstract void makeSound();
    
    void sleep() {
        System.out.println(name + " is sleeping");
    }
    
    void showInfo() {
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Age cannot be negative");
        }
    }
    
    /**
     * UPCASTING IN METHOD PARAMETERS
     * <p>
     * This method accepts any Animal.
     * When a Dog or Cat is passed in, it is upcast to Animal.
     */
    
    static void letAnimalSpeak(Animal2 animal){
        animal.makeSound();
    }
    
    /**
     * UPCASTING IN RETURN TYPES
     * <p>
     * The return type is Animal, but the actual object
     * returned is a Dog or a Cat.
     */
    static Animal2 adoptAnimal(String type){
        if(type.equals("dog")){
            return new Dog2("Bruno", 5);  // Dog upcast to Animal2
        }
        
        return new Cat("Tommy", 4);   // Cat upcast to Animal2
    }
}


class Dog2 extends Animal2 {
    Dog2(String name, int age) {
        super(name, age);
    }
    
    @Override
    void makeSound() {
        System.out.println(getName() + " says: Woof! Woof!");
    }
    
    void wagTail() {
        System.out.println(getName() + " is wagging its tail");
    }
    
    void fetch(){
        System.out.println(getName() + " is fetching the ball.");
    }
}

/**
 * ============================================================
 * CHILD CLASS: Cat
 * ============================================================
 * <p>
 * A second subclass of Animal, so we can store different
 * kinds of animals behind the same Animal reference.
 */

class Cat extends Animal2{
    Cat(String name, int age){
        super(name, age);
    }
    
    @Override
    void makeSound() {
        System.out.println(getName() + " says: Meow!");
    }
    
    // Cat-specific method, not available through an Animal reference
    void climbTree(){
        System.out.println(getName() + " is climbing a tree.");
    }
}