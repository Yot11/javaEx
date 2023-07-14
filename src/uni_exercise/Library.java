package uni_exercise;

import java.util.Arrays;
import java.util.Comparator;

public class Library {
    Book[] bookArray;
    boolean[] bookBorrowStatus;
    // long[] bookBorrowerId;
    int currentOpenBookSpot;
    int currentOpenPatronSpot;
    final int libMaxBookCapacity;
    final int libMaxBorrowedBooks;
    final int libMaxPatronCapacity;
    int[] numOfBorrowedBooksPerPatronArray;
    Patron[] patronArray;
    
    public Library(int maxBookCapacity, int maxBorrowedBooks, int maxPatronCapacity) {
        libMaxBookCapacity = maxBookCapacity;
        libMaxBorrowedBooks = maxBorrowedBooks;
        libMaxPatronCapacity = maxPatronCapacity;
        bookArray = new Book[libMaxBookCapacity];

        
        currentOpenBookSpot = 0;
        currentOpenPatronSpot = 0;

        bookArray = new Book[maxBookCapacity];
        bookBorrowStatus = new boolean[maxBookCapacity];
        
        numOfBorrowedBooksPerPatronArray = new int[maxPatronCapacity];
        patronArray = new Patron[maxPatronCapacity];
        
    }
    public void addBookToLibrary (Book book){
        if(currentOpenBookSpot < libMaxBookCapacity){
            boolean isBookAlredyInLibrary = false;
            for (int i = 0; i < currentOpenBookSpot; i++) {
               if(bookArray[i].equals(book)){
                isBookAlredyInLibrary = true;
                break;
               } 

            }
            if(!isBookAlredyInLibrary){
                bookArray[currentOpenBookSpot] = book;
                bookBorrowStatus[currentOpenBookSpot] = false;
                currentOpenBookSpot++;
                // System.out.println("the book" +book+ " has bean aded sucsesfuly");
            } else {
                // System.out.println("this book alredy exists in ouer system");
            }
        } else {
            // System.out.println("there is no more room in the library");
        } 
    }

    public int findBookIdByTitle(String bookTitle) {
        for (int i = 0; i < currentOpenBookSpot; i++) {
            if (bookArray[i].getTitle().equals(bookTitle)) {
                return i;
            }
        }
        return -1; 
    }

   public void borrwBook(String bookTitle, String userName) {
    int borrowerId = findPatronIdByUserName(userName);
    if (borrowerId >= 0) { // Check if patron is found
        int bookRequestedId = findBookIdByTitle(bookTitle);
        if (bookRequestedId >= 0 && bookRequestedId < currentOpenBookSpot && !bookBorrowStatus[bookRequestedId]) {
            if (numOfBorrowedBooksPerPatronArray[borrowerId] < libMaxBorrowedBooks) {
                bookBorrowStatus[bookRequestedId] = false;
                numOfBorrowedBooksPerPatronArray[borrowerId]++;
                System.out.println("The book " + bookTitle + " was borrowed successfully.");
            } else {
                // System.out.println("You cannot borrow this many books.");
            }
        } else {
            // System.out.println("This book is not available for borrowing.");
        }
    } else {
        System.out.println("Patron not found.");
    }
}


    public int findPatronIdByUserName(String userName) {
        for (int i = 0; i < currentOpenPatronSpot; i++) {
            if (patronArray[i].getUserName().equals(userName)) {
                return i;
            }
        }
        return -1; 
    }

    public int findPatronIdByUserName(Patron patron) {
       return findPatronIdByUserName(patron.getUserName());
    }

    public boolean isBookAvailable(String bookTitle){
        int bookRequestedId = findBookIdByTitle(bookTitle);
        if (!bookBorrowStatus[bookRequestedId]) {
            return false;
        } else {return true;}
    }

    // make simpler
    public boolean isBookValid (Book book){
        return isBookValid(book.getTitle());
    }

    public boolean isBookValid (String bookTitle){
        for (int i = 0; i < bookArray.length; i++) {
            if (bookArray[i].getTitle().equals(bookTitle)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPatronIdValid(String userName){
         for (int i = 0; i < patronArray.length; i++) {
            if (userName == patronArray[i].getUserName()) {
                return true;
            }
        }
        return false;
    }
// get patron id 
    
    public void registerPatronToLibrary (Patron patron){
        
        if(currentOpenPatronSpot < libMaxPatronCapacity){
            boolean ispatronAlredyInLibrary = false;
            for (int i = 0; i < currentOpenPatronSpot; i++) {
               if(patronArray[i].equals(patron)){
                ispatronAlredyInLibrary = true;
                break;
               } 

            }
            if(!ispatronAlredyInLibrary){
                patronArray[currentOpenPatronSpot] = patron;
                currentOpenPatronSpot++;
                // System.out.println("the patron" +patron+ " has bean aded sucsesfuly");
            } else {
                // System.out.println("this patron alredy exists in ouer system");
            }
        } else {
            // System.out.println("there is no more room in the library");
        } 
    }
    
    public void returnBook(String bookTitle){
        int bookRequestedId = findBookIdByTitle(bookTitle);
        if (isBookValid(bookTitle)) {
            bookBorrowStatus[bookRequestedId] = true;
        }
         
    }

    // can be alot better. fore example get the sum fo all the digrent valu tips of the book and then sugest the patron books based on what he likes.
    // public void suggestBookToPatron(int patronId){
    //     for (int i = 0; i < bookArray.length; i++) {
    //         if (bookArray[i].getLiteraryValue()<3) {
    //             System.out.println(bookArray[i] + "is not verry good");
    //         } else if (bookArray[i].getLiteraryValue()<7) {
    //             System.out.println(bookArray[i] + "is good");
    //         } else {
    //             System.out.println(bookArray[i] + "is verry good");
    //         }
    //     }
    // }
    public void sortBooksByValue(String value) {
    switch (value) {
        case "comic":
            Arrays.sort(bookArray, 0, currentOpenBookSpot, Comparator.nullsLast(Comparator.comparingInt(Book::getComicValue).reversed()));
            break;
        case "dramatic":
            Arrays.sort(bookArray, 0, currentOpenBookSpot, Comparator.nullsLast(Comparator.comparingInt(Book::getDramaticValue).reversed()));
            break;
        case "educational":
            Arrays.sort(bookArray, 0, currentOpenBookSpot, Comparator.nullsLast(Comparator.comparingInt(Book::getEducationalValue).reversed()));
            break;
        default:
            System.out.println("Invalid value provided.");
            break;
    }
}

    public void suggestHighestValuedBooks(String value, int count) {
        sortBooksByValue(value);

        int booksToPrint = Math.min(count, currentOpenBookSpot);
        System.out.println("Printing " + booksToPrint + " highest valued books by " + value + ":");

        for (int i = 0; i < booksToPrint; i++) {
            System.out.println(bookArray[i]);
        }
    }



}
