import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.Gson;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.Scanner;

public class Lab2EX3 {
    public static void main(String args[]) throws IOException {
        boolean AddingEmployees = true;
        Scanner sc = new Scanner(System.in);
        JsonObject data;
        Gson gson = new Gson();
        Path path = Path.of(
                "Employees.json");
        String FileContents = Files.readString(path).trim();
        if (FileContents.isEmpty()) {
            data = new JsonObject();
        } else {
            JsonElement parsed = JsonParser.parseString(FileContents);
            if (parsed.isJsonNull()) {
                data = new JsonObject();
            } else if (parsed.isJsonObject()) {
                data = parsed.getAsJsonObject();
            } else {
                throw new IllegalStateException("Employees.json must contain a JSON object");
            }
        }
        while (AddingEmployees)

        {
            int EmployeeID = utilies.ValidateInteger("Enter Employee ID or 0 to exit: ", sc);
            if (EmployeeID == 0) {
                AddingEmployees = false;
            } else {
                System.out.println("Enter Employee Name: ");
                String EmployeeName = sc.nextLine();
                System.out.println("");
                double BasicSalary = utilies.ValidateDouble("Enter Employees basic salary: ", sc);
                double HRA = BasicSalary * 0.2;
                double TCA = BasicSalary * 0.1;
                double GrossSalary = BasicSalary * 1.3;
                JsonObject EmployeeData = new JsonObject();
                EmployeeData.addProperty("ID", EmployeeID);
                EmployeeData.addProperty("Basic Salary", BasicSalary);
                EmployeeData.addProperty("Gross Salary", GrossSalary);
                EmployeeData.addProperty("HRA", HRA);
                EmployeeData.addProperty("TCA", TCA);
                data.add(EmployeeName, EmployeeData);
                Files.writeString(path, gson.toJson(data));
            }
        }
        for (String key : data.keySet()) {
            System.out.println("\nName: " + key);
            System.out.println("ID: " + data.getAsJsonObject(key).get("ID").getAsInt());
            System.out.println("Gross Salary: " + data.getAsJsonObject(key).get("Gross Salary").getAsDouble());
            System.out.println("Basic Salary: " + data.getAsJsonObject(key).get("Basic Salary").getAsDouble());
            System.out.println("HRA: " + data.getAsJsonObject(key).get("HRA").getAsDouble());
            System.out.println("TCA: " + data.getAsJsonObject(key).get("TCA").getAsDouble());
        }
        sc.close();
    }
}
