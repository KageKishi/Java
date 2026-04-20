import java.util.Scanner;
public class BTwo {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Program for converting money in Riels to Dollars");
        System.out.print("Please input conversion rate of 1 dollar in Riels: ");
        double rate = sc.nextDouble();
        System.out.print("Please input money to exchange in Riels: ");
        double amount = sc.nextDouble();
        sc.close();
        System.out.print("\n" + amount + " RIELS = " + amount/rate + " USD ");
    }
}
