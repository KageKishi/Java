
/*Write a program that can ask users to input 5 numbers.
The program processes the input from the user and find out the
minimum and maximum numbers.*/
import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        String[] inputSize;
        String line;
        boolean validInput;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Enter 5 numbers: ");
            line = sc.nextLine();
            inputSize = line.trim().split("\\s+");
            validInput = (inputSize.length == 5);
            if (validInput) {
                for (int i = 0; i < arr.length; i++) {
                    try {
                        arr[i] = Integer.parseInt(inputSize[i]);
                    } catch (NumberFormatException e) {
                        validInput = false;
                        System.out.println("\nPlease write 5 numbers");
                        break;
                    }
                }

                if (validInput) {
                    int min = arr[0];
                    int max = arr[0];
                    System.out.println("Among all the numbers (");
                    for (int i = 0; i < 5; i++) {
                        min = Math.min(min, arr[i]);
                        max = Math.max(max, arr[i]);
                        if (i != 4) {
                            System.out.print(arr[i] + ",");
                        }
                    }
                    System.out.println(" and " + arr[4] + "),");
                    System.out.println("Minimum: " + min);
                    System.out.println("Maximum: " + max);
                }
            } else {
                System.out.println("\nPlease write 5 numbers");
            }
        } while (!validInput);
        sc.close();
    }
}
