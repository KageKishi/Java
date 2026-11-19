/*Challenge 4: Inheriting Exceptions — “Bank Transactions”
Goal: Learn inheritance with exception classes.
Instructions:
• Create base exception: BankError
• Sub-exceptions:
o InsufficientFundsError
o AccountNotFoundError
o CurrencyMismatchError
Task:
Trigger the exceptions in different scenarios */
public class Lab6CH4 {
    public static void main(String[] args){
        try {
            throw new InsufficientFundsError();
        } catch (BankError e) {
            System.out.println("Caught an error: " + e.getClass().getSimpleName());
        }

        try {
            throw new AccountNotFoundError();
        } catch (BankError e) {
            System.out.println("Caught an error: " + e.getClass().getSimpleName());
        }

        try {
            throw new CurrencyMismatchError();
        } catch (BankError e) {
            System.out.println("Caught an error: " + e.getClass().getSimpleName());
        }

    }
    public static abstract class BankError extends Exception{
        public BankError() {
            System.out.println("Bank Error Occurred");
        }
    }
    public static class InsufficientFundsError extends BankError{
        public InsufficientFundsError() {
            super(); 
        }
    }
    public static class AccountNotFoundError extends BankError{
        public AccountNotFoundError() {
            super(); 
        }
    }
    public static class CurrencyMismatchError extends BankError{
        public CurrencyMismatchError() {
            super(); 
        }
    }
}

