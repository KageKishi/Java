import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.Gson;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Lab2EX4 {
    public static void main(String args[]) throws IOException {
        Map<String, Integer> SubjectScores = new HashMap<>();
        int Sum = 0;
        boolean CorrectScores = true;
        char Grade;
        Gson gson = new Gson();
        Path path = Path.of("StudentGrades.json");
        String FileContents = Files.readString(path);
        JsonObject data;
        JsonObject StudentData = new JsonObject();
        if (FileContents.isEmpty()) {
            data = new JsonObject();
        } else {
            JsonElement parsed = JsonParser.parseString(FileContents);
            if (parsed.isJsonNull()) {
                data = new JsonObject();
            } else if (parsed.isJsonObject()) {
                data = parsed.getAsJsonObject();
            } else {
                throw new IllegalStateException("This File doesn't isn't Json.");
            }
        }
        Scanner sc = new Scanner(System.in);
        String Name;
        boolean addingStudent = true;
        while (addingStudent) {
            System.out.println("Please enter Your Name or 0 to exit: ");
            Name = sc.nextLine();
            if (Name.equals("0")) {
                addingStudent = false;
                break;
            }
            int ID = utilies.ValidateInteger("Please enter your Student ID");
            while (true) {
                CorrectScores = true;
                SubjectScores.put("Programming", utilies.ValidateInteger("Please enter your Programming score: "));
                SubjectScores.put("Math", utilies.ValidateInteger("Please enter your Math score: "));
                SubjectScores.put("Physic", utilies.ValidateInteger("Please enter your Physics score: "));
                SubjectScores.put("History", utilies.ValidateInteger("Please enter your History score: "));
                SubjectScores.put("Chemistry", utilies.ValidateInteger("Please enter your Chemistry score: "));
                StudentData.addProperty("ID", ID);
                for (String key : SubjectScores.keySet()) {
                    if (SubjectScores.get(key) > 100 || SubjectScores.get(key) < 0) {
                        CorrectScores = false;
                        System.out.println("Invalid score for " + key + ". Please enter scores between 0 and 100.");
                    }
                }
                if (CorrectScores == true) {
                    for (String key : SubjectScores.keySet()) {
                        StudentData.addProperty(key, SubjectScores.get(key));
                        Sum += SubjectScores.get(key);
                    }
                    break;
                }
            }

            double Average = Sum / 5;
            StudentData.addProperty("Total", Sum);
            StudentData.addProperty("Average", Average);
            if (Average >= 90) {
                Grade = 'A';
            } else if (Average >= 75) {
                Grade = 'B';
            } else if (Average >= 50) {
                Grade = 'C';
            } else {
                Grade = 'F';
            }
            StudentData.addProperty("Grade", Grade);
            System.out.println("\nStudent Name: " + Name + "\nID: " + ID + "\nTotal: " + Sum + "\nAverage: " + Average
                    + "\nGrade: " + Grade);
            data.add(Name, StudentData);
            Files.writeString(path, gson.toJson(data));
        }
        for (String key : data.keySet()) {
            System.out.println("Name: " + key);
            for (String key2 : SubjectScores.keySet()) {
                System.out.println(key2 + ": " + data.getAsJsonObject(key).get(key2).getAsInt());
            }
            System.out.println("Total: " + data.getAsJsonObject(key).get("Total").getAsInt());
            System.out.println("Average: " + data.getAsJsonObject(key).get("Average").getAsDouble());
            System.out.println("Grade: " + data.getAsJsonObject(key).get("Grade").getAsString());

        }
        sc.close();
    }
}
