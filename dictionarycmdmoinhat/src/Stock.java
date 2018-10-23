import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author giasutinhoc.vn
 */
public class Stock implements Serializable{
    private Word word = new Word();

    public Stock(String a, String b) {
        word.setWord(a);
        word.setMean(b);
    }

    @Override
    public String toString() {
        return word.getWord() + "-" + word.getMean();
    }
}