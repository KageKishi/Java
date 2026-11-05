
/*Write a java program to load the data in the file
StudentData.csv and store in an array list. Then :
 */

import java.nio.file.Path;
import java.nio.file.Files;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Lab4EX5 {
    public static class Student {
        String name;
        int id;
        char gender;

        Student() {

        }

        Student(String name, int id, char gen) {
            this.name = name;
            this.id = id;
            this.gender = gen;
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> studentData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("Ex3StudentData.csv"))) {
            Scanner sc = new Scanner(System.in);
            Path path = Path.of("Ex3StudentData.csv");
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Student stu = new Student(data[0], Integer.parseInt(data[1]), data[2].charAt(0));
                studentData.add(stu);
            }
            for (int i = 0; i < 3; i++) {
                Student Stu = new Student();
                System.out.println("Enter your name: ");
                Stu.name = sc.nextLine();
                do {
                    System.out.println("Enter your gender: ");
                    Stu.gender = sc.nextLine().charAt(0);
                    Stu.gender = Character.toUpperCase(Stu.gender);
                    if (!(Stu.gender == 'M' || Stu.gender == 'F')) {
                        System.out.println("Enter your assign birth gender");
                    }
                } while (!(Stu.gender == 'M' || Stu.gender == 'F'));
                Stu.id = utilies.ValidateInteger("Enter your ID: ", sc);
                studentData.add(Stu);
            }
            studentData.sort(Comparator.comparing(
                    student -> student.name.toLowerCase()));
            ArrayList<String> lines = new ArrayList<>();
            for (Student student : studentData) {
                lines.add(student.name + "," + student.id + "," + student.gender);
            }
            Files.write(path, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Student student : studentData) {
            System.out.println(student.name + "," + student.id + "," + student.gender);
        }
    }
}
