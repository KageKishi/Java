package test;
import java.util.Scanner;
public class Lab1EX1 {
    public static void main(String args[]){
        int number;
        System.out.println("Enter a number: ");
        Scanner sc = new Scanner(System.in);
        number = sc.nextInt();
        sc.close();
        int sum = 0;
        for(int i = 1000 ; i >= number ; i--){
            System.out.print(i + " ");
            sum += i;
        }
        int average = sum/(1001-number);
        System.out.println("\nAverage is: " + average + "\nSum is: " + sum);
    }
}
