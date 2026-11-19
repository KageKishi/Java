/*3. Multi-Level Inheritance — “Person → Student → OnlineStudent”
Use Case: A university system has different student types.
Goal: Build a multi-level class chain.
Instructions:
• Base: Person → name
• Derived: Student → student_id
• Derived: OnlineStudent → zoom_id
Task:
Instantiate OnlineStudent and confirm it inherits all data from both parent classes.
 */
public class Lab6EX3 {
    public static void main(String[] args) {
        
        OnlineStudent onlineStudent = new OnlineStudent("David", "S12345", "Z67890");
        System.out.println("Name: " + onlineStudent.getName());
        System.out.println("Student ID: " + onlineStudent.getStudentId());
        System.out.println("Zoom ID: " + onlineStudent.getZoomId());
    }
    public static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
    public static class Student extends Person {
        private String student_id;

        public Student(String name, String student_id) {
            super(name);
            this.student_id = student_id;
        }

        public String getStudentId() {
            return student_id;
        }
    }
    public static class OnlineStudent extends Student {
        private String zoom_id;

        public OnlineStudent(String name, String student_id, String zoom_id) {
            super(name, student_id);
            this.zoom_id = zoom_id;
        }

        public String getZoomId() {
            return zoom_id;
        }
    }
}
