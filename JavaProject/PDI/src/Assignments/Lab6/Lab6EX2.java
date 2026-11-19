/*2. Method Overriding — “Employee & Manager”
Use Case: A company payroll system needs different bonus calculations.
Goal: Use overridden methods.
Instructions:
• Base class Employee with:
o name, salary
o method: calculate_bonus() → returns 10% of salary
• Derived class Manager overrides bonus → 20%
• Derived class Intern overrides bonus → 5%
Task:
Print the bonus for each type to show polymorphism. */
public class Lab6EX2 {
    public static void main(String[] args) {
        
        Employee employee = new Employee("Alice", 50000);
        System.out.println(employee.getName() + "'s bonus: $" + employee.calculate_bonus());

        Manager manager = new Manager("Bob", 80000);
        System.out.println(manager.getName() + "'s bonus: $" + manager.calculate_bonus());

        Intern intern = new Intern("Charlie", 30000);
        System.out.println(intern.getName() + "'s bonus: $" + intern.calculate_bonus());
    }
    public static class Employee {
        private String name;
        private double salary;

        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public double calculate_bonus() {
            return salary * 0.10; // 10% bonus
        }
    }
    public static class Manager extends Employee {
        public Manager(String name, double salary) {
            super(name, salary);
        }

        @Override
        public double calculate_bonus() {
            return super.calculate_bonus() * 2; // 20% bonus
        }
    }
    public static class Intern extends Employee {
        public Intern(String name, double salary) {
            super(name, salary);
        }

        @Override
        public double calculate_bonus() {
            return super.calculate_bonus() * 0.5; // 5% bonus
        }
    }
}
