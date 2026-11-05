
/*Write a java program to read the StudentData.csv
from file created in Exercise 3. Store these data in
an array list. */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Lab4EX4 {
    public static class Student {
        String name;
        int id;
        char gender;

        Student(String name, int id, char gen) {
            this.name = name;
            this.id = id;
            this.gender = gen;
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> studentData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("Ex3StudentData.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Student stu = new Student(data[0], Integer.parseInt(data[1]), data[2].charAt(0));
                studentData.add(stu);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Student student : studentData) {
            System.out.println(student.name + "," + student.id + "," + student.gender);
        }
    }
}
