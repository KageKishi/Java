import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.Gson;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.Scanner;

public class Lab2EX5 {
    private static Scanner sc = new Scanner(System.in);

    public static class Account {
        int AccNumber;
        String name;
        double balance;
    };

    public static void main(String[] args) throws IOException {
        JsonObject data;
        Path DaWay = Path.of("Account.json");
        String Filelines = Files.readString(DaWay).trim();
        if (Filelines.isEmpty()) {
            data = new JsonObject();
        } else {
            data = new JsonObject();
            try {
                JsonElement parsed = JsonParser.parseString(Filelines);
                if (parsed.isJsonNull())
                    data = new JsonObject();
                else if (parsed.isJsonObject())
                    data = parsed.getAsJsonObject();
            } catch (Exception e) {
                throw new IllegalStateException("This file isn't json");
            }
        }
        Account account = new Account();
        int choice = 1;
        while (choice != 0) {
            choice = utilies.ValidateInteger("==============\n1.Login\n2.Signup\n0.Exit\n==============");
            switch (choice) {
                case 1: {
                    Login(data, account);
                    break;
                }
                case 2: {
                    Signup(data, account);
                    break;
                }
                case 0: {
                    choice = 0;
                    break;
                }
                default: {
                    System.out.println("Invalid Choice\n");
                }
            }
        }
    }

    public static void Login(JsonObject data, Account account) {
        int AccNumber = getAccountNumber();
        if (data.has(String.valueOf(AccNumber))) {
            for (String key : data.keySet()) {
                if (data.has(String.valueOf(AccNumber))) {
                    account.name = data.getAsJsonObject(key).get("Name").getAsString();
                    account.balance = data.getAsJsonObject(key).get("Balance").getAsDouble();
                    account.AccNumber = AccNumber;
                }
            }
        } else {
            System.out.println("Your account does not exist");
        }
    }

    public static void Signup(JsonObject data, Account account) {
        int AccNumber = getAccountNumber();
        if (data.has(String.valueOf(AccNumber))) {
            System.out.println("Account Already Exist");
        } else {
            System.out.println("Please enter your name");
            account.AccNumber = AccNumber;
            account.name = sc.nextLine();
            account.balance = utilies.ValidateDouble("Please enter your balance");
            WriteFile(data, account);
        }
    }

    public static void WriteFile(JsonObject data, Account account) {
        try {
            Path path = Path.of("Account.json");
            Gson gson = new Gson();
            JsonObject Accountdata = new JsonObject();
            Accountdata.addProperty("Name", account.name);
            Accountdata.addProperty("Balance", account.balance);
            data.add(String.valueOf(account.AccNumber), Accountdata);
            Files.writeString(path, gson.toJson(data));
        } catch (IOException e) {
            System.out.println("Error Writing File");
        }
    }

    public static int getAccountNumber() {
        boolean ValidNumber = false;
        int AccNumber = 0;
        while (!ValidNumber) {
            AccNumber = utilies.ValidateInteger("Please enter your account number");
            if(String.valueOf(AccNumber).length() != 14){
                System.out.println("Account Number must be 14 character long.\n")
            }else{
                ValidNumber = true;
            }
        }
        return AccNumber;
    }
}