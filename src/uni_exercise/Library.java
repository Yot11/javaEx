package uni_exercise;

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
        
        currentOpenBookSpot = 0;
        currentOpenPatronSpot = 0;

        bookArray = new Book[maxBookCapacity];
        bookBorrowStatus = new boolean[maxBookCapacity];
        
        numOfBorrowedBooksPerPatronArray = new int[maxPatronCapacity];
        patronArray = new Patron[maxPatronCapacity];
        
    }
    public void addBookToLibrary (Book book){
        if(currentOpenBookSpot < bookArray.length){
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

    public void borrwBook(int borrowerId, String bookTitle) {
        // for (int i = 0; i < bookBorrowStatus.length; i++) {
        //         bookBorrowerId[i] = 0;
        //     }

        int bookRequestedId = findBookIdByTitle(bookTitle);
        if(bookRequestedId >= 0 && bookRequestedId < currentOpenBookSpot && !bookBorrowStatus[bookRequestedId]){
            if(numOfBorrowedBooksPerPatronArray[borrowerId] < libMaxBorrowedBooks){
                bookBorrowStatus[bookRequestedId] = false;
                // bookBorrowerId[bookRequestedId] = borrowerId;
                numOfBorrowedBooksPerPatronArray[borrowerId]++;
                // System.out.println("the book" + bookTitle +" was borrowed successfully.");
            } else {
                // System.out.println("you canot borrow this meny books");
            }
        } else {
            // System.out.println("this book is not avalble for borrowing");
        }
    }

    public int getPatronId(Patron patron) {
        for (int i = 0; i < currentOpenPatronSpot; i++) {
            if (patronArray[i].equals(patron)) {
                return i; 
            }
        }
        return -1;
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

    public boolean isPatronIdValid(int patronId){
         for (int i = 0; i < patronArray.length; i++) {
            if (patronId == patronArray[i].getPatronId()) {
                return true;
            }
        }
        return false;
    }
// get patron id 
    
    public void addPatronToLibrary (Patron patron){
        if(currentOpenPatronSpot < patronArray.length){
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
            bookBorrowStatus[bookRequestedId] = false;
        }
         
    }


}
