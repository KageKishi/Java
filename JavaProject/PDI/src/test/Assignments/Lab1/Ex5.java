
/*Write a program that can display all prime numbers from 2 to n,
where n is an input number by user. */
import java.util.Scanner;

public class Ex5 {
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        int number = ValidateInteger("Input number: ");
        printPrimes(number);
    }

    public static int ValidateInteger(String prompt) {
        String line;
        int number;
        while (true) {
            System.out.println(prompt);
            line = SC.nextLine();
            try {
                number = Integer.parseInt(line);
                if(number < 2){
                    System.out.println("Number is too small");
                }else return number;
            } catch (NumberFormatException e) {
                System.out.println("\nPlease enter a valid Integer\n");
            }
        }
    }

    public static void printPrimes(int limit) {
        for (int num = 2; num <= limit; num++) {
            boolean isPrime = true;

            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.print(num + " ");
            }
        }
    }
}
