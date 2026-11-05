import java.util.Scanner;

public class utilies {
    private static final Scanner sc = new Scanner(System.in);

    public static int ValidateInteger(String prompt) {
        return ValidateInteger(prompt, sc);
    }

    public static int ValidateInteger(String prompt, Scanner scanner) {
        String line;
        while (true) {
            System.out.println(prompt);
            line = scanner.nextLine();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("\nPlease enter a valid Integer\n");
            }
        }
    }

    public static double ValidateDouble(String prompt) {
        return ValidateDouble(prompt, sc);
    }

    public static double ValidateDouble(String prompt, Scanner scanner) {
        String line;
        while (true) {
            System.out.println(prompt);
            line = scanner.nextLine();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("\nPlease enter a valid number\n");
            }
        }
    }

    public static double getPositiveAmount(String prompt) {
        double amount;
        do {
            amount = utilies.ValidateDouble(prompt);
            if (amount <= 0) {
                System.out.println("Amount must be greater than zero");
            }
        } while (amount <= 0);
        return amount;
    }
    public static String StringValidateInteger(String prompt, Scanner scanner) {
        String line;
        while (true) {
            System.out.println(prompt);
            long number = 0;
            line = scanner.nextLine();
            try {
                number = Long.parseLong(line);
                return Long.toString(number);
            } catch (NumberFormatException e) {
                System.out.println("\nPlease enter a valid Integer\n");
            }
        }
    }
}
