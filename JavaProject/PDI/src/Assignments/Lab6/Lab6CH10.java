/*Challenge 10: Mixin Inheritance (Python) — “E-Commerce Analytics”
Goal: Use mixins to add reusable features.
Instructions:
• Class: TrackViewsMixin → provides view tracking
• Class: DiscountMixin → provides discount calculation
• Base: Product
• Derived: DigitalProduct(Product, TrackViewsMixin, DiscountMixin)
Task:
Show how mixins extend abilities without affecting inheritance hierarchy. */
public class Lab6CH10 {
    public static void main(String[] args) {
        DigitalProduct ebook = new DigitalProduct("E-Book", 20.0);
        ebook.track_view();
        ebook.track_view();
        System.out.println(ebook.getName() + " has been viewed " + ebook.getView_count() + " times.");
        System.out.println("Discounted price: $" + ebook.calculate_discounted_price(10)); // 10% discount
    }

    public static class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }

    public interface TrackViewsMixin {
        void track_view();
        int getView_count();
    }

    public interface DiscountMixin {
        double calculate_discounted_price(double discount_percentage);
    }

    public static class DigitalProduct extends Product implements TrackViewsMixin, DiscountMixin {
        private int view_count;

        public DigitalProduct(String name, double price) {
            super(name, price);
            this.view_count = 0;
        }

        @Override
        public void track_view() {
            view_count++;
        }

        @Override
        public int getView_count() {
            return view_count;
        }

        @Override
        public double calculate_discounted_price(double discount_percentage) {
            return getPrice() * (1 - discount_percentage / 100);
        }
    }
    public static class PhysicalProduct extends Product implements DiscountMixin {
        public PhysicalProduct(String name, double price) {
            super(name, price);
        }

        @Override
        public double calculate_discounted_price(double discount_percentage) {
            return getPrice() * (1 - discount_percentage / 100);
        }
    }
     
}
