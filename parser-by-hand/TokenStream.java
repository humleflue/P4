import java.util.ArrayList;

public class TokenStream {
    private ArrayList<String> tokens;
    private int index = 0;

    public TokenStream(ArrayList<String> tokens) {
        this.tokens = tokens;
    }

    public String peek() {
        return tokens.get(this.index);
    }
    
    public void advance() {
        this.index++;
    }
}