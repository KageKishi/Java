
public class Four {

    public static void main(String[] args) {
        //Math
        for (int i = 0; i <= 10; i++) {
            if (i != 0) {
                System.out.printf(" %5d |", i);
            } else {
                System.out.printf(" %5s |", " ");
            }
        }
        System.out.println();
        System.out.print("-".repeat(88));
        System.out.println();
        for (int i = 1; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                if (j != 0) {
                    System.out.printf(" %5d |", i * j);
                } else {
                    System.out.printf(" %5d |", i);
                }
            }
            System.out.println();
        }
        //People
        String[] name = {"Name", "Michael", "Robert", "Julia", "Jo"};
        String[] country = {"Country", "Germany", "England", "United Kingdom", "United States"};
        String[] profession = {"Profession", "Computer Engineer", "Artisit", "Designer", "Actor"};
        String[] Age = {"Age", "19", "34", "42", "21"};
        int j = 0;
        for (int i = 1; i <= 11; i++) {
            if (i % 2 == 0) {
                System.out.printf("| %-20s", country[j]);
                System.out.printf("| %-20s", name[j]);
                System.out.printf("| %-20s", profession[j]);
                System.out.printf("| %-11s", Age[j]);
                System.out.println("|");
                j++;
            } else {
                System.out.print("+" + "-".repeat(21));
                System.out.print("+" + "-".repeat(21));
                System.out.print("+" + "-".repeat(21));
                System.out.print("+" + "-".repeat(12));
                System.out.println("+");
            }
        }
    }
}
