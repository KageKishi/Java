/*9. Advanced Real-World Project — “Transportation System with Pricing Rules”
Use Case: A city transportation app calculates fares for different transport modes.
Goal: Use inheritance, overriding, polymorphism, abstract classes, and real logic.
Instructions:
• Abstract class: Transport
o property: distance
o abstract method: calculate_fare()
• Derived:
o BusTransport → fare = distance × 1.5
o MetroTransport → fare = base 10 + (distance × 2)
o TaxiTransport → starting fee 20 + distance × 5
• Add method: display_fare()
Task:
Create a list of multiple transport types with various distances and show each fare computed using the
overridden methods */
import java.util.ArrayList;
import java.util.List;
public class Lab6EX9 {
    public static void main(String[] args) {
        List<Transport> transportList = new ArrayList<>();

        transportList.add(new BusTransport(10));
        transportList.add(new MetroTransport(15));
        transportList.add(new TaxiTransport(8));

        for (Transport transport : transportList) {
            transport.display_fare();
        }
    }

    public static abstract class Transport {
        protected double distance;

        public Transport(double distance) {
            this.distance = distance;
        }

        public abstract double calculate_fare();

        public void display_fare() {
            System.out.println("Distance: " + distance + " km, Fare: $" + calculate_fare());
        }
    }

    public static class BusTransport extends Transport {
        public BusTransport(double distance) {
            super(distance);
        }

        @Override
        public double calculate_fare() {
            return distance * 1.5;
        }
    }

    public static class MetroTransport extends Transport {
        public MetroTransport(double distance) {
            super(distance);
        }

        @Override
        public double calculate_fare() {
            return 10 + (distance * 2);
        }
    }

    public static class TaxiTransport extends Transport {
        public TaxiTransport(double distance) {
            super(distance);
        }

        @Override
        public double calculate_fare() {
            return 20 + (distance * 5);
        }
    }
}
