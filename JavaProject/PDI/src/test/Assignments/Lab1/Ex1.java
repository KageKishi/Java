
/*Ask a user for a number, say n. Display all sequence numbers from
1000 to n. Find the sum and average of these numbers and display
the result on screen. Note: Add some input validation. */
import java.util.Scanner;

public class Ex1 {
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String args[]) {
        int number;
        number = ValidateInteger("Please enter a number: ");
        int sum = 0;
        for (int i = 1000; i >= number; i--) {
            System.out.print(i + " ");
            sum += i;
        }
        int average = sum / (1001 - number);
        System.out.println("\nAverage is: " + average + "\nSum is: " + sum);
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
