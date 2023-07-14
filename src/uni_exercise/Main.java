package uni_exercise;

public class Main {
    public static void main(String[] args) {
        Library library = new Library(100, 5, 50); // Create a library object

        // Create some books
        Book book1 = new Book("Title 1", "Author 1", 2000, 5, 7, 5);
        Book book2 = new Book("Title 2", "Author 2", 2010, 4, 8, 6);
        Book book3 = new Book("Title 3", "Author 3", 2020, 2, 9, 7);

        // Add books to the library
        library.addBookToLibrary(book1);
        library.addBookToLibrary(book2);
        library.addBookToLibrary(book3);

        // Create some patrons
        Patron patron1 = new Patron(2, 3, 4, 6, "John", "Doe", "john.doe");
        Patron patron2 = new Patron(1, 2, 5, 7, "Jane", "Smith", "jane.smith");

        // Register patrons to the library
        library.registerPatronToLibrary(patron1);
        library.registerPatronToLibrary(patron2);

        // Borrow books
        library.borrwBook("Title 1", "john.doe");
        library.borrwBook("Title 2", "jane.smith");

        // Return books
        library.returnBook("Title 1");
        library.returnBook("Title 2");

        // Check book availability
        boolean book1Available = library.isBookAvailable("Title 1");
        boolean book2Available = library.isBookAvailable("Title 2");

        System.out.println("Book 1 available: " + book1Available);
        System.out.println("Book 2 available: " + book2Available);

        // Suggest highest valued books to a patron
        library.suggestHighestValuedBooks("comic", 2);
    }
}
