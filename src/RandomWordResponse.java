import java.util.*;

public class RandomWordResponse {
    private List<String> words;
    
    public RandomWordResponse() {
        this.words = new ArrayList<>();
    }
    
    public RandomWordResponse(final List<String> words) {
        this.words = words;
    }
    
    public List<String> getWords() {
        return words;
    }
    
    public void addWord(final String word) {
        this.words.add(word);
    }
}