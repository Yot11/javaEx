package uni_exercise;

public class Patron {
    
     
    // int[] favoriteGenre = {1,3,4,5,4};
    int comicWeight;
    int dramaticWeight;
    int educationalWeight;
    int enjoymentThreshold;
    final String firstName;
    final String lastName;
    final String userName;

    // Constructor
    public Patron(int comicWeight, int dramaticWeight, int educationalWeight, int enjoymentThreshold, String firstName, String lastName, String userName) {
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.comicWeight = comicWeight;
        this.dramaticWeight = dramaticWeight;
        this.educationalWeight = educationalWeight;
        this.enjoymentThreshold = enjoymentThreshold;
    }
    

    public String getUserName(){
        return userName;
    }

    public int getComicWeight() {
        return comicWeight;
    }

    public int getDramaticWeight() {
        return dramaticWeight;
    }

    public int getEducationalWeight() {
        return educationalWeight;
    }

    public int getEnjoymentThreshold() {
        return enjoymentThreshold;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    
    int getBookScore(Book book) {
        int comicValue = book.getComicValue();
        int dramaticValue = book.getDramaticValue();
        int educationalValue = book.getEducationalValue();

        int literaryValue = (comicWeight * comicValue) + (dramaticWeight * dramaticValue) + (educationalWeight * educationalValue);

        return literaryValue;
    }

    String stringRepresentation() {
        return firstName + " " + lastName;
    }

    public boolean willEnjoyBook(Book book){
        if(comicWeight > book.getComicValue() && dramaticWeight > book.getDramaticValue() && educationalWeight > book.getEducationalValue()){
            return true;
        } else {
            return false;
        }
    }

    

}
