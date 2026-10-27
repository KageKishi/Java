import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.Scanner;

public class Lab2EX5 {
    private static Scanner sc = new Scanner(System.in);

    public static class Account {
        @SerializedName("AccNumber")
        int AccNumber;
        @SerializedName("Name")
        String name;
        @SerializedName("Balance")
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
                    account = Login(data);
                    if (account != null) {
                        AccountMenu(data, account);
                    }
                    break;
                }
                case 2: {
                    if (Signup(data, account)) {
                        AccountMenu(data, account);
                    }
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

    public static Account Login(JsonObject data) {
        int AccNumber = getAccountNumber();
        String accountKey = String.valueOf(AccNumber);
        if (!data.has(accountKey)) {
            System.out.println("Your account does not exist");
            return null;
        }

        Account account = new Gson().fromJson(data.getAsJsonObject(accountKey), Account.class);
        account.AccNumber = AccNumber;
        return account;
    }

    public static boolean Signup(JsonObject data, Account account) {
        int AccNumber = getAccountNumber();
        if (data.has(String.valueOf(AccNumber))) {
            System.out.println("Account Already Exist");
            return false;
        } else {
            System.out.println("Please enter your name");
            account.AccNumber = AccNumber;
            account.name = sc.nextLine();
            account.balance = utilies.ValidateDouble("Please enter your balance");
            WriteFile(data, account);
            return true;
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
                System.out.println("Account Number must be 14 character long.\n");
            }else{
                ValidNumber = true;
            }
        }
        return AccNumber;
    }

    public static void AccountMenu(JsonObject data, Account account) {
        int choice = 1;
        while (choice != 0) {
            choice = utilies.ValidateInteger(
                    "================\n1.Deposit\n2.Withdraw\n3.Balance\n0.Logout\n================");
            switch (choice) {
                case 1:
                    Deposit(data, account);
                    break;
                case 2:
                    Withdraw(data, account);
                    break;
                case 3:
                    System.out.println("Current balance: " + account.balance);
                    break;
                case 0:
                    System.out.println("Logged out");
                    break;
                default:
                    System.out.println("Invalid Choice\n");
            }
        }
    }

    public static void Deposit(JsonObject data, Account account) {
        double amount = utilies.getPositiveAmount("Please enter the amount to deposit");
        account.balance += amount;
        WriteFile(data, account);
        System.out.println("Deposit successful. New balance: " + account.balance);
    }

    public static void Withdraw(JsonObject data, Account account) {
        double amount = utilies.getPositiveAmount("Please enter the amount to withdraw");
        if (amount > account.balance) {
            System.out.println("Insufficient Balance");
            return;
        }

        account.balance -= amount;
        WriteFile(data, account);
        System.out.println("Withdrawal successful. New balance: " + account.balance);
    }

    
}