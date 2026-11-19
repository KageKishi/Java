/*Challenge 9: Multiple Levels + Overriding + Abstract — “Academic Roles”
Goal: Build a complex inheritance chain.
Instructions:
• Person → Employee → Teacher → MathTeacher, ScienceTeacher
• Override:
o work()
o get_role()
• Make Teacher abstract.
Task:
Demonstrate polymorphism by calling methods through base references. */
public class Lab6CH9 {
    public static void main(String[] args){
        Person person = new Person();
        person.work();
        System.out.println("Role: " + person.get_role());

        Employee employee = new Employee();
        employee.work();
        System.out.println("Role: " + employee.get_role());

        Teacher mathTeacher = new MathTeacher();
        mathTeacher.work();
        System.out.println("Role: " + mathTeacher.get_role());
    }
    public static class Person {
        public void work() {
            System.out.println("Person is working.");
        }

        public String get_role() {
            return "Person";
        }
    }
    public static class Employee extends Person {
        @Override
        public void work() {
            System.out.println("Employee is working.");
        }

        @Override
        public String get_role() {
            return "Employee";
        }
    }
    public static abstract class Teacher extends Employee {
        @Override
        public void work() {
            System.out.println("Teacher is teaching.");
        }

        @Override
        public String get_role() {
            return "Teacher";
        }
    }
    public static class MathTeacher extends Teacher {
        @Override
        public void work() {
            System.out.println("Math Teacher is teaching math.");
        }

        @Override
        public String get_role() {
            return "Math Teacher";
        }
    }
}
