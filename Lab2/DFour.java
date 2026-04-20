import java.util.Scanner;
public class DFour {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int input = 0;
        do{
        System.out.print("Input number of seconds: ");
        input = sc.nextInt();
        }while(input > 86400);
        sc.close();
        int seconds = input % 60;
        int Hour = input / 3600;
        int minute = (input % 3600)/60;
       System.out.printf("Time corresponding to 1259 seconds is:: %02d:%02d:%02d\n", Hour , minute , seconds);
    }
}
