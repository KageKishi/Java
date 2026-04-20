import java.util.Scanner;
public class AOne{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Your Name: ");
        String name = sc.nextLine();
        sc.close();
        System.out.print("Hello " + name + "!");
    }
}