/*4. Calling Parent Constructor — “Bank Account Types”
Use Case: A bank system with multiple account categories.
Goal: Learn super() or base-constructor calls.
Instructions:
• Base: BankAccount
o constructor: accepts account_number, balance
• Derived: SavingsAccount
o constructor: also takes interest_rate
o must call the base constructor
Task:
Show correct initialization of subclass properties. */
public class Lab6EX4 {
    public static void main(String[] args) {
        
        SavingsAccount savingsAccount = new SavingsAccount("A123456", 1000.0, 0.05);
        System.out.println("Account Number: " + savingsAccount.getAccountNumber());
        System.out.println("Balance: $" + savingsAccount.getBalance());
        System.out.println("Interest Rate: " + (savingsAccount.getInterestRate() * 100) + "%");
    }
    public static class BankAccount {
        private String account_number;
        private double balance;

        public BankAccount(String account_number, double balance) {
            this.account_number = account_number;
            this.balance = balance;
        }

        public String getAccountNumber() {
            return account_number;
        }

        public double getBalance() {
            return balance;
        }
    }
    public static class SavingsAccount extends BankAccount {
        private double interest_rate;

        public SavingsAccount(String account_number, double balance, double interest_rate) {
            super(account_number, balance); // Call the constructor of the base class
            this.interest_rate = interest_rate;
        }

        public double getInterestRate() {
            return interest_rate;
        }
    }
}
