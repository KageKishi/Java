
/*Generate 500 random numbers and store in a file
named LuckyNumber.csv */
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
import java.util.ArrayList;

public class Lab4EX1 {
    public static void main(String[] args){
        try{
            Path path = Path.of("LuckyNumber.csv");

            if (Files.notExists(path)) {
                ArrayList<String> lines = new ArrayList<>();
                for (int i = 0; i < 500; i++) {
                    lines.add("LuckyNumber " + (int) (Math.random() * 1000));
                }
                Files.write(path, lines);
                System.out.println("File created.");
            } else {
                System.out.println("File already exists.");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}