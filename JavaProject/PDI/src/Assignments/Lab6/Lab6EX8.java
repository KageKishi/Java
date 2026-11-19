/*8. Inheritance + Polymorphism + Data Structures — “E-commerce Product Catalog”
Use Case: Online store with several product types.
Goal: Work with lists of parent-class types containing child objects.
Instructions:
• Base class Product: name, price
• Derived:
o Electronics → warranty
o Clothing → size
o Book → author
• Add method get_info() in each class (overridden).
Task:
Create a product list containing all types and print info using polymorphism */

import java.util.ArrayList;
import java.util.List;

public class Lab6EX8 {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();

        productList.add(new Electronics("Smartphone", 699.99, "2 years"));
        productList.add(new Clothing("T-Shirt", 19.99, "M"));
        productList.add(new Book("The Great Gatsby", 10.99, "F. Scott Fitzgerald"));

        for (Product product : productList) {
            System.out.println(product.get_info());
        }
    }

    public static abstract class Product {
        protected String name;
        protected double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public abstract String get_info();
    }

    public static class Electronics extends Product {
        private String warranty;

        public Electronics(String name, double price, String warranty) {
            super(name, price);
            this.warranty = warranty;
        }

        @Override
        public String get_info() {
            return "Electronics: " + name + ", Price: $" + price + ", Warranty: " + warranty;
        }
    }

    public static class Clothing extends Product {
        private String size;

        public Clothing(String name, double price, String size) {
            super(name, price);
            this.size = size;
        }

        @Override
        public String get_info() {
            return "Clothing: " + name + ", Price: $" + price + ", Size: " + size;
        }
    }

    public static class Book extends Product {
        private String author;

        public Book(String name, double price, String author) {
            super(name, price);
            this.author = author;
        }

        @Override
        public String get_info() {
            return "Book: " + name + ", Price: $" + price + ", Author: " + author;
        }
    }
}
