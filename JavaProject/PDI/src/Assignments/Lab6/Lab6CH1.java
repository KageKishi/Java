/*Challenge 1: Overriding vs Overloading — “Insurance Policies”
Goal: Practice difference between methods with same name but different signatures vs truly overridden
methods.
Instructions:
• Base class: InsurancePolicy
o method: calculate_premium()
• Derived:
o HealthInsurance
o CarInsurance
• Add overloaded methods (multiple versions) in CarInsurance such as
calculate_premium(age_of_driver) and calculate_premium(age, accident_history).
• Add overridden versions in both derived classes.
Task:
Demonstrate both overriding (runtime polymorphism) and overloading (compile-time or signature-based
polymorphism). */
public class Lab6CH1 {
    public static void main(String[] args) {
        InsurancePolicy healthPolicy = new HealthInsurance();
        System.out.println("Health Insurance Premium: $" + healthPolicy.calculate_premium());

        InsurancePolicy carPolicy = new CarInsurance();
        System.out.println("Car Insurance Premium: $" + carPolicy.calculate_premium());
        System.out.println("Car Insurance Premium (age 25): $" + ((CarInsurance) carPolicy).calculate_premium(25));
        System.out.println("Car Insurance Premium (age 30, 2 accidents): $" + ((CarInsurance) carPolicy).calculate_premium(30, 2));
    }

    public static class InsurancePolicy {
        public double calculate_premium() {
            return 100.0; 
        }
    }

    public static class HealthInsurance extends InsurancePolicy {
        @Override
        public double calculate_premium() {
            return 150.0; 
        }
    }

    public static class CarInsurance extends InsurancePolicy {
        @Override
        public double calculate_premium() {
            return 200.0; 
        }

        public double calculate_premium(int age_of_driver) {
            if (age_of_driver < 25) {
                return 250.0; 
            } else {
                return 200.0; 
            }
        }

        public double calculate_premium(int age_of_driver, int accident_history) {
            double basePremium = calculate_premium(age_of_driver);
            if (accident_history > 0) {
                basePremium += accident_history * 50;
            }
            return basePremium;
        }
    } 
}
