import java.util.Scanner;
public class FSix{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input a number to check whether it is a prime number: ");
        int Input = sc.nextInt();
        boolean isPrime = false;
        int divi = 0;
        for(int i = 1; i <= Input ; i++){
            if(i == Input) isPrime = true;
            if(i != Input && i != 1){
                if(Input % i == 0){
                    isPrime = false;
                    divi = i;
                    i = Input;
                }
            }
            
        }
        sc.close();
        if(isPrime){
            System.out.println(Input+" is a prime number.\r\n");
        }else{
            System.out.println(Input + " is not a prime number, because it is divisible by "+ divi);
        }
}
}