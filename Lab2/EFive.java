import java.util.Scanner;
public class EFive {
    public static void main(String[] args) {
        System.out.println("Program for calculating equation 1/x = 1/y + 1/z to find value of x");
        Scanner sc = new Scanner(System.in);
        double y = Input("Please input y: ", sc);
        double z = Input("Please input z: ", sc);
        double x = (z*y)/(z+y);
        System.out.println("Result is x = "+x);
        sc.close();
    }
    static double Input(String prompt, Scanner sc){
        double number;
        do{
            System.out.print(prompt);
            number = sc.nextDouble();
        }while(number == 0);
        return number;
    }
}
