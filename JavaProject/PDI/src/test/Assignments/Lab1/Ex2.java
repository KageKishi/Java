
/*Write a program to solve a quadratic equation */
import java.util.Scanner;

public class Ex2 {
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String args[]) {
        double root1, root2;
        double a, b, c;
        System.out.print("=".repeat(44));
        System.out.print("\n");
        System.out.printf("%32s", "Welcome to our program\n");
        System.out.println("\n'Quadratic Equation Solver ax² + bx + c = 0'");
        System.out.print("=".repeat(44));
        System.out.println("");
        a = ValidateInteger("Input a: ");
        b = ValidateInteger("Input b: ");
        c = ValidateInteger("Input c: ");
        double delta = (b * b) - (4 * a * c);
        root1 = (-b + Math.sqrt(delta)) / (2 * a);
        root2 = (-b - Math.sqrt(delta)) / (2 * a);
        System.out.print("-".repeat(50));
        System.out.println("\nRoots of this equation: " + a + "x² + " + b + "x + " + c + " are: ");
        if (delta > 0) {
            System.out.println("\nFirst Root 1: " + root1);
            System.out.println("\nSecond Root 2: " + root2);
        } else if (delta == 0) {
            System.out.println("\nFirst Root 1: " + root1);
        } else if (delta < 0) {
            System.out.println("\nFirst Root 1: " + (-b / (2 * a)) + " + " + (Math.sqrt(-delta) / (2 * a)) + "(i) ");
            System.out.println("\nSecond Root 2: " + (-b / (2 * a)) + " - " + (Math.sqrt(-delta) / (2 * a)) + "(i) ");
        }
        System.out.print("-".repeat(44));
    }

    public static int ValidateInteger(String prompt) {
        String line;
        while (true) {
            System.out.println(prompt);
            line = SC.nextLine();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("\nPlease enter a valid Integer\n");
            }
        }
    }
}
