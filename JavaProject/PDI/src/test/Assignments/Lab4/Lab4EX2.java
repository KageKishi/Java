
/*Ask a user for a number n.
Then create n files (file1.csv, file2.csv, file3.csv, … filen.csv)
in a folder Ex2LuckyNumber. Each file store random
numbers between 1 to 100. Read all numbers from all n files created early then store it
in an array list. Find out what is the max and min numbers.*/
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
public class Lab4EX2 {
    public static void main(String[] args) {
        ArrayList<Integer> AllNumbers = new ArrayList<>();
        int n = 11;
        while (n > 10) {
            n = utilies.getPositiveAmount("Enter the amount of files: ");
            if (n > 10) {
                System.out.println("Please enter a number less than 10");
            }
        }
        try {
            Path directory = Path.of("Ex2LuckyNumber");
            Files.createDirectories(directory);

            for (int i = 1; i <= n; i++) {
                Path path = directory.resolve("file" + i + ".csv");
                if (Files.notExists(path)) {
                    int randomNumber = (int) (Math.random() * 100) + 1;
                    Files.writeString(path, "Random Number: " + randomNumber);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
       try {
            Path directory = Path.of("Ex2LuckyNumber");
            Files.createDirectories(directory);

            for (int i = 1; i <= n; i++) {
                Path path = directory.resolve("file" + i + ".csv");
                if (!Files.notExists(path)) {
                    String lines = Files.readString(path);
                    String[] data = lines.split("Random Number: " , 2);
                    AllNumbers.add(Integer.parseInt(data[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(AllNumbers);
        System.out.println("Maximum Number: " + AllNumbers.get(AllNumbers.size()-1));
        System.out.println("Minimum Number: " + AllNumbers.get(0));
    }
}