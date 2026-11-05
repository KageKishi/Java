import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.Gson;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.Scanner;

public class Lab2EX2 {
    public static void main(String args[]) throws IOException {
        boolean AddingCities = true;
        Scanner sc = new Scanner(System.in);
        JsonObject data;
        Path path = Path
                .of("Cities.json");
        String fileContents = Files.readString(path).trim();
        if (fileContents.isEmpty()) {
            data = new JsonObject();
        } else {
            JsonElement parsed = JsonParser.parseString(fileContents);
            if (parsed.isJsonNull()) {
                data = new JsonObject();
            } else if (parsed.isJsonObject()) {
                data = parsed.getAsJsonObject();
            } else {
                throw new IllegalStateException("Cities.json must contain a JSON object");
            }
        }
        String city;
        JsonObject temperature = new JsonObject();
        while (AddingCities) {
            System.out.println("Enter the city or 0 to exit: ");
            city = sc.nextLine();
            if (city.equals("0"))
                AddingCities = false;
            else {
                double Celsius = utilies.ValidateDouble("Please enter the temperature in Celsius", sc);
                Double Farenheit = Celsius * 1.8 + 32;
                temperature.addProperty("Farenheit", Farenheit);
                temperature.addProperty("Celsius", Celsius);
                data.add(city, temperature);
                Files.writeString(path, new Gson().toJson(data));
                System.out.println("Temperature for " + city + "\nCelsius: " + Celsius + "\nFarenheit: " + Farenheit);
            }
        }
        for (String key : data.keySet()) {
            System.out.println(key + "\nFarenheit: " + data.getAsJsonObject(key).get("Farenheit").getAsDouble()
                    + "\nCelsius: " + data.getAsJsonObject(key).get("Celsius").getAsDouble());
        }
    }
}
