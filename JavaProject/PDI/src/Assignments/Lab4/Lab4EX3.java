
/*Write a Java program that creates a file csv and
writes some text to it.
Input 3 students (name, ID, gender) of your team
members. Then store these data into a file named
Ex3StudentData.csv */
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab4EX3 {
    public static class Student {
        String name;
        int id;
        char gender;
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            Path path = Path.of("Ex3StudentData.csv");
            ArrayList<Student> StudentData = new ArrayList<>();
            for(int i = 0 ; i < 3 ; i++){
                Student Stu = new Student();
                System.out.println("Enter your name: ");
                Stu.name = sc.nextLine();
                do{
                System.out.println("Enter your gender: ");
                Stu.gender = sc.nextLine().charAt(0);
                Stu.gender = Character.toUpperCase(Stu.gender);
                if(!(Stu.gender == 'M' || Stu.gender == 'F')){
                    System.out.println("Enter your assign birth gender");
                }
                }while(!(Stu.gender == 'M' || Stu.gender == 'F'));
                Stu.id = utilies.ValidateInteger("Enter your ID: ", sc);
                StudentData.add(Stu);
            }
            ArrayList<String> lines = new ArrayList<>();
            for (Student student : StudentData) {
                lines.add(student.name + "," + student.id + "," + student.gender);
            }
            Files.write(path, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
