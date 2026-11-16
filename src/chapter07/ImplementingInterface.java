package chapter07;

public class ImplementingInterface {
    public static void main(String[] args) {
        Car3 car = new FuelCar();
        car.start();
        car.accelerate();
        car.brake();
    }
}

interface Car3{
    // By default, these methods are public,
    // so while calling them public is must
    void start();
    void accelerate();
    void brake();
}

class FuelCar implements Car3 {
    @Override
    public void start(){
        System.out.println("Fuel car is starting");
    }
    
    @Override
    public void accelerate(){
        System.out.println("Fuel car is accelerating");
    }
    
    @Override
    public void brake(){
        System.out.println("Fuel car is braking");
    }
}

class ElectricCar implements Car3{
    @Override
    public void start(){
        System.out.println("Electric car is starting");
    }
    
    @Override
    public void accelerate(){
        System.out.println("Electric car is accelerating");
    }
    
    @Override
    public void brake(){
        System.out.println("Electric car is braking");
    }
}
