/*Create a class Book with attributes like title, author, and
price. Define 2 constructors (one constructor override the
default and set default values to data while another
constructor set info of a book).
Include a method to display the book's details. */
public class Lab5EX3 {
    private String title;
    private String author;
    private double price;


    public Lab5EX3() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
    }


    public Lab5EX3(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
    }
    public static void main(String[] args) {
        Lab5EX3 defaultBook = new Lab5EX3();
        System.out.println("Default Book Details:");
        defaultBook.displayDetails();

        System.out.println();

        Lab5EX3 customBook = new Lab5EX3("The Great Gatsby", "F. Scott Fitzgerald", 10.99);
        System.out.println("Custom Book Details:");
        customBook.displayDetails();
    }
}
