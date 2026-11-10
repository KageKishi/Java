/*Write a procedural program to find the sum of even
numbers from 1 to 100. Display result on screen. */

public class Lab5EX1 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println("The sum of even numbers from 1 to 100 is: " + sum);
    }
}
