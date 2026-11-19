/*5. Using Protected Members — “Library Resources”
Use Case: A library manages different resource types: books, magazines, journals.
Goal: Practice protected attributes and subclass access.
Instructions:
• Base class LibraryItem
o protected: _title, _id
o method: display_info()
• Derived class Book
o method: display_info() → formats book output differently
Task:
Demonstrate how _title is accessible in the subclass but not outside. */
public class Lab6EX5 {
    public static void main(String[] args) {
        Book book = new Book("The Great Gatsby", "B12345");
        book.display_info();
    }
    public static class LibraryItem {
        protected String _title;
        protected String _id;

        public LibraryItem(String title, String id) {
            this._title = title;
            this._id = id;
        }

        public void display_info() {
            System.out.println("Title: " + _title + ", ID: " + _id);
        }
    }
    public static class Book extends LibraryItem {
        public Book(String title, String id) {
            super(title, id);
        }

        @Override
        public void display_info() {
            super.display_info();
            System.out.println("Book Title: " + _title + ", Book ID: " + _id);
        }
    }
    
}
