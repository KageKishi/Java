/*Challenge 2: Using super() in Overriding — “Online Store Discounts”
Goal: Learn mixing base-class logic with subclass logic.
Instructions:
• Base class: Discount
o method: apply(amount) → subtract 5%
• Child class: SeasonalDiscount
o override apply() to add an additional 10% reduction
o call super().apply(amount) inside
Task:
Show calculation flow with and without super() to see the difference. */
public class Lab6CH2 {
    public static void main(String[] args) {
        Discount baseDiscount = new Discount();
        double baseAmount = 100.0;
        System.out.println("Base Discount on $" + baseAmount + ": $" + baseDiscount.apply(baseAmount));

        SeasonalDiscount seasonalDiscount = new SeasonalDiscount();
        System.out.println("Seasonal Discount on $" + baseAmount + ": $" + seasonalDiscount.apply(baseAmount));
    }

    public static class Discount {
        public double apply(double amount) {
            return amount * 0.95; // 5% discount
        }
    }

    public static class SeasonalDiscount extends Discount {
        @Override
        public double apply(double amount) {
            double discountedAmount = super.apply(amount); // Apply base discount first
            return discountedAmount * 0.90; // Additional 10% discount
        }
    }
}
