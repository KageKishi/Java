
public class Three {

    public static void main(String[] args) {
        int n = 5;
        //Triangle
        for (int i = n; i >= 1; i--) {
            for (int j = i; j < n; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        //Square
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || j == 1 || j == n || i == n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        //Numbers
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(j + i);
            }
            System.out.println();
        }
    }
}
