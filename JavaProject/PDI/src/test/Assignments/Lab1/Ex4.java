
/*Write a program that can check if the given input date
(yyyy-mm-dd) is valid or invalid.*/
import java.util.Arrays;
import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        String[] trims = new String[3];
        int[] date = new int[3];
        boolean Validinput = false;
        int[] MonthsWith31days = { 1, 3, 5, 7, 8, 10, 12 };
        while (!Validinput) {
            System.out.println("Write your yyyy-mm-dd: ");
            line = sc.nextLine();
            trims = line.trim().split("-", -1);
            Validinput = trims.length == 3;
            if (!line.trim().matches("\\d{4}-\\d{2}-\\d{2}")) {
                Validinput = false;
            }
            if (Validinput) {
                for (int i = 0; i < 3; i++) {
                    try {
                        date[i] = Integer.parseInt(trims[i]);
                    } catch (NumberFormatException e) {
                        Validinput = false;
                        System.out.println("Output: invalid\n");
                    }
                }
            }
            if (Validinput) {
                boolean LeapYear = false;
                boolean Days31 = false;
                for (int numbers : date) {
                    if (numbers <= 0) {
                        Validinput = false;
                    }
                }
                if ((date[0] % 4 == 0 && date[0] % 100 != 0) || date[0] % 400 == 0) {
                    LeapYear = true;
                }
                if (Arrays.stream(MonthsWith31days).anyMatch(n -> n == date[1])) {
                    Days31 = true;
                }
                if (date[1] > 12 || (date[2] > 29 && date[1] == 2)) {
                    Validinput = false;
                    continue;
                }
                if (date[1] == 2 && !LeapYear && date[2] == 29) {
                    Validinput = false;
                    continue;
                }
                if ((date[2] == 31 && !Days31) || date[2] > 31) {
                    Validinput = false;
                }
            }
            if (Validinput) {
                System.out.println("Input: Valid");
            } else {
                System.out.println("Output: Invalid");
            }
        }
        sc.close();
    }

}
