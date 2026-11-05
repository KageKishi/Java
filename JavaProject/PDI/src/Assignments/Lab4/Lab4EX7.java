/*Write a program that reads CSV data (see attached link).
Create some methods that can answer the questions below:
Questions: How many students in each group? Percentage of male candidates ?
Percentage of female candidates?
a)-Then write students to different 4 CSV files based on their groups.
b)-Add a summary total students, %male and %female at the bottom of each file */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Lab4EX7 {
    public static class Student {
        int id;
        String gender;
        char group;
        String Education;
        String course;
        int Math;
        int English;
        int Computer;
        int Total;
        double Average;

        Student() {
        }

        Student(int id, String gen, char group, String Edu, String course, int math, int eng, int comp, int total,
                double average) {
            this.id = id;
            this.gender = gen;
            this.group = group;
            this.Education = Edu;
            this.course = course;
            this.Math = math;
            this.English = eng;
            this.Computer = comp;
            this.Total = total;
            this.Average = average;
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> studentData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("CandidatePerformanceTest.csv"))) {
            String line;
            char[] Alphabet = { 'A', 'B', 'C', 'D', 'E' };
            reader.readLine();
            reader.readLine();
            Path directory = Path.of("Groups");
            Files.createDirectories(directory);
            for (char c : Alphabet) {
                Path path = directory.resolve("Group" + c + ".csv");
                Files.writeString(path, "", StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            }
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Student stu = new Student(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2].charAt(data[2].length() - 1),
                        data[3],
                        data[4],
                        Integer.parseInt(data[5]),
                        Integer.parseInt(data[6]),
                        Integer.parseInt(data[7]),
                        Integer.parseInt(data[8]),
                        Double.parseDouble(data[9]));
                studentData.add(stu);
                if (data[2].equals("group A")) {
                    Path path = directory.resolve("GroupA.csv");
                    Files.writeString(path, line + System.lineSeparator(), StandardOpenOption.APPEND);
                } else if (data[2].equals("group B")) {
                    Path path = directory.resolve("GroupB.csv");
                    Files.writeString(path, line + System.lineSeparator(), StandardOpenOption.APPEND);
                } else if (data[2].equals("group C")) {
                    Path path = directory.resolve("GroupC.csv");
                    Files.writeString(path, line + System.lineSeparator(), StandardOpenOption.APPEND);
                } else if (data[2].equals("group D")) {
                    Path path = directory.resolve("GroupD.csv");
                    Files.writeString(path, line + System.lineSeparator(), StandardOpenOption.APPEND);
                } else if (data[2].equals("group E")) {
                    Path path = directory.resolve("GroupE.csv");
                    Files.writeString(path, line + System.lineSeparator(), StandardOpenOption.APPEND);
                }
            }
            for (char c : Alphabet) {
                Path path = directory.resolve("Group" + c + ".csv");
                long groupSize = studentData.stream().filter(s -> s.group == c).count();
                long femaleCount = studentData.stream()
                        .filter(s -> s.group == c)
                        .filter(s -> "Female".equalsIgnoreCase(s.gender))
                        .count();
                long maleCount = studentData.stream()
                        .filter(s -> s.group == c)
                        .filter(s -> "Male".equalsIgnoreCase(s.gender))
                        .count();
                Files.writeString(path, "Total: " + groupSize + System.lineSeparator(), StandardOpenOption.APPEND);
                Files.writeString(path,"Female: " + String.valueOf(
                        groupSize == 0 ? 0 : femaleCount * 100.0 / groupSize) + System.lineSeparator(),
                        StandardOpenOption.APPEND);
                Files.writeString(path,"Male: "+ String.valueOf(
                        groupSize == 0 ? 0 : maleCount * 100.0 / groupSize) + System.lineSeparator(),
                        StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
