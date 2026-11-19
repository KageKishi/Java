/*6. Hierarchical Inheritance — “Shape → Circle, Rectangle, Triangle”
Use Case: A drawing application must compute areas of different shapes.
Goal: Use one parent with multiple children.
Instructions:
• Base: Shape
o method: area() → returns 0 (default)
• Child: Circle
• Child: Rectangle
• Child: Triangle
• Each child overrides area().
Task:
Store different shape objects in a list and print their areas. */
public class Lab6EX6 {
    public static void main(String[] args) {
        
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5); 
        shapes[1] = new Rectangle(4, 6); 
        shapes[2] = new Triangle(3, 4);

        for (Shape shape : shapes) {
            System.out.println("Area: " + shape.area());
        }
    }
    public static class Shape {
        public double area() {
            return 0; 
        }
    }
    public static class Circle extends Shape {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double area() {
            return Math.PI * radius * radius;
        }
    }
    public static class Rectangle extends Shape {
        private double width;
        private double height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public double area() {
            return width * height; 
        }
    }
    public static class Triangle extends Shape {
        private double base;
        private double height;

        public Triangle(double base, double height) {
            this.base = base;
            this.height = height;
        }

        @Override
        public double area() {
            return 0.5 * base * height; 
        }
    }
}
