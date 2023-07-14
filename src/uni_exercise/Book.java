package uni_exercise;

// import java.lang.Object;
public class Book {
    private final String author, title;
    private final int yearOfPublication;
    private int comicValue, currentBorrowerId, dramaticValue, educationalValue;
    

    Book(String bookTitle, String bookAuthor, int bookYearOfPublication, int bookComicValue, int bookDramaticValue, int bookEducationalValue){
        author = bookAuthor;
        title = bookTitle;
        yearOfPublication = bookYearOfPublication;
        comicValue = bookComicValue;
        dramaticValue = bookDramaticValue;
        educationalValue = bookEducationalValue;
    }

    public int getCurrentBorrowerId() {
        return currentBorrowerId;
    }

    public int getComicValue() {
        return comicValue;
    }

    public int getDramaticValue() {
        return dramaticValue;
    }

    public int getEducationalValue() {
        return educationalValue;
    }

    public int getLiteraryValue(){
        return comicValue + dramaticValue + educationalValue;
    }
    void returnBook(int borrowerId){
        currentBorrowerId = -1;
    }
    void setBorrowerId(int borrowerId){
      currentBorrowerId = borrowerId;
    }
   
    public String getTitle() {
        return title;
    }

    @Override
   public String toString() {
       return "[" + "Title: " + title + "\nAuthor: " + author + "\nYear of Publication: " + yearOfPublication + "\ntotal literary value: " + getLiteraryValue() + "]";
   }
   
   @Override
   public boolean equals(Object o){
    if (!(o instanceof Book) && o != null){
        return false;
    }
    Book b = (Book) o; 
    return b.title.equals(this.title);
   }

   
}