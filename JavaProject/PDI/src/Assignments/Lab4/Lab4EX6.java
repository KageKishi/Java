/*Write a program that reads CSV data (see attached link).
Create some methods that can answer the questions below:
1. How many candidates in total ? Percentage of male candidates ?
Percentage of female candidates?
2. How many candidates got average score at least 90? Percentage of male
candidates ? Percentage of female candidates?
3. How many candidates get score for each subject at least 85?
4. How many students in each group? Percentage of male candidates ?
Percentage of female candidates?  */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Lab4EX6 {
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
        char[] Alphabet = { 'A', 'B', 'C', 'D', 'E' };
        try (BufferedReader reader = new BufferedReader(new FileReader("CandidatePerformanceTest.csv"))) {
            String line;
            reader.readLine();
            reader.readLine();
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
            }
            long male = (studentData.stream()
                    .filter(student -> "Male".equalsIgnoreCase(student.gender))
                    .count());
            long female = (studentData.stream().filter(s->"Female".equalsIgnoreCase(s.gender)).count());
            System.out.println("Total: " + studentData.size());
            System.out.println("Female Percentage: " + (female * 100.0) / studentData.size());
            System.out.println("Male Percentage: " + (male * 100.0) / studentData.size());
            System.out.println(
                    "Student over 90 Average: " + (studentData.stream().filter(student -> student.Average > 90).count()));
            System.out.println(
                    "Female Student over 90 Average: " + (studentData.stream().filter(student -> student.Average > 90)
                            .filter(student -> "Female".equalsIgnoreCase(student.gender)).count()));
            System.out.println(
                    "Male Student over 90 Average: " + (studentData.stream().filter(student -> student.Average > 90)
                            .filter(student -> "Male".equalsIgnoreCase(student.gender)).count()));
            System.out.println("Student with at least 85 on each Subject: " + studentData.stream()
                    .filter(s -> s.Math > 85).filter(s -> s.Computer > 85).filter(s -> s.English > 85).count());
            for (char c : Alphabet) {
                System.out
                        .println("\nGroup " + c + " Students: " + studentData.stream().filter(s -> s.group == c).count());
                System.out.println("Male Students: " + studentData.stream().filter(s -> s.group == c)
                        .filter(s -> "Male".equalsIgnoreCase(s.gender)).count());
                System.out.println("Female Students: " + studentData.stream().filter(s -> s.group == c)
                        .filter(s -> "Female".equalsIgnoreCase(s.gender)).count());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
