package test;

import java.util.Scanner;

public class Lab1EX2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        double root1, root2;
        double a, b, c;
        System.out.println("Please enter a: ");
        a = sc.nextInt();
        System.out.println("Please enter a: ");
        b = sc.nextInt();
        System.out.println("Please enter a: ");
        c = sc.nextInt();
        sc.close();
        double delta = (b * b) - (4 * a * c);
        root1 = (-b + Math.sqrt(delta)) / (2 * a);
        root2 = (-b - Math.sqrt(delta)) / (2 * a);
        if (delta > 0) {
            System.out.println("\nFirst Root 1: " + root1);
            System.out.println("\nSecond Root 2: " + root2);
        } else if (delta == 0) {
            System.out.println("\nFirst Root 1: " + root1);
        } else if (delta < 0) {
            System.out.println("\nFirst Root 1: " + (-b/(2*a)) + " + " + (Math.sqrt(-delta)/(2*a)) + "(i) ");
            System.out.println("\nSecond Root 2: " + (-b/(2*a)) + " - " + (Math.sqrt(-delta)/(2*a)) + "(i) ");
        }
    }
}
