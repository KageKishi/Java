
/*Write a program that prompt users for inputting scores of 4
subjects for Math, English, Physics, and Programming.
a. Which courses the students got max score, min score?
b. What are the average score of this student */
import java.util.ArrayList;
import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        int[] arr = new int[4];
        String[] inputSize;
        String line;
        boolean validInput;
        String[] subjects = {
                "Math", "English", "Physics", "Programming" };
        int max = 0, min = 0;
        ArrayList<String> MaxScoreSubs = new ArrayList<>();
        ArrayList<String> MinScoreSubs = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Input your scores of 4 subjects (Math, English, Physics, and Programming) : ");
            line = sc.nextLine();
            inputSize = line.trim().split("\\s+");
            validInput = (inputSize.length == 4);
            if (validInput) {
                for (int i = 0; i < arr.length; i++) {
                    try {
                        arr[i] = Integer.parseInt(inputSize[i]);
                        if (arr[i] > 100 || arr[i] < 0) {
                            validInput = false;
                            System.out.println("\nPlease enter valid scores: ");
                            break;
                        }
                    } catch (NumberFormatException e) {
                        validInput = false;
                        System.out.println("Please enter valid scores");
                        break;
                    }
                }

                if (validInput) {
                    min = arr[0];
                    max = arr[0];
                    for (int i = 0; i < 4; i++) {
                        min = Math.min(min, arr[i]);
                        max = Math.max(max, arr[i]);
                    }
                }
            }
        } while (!validInput);
        sc.close();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                MaxScoreSubs.add(subjects[i]);
            }
            if (arr[i] == min) {
                MinScoreSubs.add(subjects[i]);
            }
        }
        if (MaxScoreSubs.size() > 1) {
            System.out.print("\nMax score is: " + max + " (");
            for (int i = 0; i < MaxScoreSubs.size() - 1; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(MaxScoreSubs.get(i));
                System.out.print(" ");
            }
            System.out.print("and ");
            System.out.println(MaxScoreSubs.get(MaxScoreSubs.size() - 1) + " courses)");
        } else if (MaxScoreSubs.size() == 1) {
            System.out.println("\nMax score is: " + max + " (" + MaxScoreSubs.get(0) + " courses)");
        }
        if (MinScoreSubs.size() > 1) {
            System.out.print("Min score is: " + min + " (");
            for (int i = 0; i < MinScoreSubs.size() - 1; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(MinScoreSubs.get(i));
                System.out.print(" ");
            }
            System.out.print("and ");
            System.out.println(MinScoreSubs.get(MinScoreSubs.size() - 1) + " course)");
        } else if (MinScoreSubs.size() == 1) {
            System.out.println("\nMin score is: " + min + " (" + MinScoreSubs.get(0) + " course)");
        }

        int sum = 0;
        for (int score : arr) {
            sum += score;
        }

        double average = (double) sum / arr.length;
        System.out.println("Average score: " + average);
    }
}
