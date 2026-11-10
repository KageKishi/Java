/*Write a functional program to:
a) find the cube of each number in a list and print the results
b) filter out positive numbers from a given list and print them.
c) sort data in a list.
List<Integer> numbers = Arrays.asList(5, 2, 9, -1, 3, -8, 20, -50); */

import java.util.Arrays;
import java.util.List;
public class Lab5EX9 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 9, -1, 3, -8, 20, -50);


        System.out.println("Cubes of the numbers:");
        numbers.stream()
                .map(n -> n * n * n)
                .forEach(System.out::println);


        System.out.println("Positive numbers:");
        numbers.stream()
                .filter(n -> n > 0)
                .forEach(System.out::println);

        System.out.println("Negative numbers:");
        numbers.stream()
                .filter(n -> n < 0)
                .forEach(System.out::println);
                
        System.out.println("Sorted numbers:");
        numbers.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
