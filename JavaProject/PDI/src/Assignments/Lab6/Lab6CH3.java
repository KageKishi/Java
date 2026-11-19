/*Challenge 3: Abstract Classes + Interface Mix — “Logistics Services”
Goal: Combine interface + abstract parent class.
Instructions:
• Interface: Trackable → track()
• Abstract class: DeliveryService → calculate_eta()
• Derived:
o CourierService
o DroneDelivery
o CargoTruck
Task:
Ensure each class provides tracking info and its own ETA calculation. */
public class Lab6CH3 {
    public static void main(String[] args) {
        DeliveryService courier = new CourierService();
        DeliveryService drone = new DroneDelivery();
        DeliveryService cargoTruck = new CargoTruck();

        System.out.println("Courier ETA: " + courier.calculate_eta() + " hours");
        System.out.println("Drone ETA: " + drone.calculate_eta() + " hours");
        System.out.println("Cargo Truck ETA: " + cargoTruck.calculate_eta() + " hours");

        ((Trackable) courier).track();
        ((Trackable) drone).track();
        ((Trackable) cargoTruck).track();
    }  
    public interface Trackable {
        void track();
    }
    public static abstract class DeliveryService {
        public abstract double calculate_eta();
    }
    public static class CourierService extends DeliveryService implements Trackable {
        @Override
        public double calculate_eta() {
            return 2.0; 
        }
        @Override
        public void track() {
            System.out.println("Courier Service: Tracking package...");
        }
    }
    public static class DroneDelivery extends DeliveryService implements Trackable {
        @Override
        public double calculate_eta() {
            return 1.0; 
        }
        @Override
        public void track() {
            System.out.println("Drone Delivery: Tracking package...");
        }
    }
    public static class CargoTruck extends DeliveryService implements Trackable {
        @Override
        public double calculate_eta() {
            return 3.0; 
        }
        @Override
        public void track() {
            System.out.println("Cargo Truck: Tracking package...");
        }
    }
}
