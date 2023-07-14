package uni_exercise;


public class Main {
    public static void main(String[] args){

        Library library = new Library(2, 1, 20); // Example values for max capacities
        
        Book newBook = new Book("New Book", "Author", 2023, 5, 4, 3);

        Book newBook2 = new Book("New Book2", "Author", 2023, 5, 4, 3);
        
        library.addBookToLibrary(newBook);
        library.addBookToLibrary(newBook2);

        library.borrwBook(1,"New Book");

        boolean isBookAvilble = library.isBookAvailable("New Book");

        if (isBookAvilble) {
            System.out.println("book avilble");           
        } else{
            System.out.println("book unavilble");
        }

        Book bookToCheck = new Book("New Book", "Author", 2023, 5, 4, 3);
        boolean isBookValid = library.isBookValid(bookToCheck);

        if (isBookValid) {
            System.out.println("book is valid");          
        } else {
            System.out.println("book is invalid");
        }
    }

    
    
}
