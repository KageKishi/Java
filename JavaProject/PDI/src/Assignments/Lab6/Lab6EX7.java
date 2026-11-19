/*7. Abstract Classes — “Payment Methods”
Use Case: E-commerce needs different payment implementations.
Goal: Use abstract classes and enforce method overriding.
Instructions:
• Abstract class: Payment
o abstract method: process_payment(amount)
• Derived:
o CreditCardPayment
o PayPalPayment
o BankTransferPayment
Task:
Invoke each payment method and show different behavior.
 */
public class Lab6EX7 {
    public static void main(String[] args) {
        Payment creditCardPayment = new CreditCardPayment();
        creditCardPayment.process_payment(100.0);

        Payment paypalPayment = new PayPalPayment();
        paypalPayment.process_payment(200.0);

        Payment bankTransferPayment = new BankTransferPayment();
        bankTransferPayment.process_payment(300.0);
    }

    public static abstract class Payment {
        public abstract void process_payment(double amount);
    }

    public static class CreditCardPayment extends Payment {
        @Override
        public void process_payment(double amount) {
            System.out.println("Processing credit card payment of $" + amount);
        }
    }

    public static class PayPalPayment extends Payment {
        @Override
        public void process_payment(double amount) {
            System.out.println("Processing PayPal payment of $" + amount);
        }
    }

    public static class BankTransferPayment extends Payment {
        @Override
        public void process_payment(double amount) {
            System.out.println("Processing bank transfer payment of $" + amount);
        }
    }

}
