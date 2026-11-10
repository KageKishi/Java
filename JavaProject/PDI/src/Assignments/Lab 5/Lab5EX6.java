/*Design two classes Rectangle (methods to calculate
area and perimeter), and Circle (methods to find
surface and perimeter). Use encapsulation to
manage width and height for Rectangle. Also use
encapsulation to manage radius for the Circle. Test
these classes in Main. */
public class Lab5EX6 {
    public static class Rectangle {
        private double width;
        private double height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        public double calculateArea() {
            return width * height;
        }

        public double calculatePerimeter() {
            return 2 * (width + height);
        }
    }
    public static class Circle {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public double calculateSurfaceArea() {
            return Math.PI * radius * radius;
        }

        public double calculatePerimeter() {
            return 2 * Math.PI * radius;
        }
    }
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(utilities.ValidateDouble("Enter the width of the rectangle: "), utilities.ValidateDouble("Enter the height of the rectangle: "));
        System.out.println("Rectangle Area: " + rectangle.calculateArea());
        System.out.println("Rectangle Perimeter: " + rectangle.calculatePerimeter());

        Circle circle = new Circle(utilities.ValidateDouble("Enter the radius of the circle: "));
        System.out.println("Circle Surface Area: " + circle.calculateSurfaceArea());
        System.out.println("Circle Perimeter: " + circle.calculatePerimeter());
    }
}
