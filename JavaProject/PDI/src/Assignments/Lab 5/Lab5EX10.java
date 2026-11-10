/*Read name of students from a CSV file then store
in an array list.
Print out name of students in a sorted A-Z order
using functional programming. */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Lab5EX10 {
    public static void main(String[] args) {
        String csvFile = "students.csv";
        ArrayList<String> studentNames = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length > 0) {
                    studentNames.add(values[0].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Student names in sorted A-Z order:");
        studentNames.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
