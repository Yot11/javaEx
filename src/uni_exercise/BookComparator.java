package uni_exercise;
import java.util.Comparator;



public class BookComparator implements Comparator<Book>{
    String value;

    @Override
    public int compare(Book o1, Book o2) {

        if (o1 == null) {
            return -1;
        } 
        if (o2 == null) {
            return 1;
        }

        switch(value){

            case "comic":
            return o1.getComicValue() - o2.getComicValue();

            case "dramatic":
            return o1.getDramaticValue() - o2.getDramaticValue();

            case "educational":
            return o1.getEducationalValue() - o2.getEducationalValue();

        } 
        return 0;
        
    }

    public BookComparator(String value){
        this.value = value;
        
    }
        
}