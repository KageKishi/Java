
/*Implement a calculator that supports basic
arithmetic operations (+, -, *, /, sum from 1 to n)
using a menu-driven approach. */
import java.util.Scanner;

public class Lab5EX2 {
    public interface Calculator {
        double calculate(double a, double b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator add = (a, b) -> a + b;
        Calculator subtract = (a, b) -> a - b;
        Calculator multiply = (a, b) -> a * b;
        Calculator divide = (a, b) -> a / b;
        int choice = 0;
        while (choice != 6) {
            choice = utilities.ValidateInteger(
                    "Enter Choice:\n1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n5. Sum from 1 to n\n6. Exit",
                    sc);
            double a, b;
            switch (choice) {
                case 1:
                    a = utilities.ValidateDouble("Enter first number: ", sc);
                    b = utilities.ValidateDouble("Enter second number: ", sc);
                    System.out.println("Result: " + add.calculate(a, b));
                    break;
                case 2:
                    a = utilities.ValidateDouble("Enter first number: ", sc);
                    b = utilities.ValidateDouble("Enter second number: ", sc);
                    System.out.println("Result: " + subtract.calculate(a, b));
                    break;
                case 3:
                    a = utilities.ValidateDouble("Enter first number: ", sc);
                    b = utilities.ValidateDouble("Enter second number: ", sc);
                    System.out.println("Result: " + multiply.calculate(a, b));
                    break;
                case 4:
                    a = utilities.ValidateDouble("Enter first number: ", sc);
                    b = utilities.ValidateDouble("Enter second number: ", sc);
                    if (b == 0) {
                        System.out.println("Error: Division by zero is not allowed.");
                    } else {
                        System.out.println("Result: " + divide.calculate(a, b));
                    }
                    break;
                case 5:
                    int n = utilities.ValidateInteger("Enter a positive integer n to calculate the sum from 1 to n: ",
                            sc);
                    if (n < 1) {
                        System.out.println("Error: Please enter a positive integer greater than 0.");
                    } else {
                        int sum = 0;
                        for (int i = 1; i <= n; i++) {
                            sum += i;
                        }
                        System.out.println("The sum from 1 to " + n + " is: " + sum);
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
            choice = utilities.ValidateInteger(
                    "Enter Choice:\n1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n5. Sum from 1 to n\n6. Exit",
                    sc);
        }
    }

}
