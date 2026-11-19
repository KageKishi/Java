/*Challenge 8: Polymorphic Data Storage — “Rental System”
Goal: Use inheritance to store many object types in a single list.
Instructions:
• Base: RentalItem
• Child:
o CarRental
o BikeRental
o ToolRental
o CameraRental
Task:
Store all rentals in one list and compute rental costs via overridden methods. */
public class Lab6CH8 {
    public static void main(String[] args) {
        RentalItem[] rentals = new RentalItem[4];
        rentals[0] = new CarRental(50, 3); // $50/day for 3 days
        rentals[1] = new BikeRental(15, 5); // $15/day for 5 days
        rentals[2] = new ToolRental(20, 2); // $20/day for 2 days
        rentals[3] = new CameraRental(30, 4); // $30/day for 4 days

        double totalCost = 0;
        for (RentalItem rental : rentals) {
            totalCost += rental.calculate_cost();
        }

        System.out.println("Total rental cost: $" + totalCost);
    }
    public static abstract class RentalItem {
        protected double dailyRate;
        protected int daysRented;

        public RentalItem(double dailyRate, int daysRented) {
            this.dailyRate = dailyRate;
            this.daysRented = daysRented;
        }

        public abstract double calculate_cost();
    }
    public static class CarRental extends RentalItem {
        public CarRental(double dailyRate, int daysRented) {
            super(dailyRate, daysRented);
        }

        @Override
        public double calculate_cost() {
            return dailyRate * daysRented;
        }
    }
    public static class BikeRental extends RentalItem {
        public BikeRental(double dailyRate, int daysRented) {
            super(dailyRate, daysRented);
        }

        @Override
        public double calculate_cost() {
            return dailyRate * daysRented;
        }
    }
    public static class ToolRental extends RentalItem {
        public ToolRental(double dailyRate, int daysRented) {
            super(dailyRate, daysRented);
        }

        @Override
        public double calculate_cost() {
            return dailyRate * daysRented;
        }
    }
    public static class CameraRental extends RentalItem {
        public CameraRental(double dailyRate, int daysRented) {
            super(dailyRate, daysRented);
        }

        @Override
        public double calculate_cost() {
            return dailyRate * daysRented;
        }
    }
}
