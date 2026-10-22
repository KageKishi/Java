
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.Gson;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Lab2EX1 {
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Library library = new Library();
        library.AskForBook();
        library.DisplayBooks();
        sc.close();
    }



    static class Library {
        String BookName;
        int ID;
        boolean AddingBooks = true;
        String Author;
        Double Price;
        JsonObject data;
        JsonObject newBook = new JsonObject();
        Gson gson = new Gson();
        Path filePath = Path.of(
                "D:\\Github\\Java\\JavaProject\\PDI\\src\\test\\Assignments\\Lab3\\Books.json");
        Scanner sc = new Scanner(System.in);

        public Library() throws IOException {
            String fileContents = Files.readString(filePath).trim();
            if (fileContents.isEmpty()) {
                data = new JsonObject();
                return;
            }

            JsonElement parsed = JsonParser.parseString(fileContents);
            if (parsed.isJsonNull()) {
                data = new JsonObject();
            } else if (parsed.isJsonObject()) {
                data = parsed.getAsJsonObject();
            } else {
                throw new IllegalStateException("Books.json must contain a JSON object");
            }
        }

        public void AskForBook() throws IOException {
            while (AddingBooks) {
                System.out.println("Please enter Book title or 0 to exit: ");
                BookName = sc.nextLine();
                if (BookName == "0") {
                    AddingBooks = false;
                } else {
                    System.out.println("Pleasse Enter Authors name: ");
                    Author = sc.nextLine();
                    ID = utilies.ValidateInteger("Please enter the Book's ID: ");
                    Price = utilies.ValidateDouble("Please enter the price of the book: ");
                    newBook.addProperty("Author", Author);
                    newBook.addProperty("ID", ID);
                    newBook.addProperty("Price", Price);
                    data.add(BookName, newBook);
                    String FileWrite = gson.toJson(data);
                    Files.writeString(filePath, FileWrite);
                }
            }
        }

        public void DisplayBooks() {

            for (Map.Entry<String, JsonElement> entry : data.entrySet()) {
                String key = entry.getKey();
                JsonObject Book = data.getAsJsonObject(key);
                System.out.println("\nBookName: " + key);
                System.out.println("Author: " + Book.get("Author").getAsString());
                System.out.println("ID: " + Book.get("ID").getAsInt());
                System.out.println("Price: " + Book.get("Price").getAsDouble());
            }
        }
    }
}
