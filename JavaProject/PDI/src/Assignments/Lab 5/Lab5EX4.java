/*Write a Java program to demonstrate a constructor by
initializing attributes of an Employee class. Provide at
least 5 attributes to describe an employee.
Use private attributes in a class and provide public getter
and setter methods. Test your program in main. */
public class Lab5EX4 {
    private String name;
    private int age;
    private String department;
    private double salary;
    private String position;

    public Lab5EX4(String name, int age, String department, double salary, String position) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    public static void main(String[] args) {
        Lab5EX4 employee = new Lab5EX4("John Doe", 30, "IT", 60000.0, "Software Engineer");
        System.out.println("Employee Details:");
        System.out.println("Name: " + employee.getName());
        System.out.println("Age: " + employee.getAge());
        System.out.println("Department: " + employee.getDepartment());
        System.out.println("Salary: $" + employee.getSalary());
        System.out.println("Position: " + employee.getPosition());

        employee.setAge(31);
        employee.setSalary(65000.0);
        System.out.println("\nUpdated Employee Details:");
        System.out.println("Name: " + employee.getName());
        System.out.println("Age: " + employee.getAge());
        System.out.println("Department: " + employee.getDepartment());
        System.out.println("Salary: $" + employee.getSalary());
        System.out.println("Position: " + employee.getPosition());
    }
}
