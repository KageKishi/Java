/*1. Basic Inheritance — “Vehicle & Car”
Use Case: A transport company wants a common structure for different vehicles.
Goal: Understand simple inheritance.
Instructions:
• Create a base class Vehicle with:
o properties: brand, year
o method: start()
• Create a derived class Car that inherits from Vehicle.
• Add car-specific property: num_doors.
• Add method: honk().
Task:
Create objects of both classes and call their methods to show that Car has access to Vehicle methods. */
public class Lab6EX1 {
    public static void main(String[] args) {
        
        Vehicle vehicle = new Vehicle("Toyota", 2020);
        vehicle.start(); 

        
        Car car = new Car("Honda", 2021, 4);
        car.start(); 
        car.honk();  
    }
    public static class Vehicle {
        private String brand;
        private int year;

        public Vehicle(String brand, int year) {
            this.brand = brand;
            this.year = year;
        }

        public void start() {
            System.out.println(brand + " vehicle from " + year + " is starting.");
        }
    }
    public static class Car extends Vehicle {
        private int num_doors;

        public Car(String brand, int year, int num_doors) {
            super(brand, year); // Call the constructor of the base class
            this.num_doors = num_doors;
        }

        public void honk() {
            System.out.println("Car is honking! It has " + num_doors + " doors.");
        }
    }   
}