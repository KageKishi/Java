/*Find max and min in an array using functional
programming.
int[ ] numbers = {5, 2, 9, 1, 3, 8}; */
public class Lab5EX11 {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 9, 1, 3, 8};

        int max = java.util.Arrays.stream(numbers).max().orElse(0);
        int min = java.util.Arrays.stream(numbers).min().orElse(0);

        System.out.println("Maximum number: " + max);
        System.out.println("Minimum number: " + min);
    }
}

