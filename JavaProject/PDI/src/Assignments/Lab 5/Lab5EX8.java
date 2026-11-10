/*Write a program that can creates and runs multiple
threads using Thread class.
Let’s define 3 functions to:
a) find sum from 1 to n,
b) show all prime numbers in between 1 to 100,
c) read data from a CSV file of student list (name, ID, age,
gender) and store it into an array list.
Redesign the problem in Exercise 7 by using
Runnable task instead. */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Lab5EX8 {
    public static class Student {
        private String name;
        private String id;
        private int age;
        private String gender;

        public Student(String name, String id, int age, String gender) {
            this.name = name;
            this.id = id;
            this.age = age;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", id='" + id + '\'' +
                    ", age=" + age +
                    ", gender='" + gender + '\'' +
                    '}';
        }
    }
    public static class SumThread implements Runnable {
        private int n;

        public SumThread(int n) {
            this.n = n;
        }

        @Override
        public void run() {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            System.out.println("Sum from 1 to " + n + " is: " + sum);
        }
    }
    public static class PrimeThread implements Runnable {
        @Override
        public void run() {
            System.out.println("Prime numbers between 1 and 100:");
            for (int i = 2; i <= 100; i++) {
                if (isPrime(i)) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }

        private boolean isPrime(int num) {
            if (num <= 1) return false;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) return false;
            }
            return true;
        }
    }
    public static class CSVThread implements Runnable {
        private String filePath;

        public CSVThread(String filePath) {
            this.filePath = filePath;
        }

        @Override
        public void run() {
            ArrayList<Student> students = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data.length == 4) {
                        String name = data[0].trim();
                        String id = data[1].trim();
                        int age = Integer.parseInt(data[2].trim());
                        String gender = data[3].trim();
                        students.add(new Student(name, id, age, gender));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Students read from CSV:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
    public static void main(String[] args) throws InterruptedException{
        Thread sumThread = new Thread(new SumThread(100));
        Thread primeThread = new Thread(new PrimeThread());
        Thread csvThread = new Thread(new CSVThread("students.csv"));

        sumThread.start();
        System.out.println("");
        primeThread.start();
        System.out.println("");
        csvThread.start();

        sumThread.join();
        primeThread.join();
        csvThread.join();
    }
}
