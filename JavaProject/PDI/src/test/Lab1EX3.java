package test;
import java.util.Scanner;
import java.util.Map;
import java.util.LinkedHashMap;
public class Lab1EX3 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Map<String,String> data = new LinkedHashMap<>();
        System.out.println("Enter your Full name: ");
        data.put("Name: ", sc.nextLine());
        System.out.println("Enter your Year: ");
        data.put("Year: ", sc.nextLine());
        System.out.println("Enter your Major: ");
        data.put("Major: ", sc.nextLine());
        System.out.println("Enter your GPA: ");
        data.put("GPA: ", sc.nextLine());
        sc.close();
        for(Map.Entry<String,String> entry : data.entrySet()){
            System.out.println(entry.getKey() + entry.getValue());
        }
    }
}
