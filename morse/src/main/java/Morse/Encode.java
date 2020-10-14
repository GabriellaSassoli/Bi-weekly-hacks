package Morse;

import java.io.IOException;
import java.util.List;

public class Encode {
    private StringBuilder encodedWord = new StringBuilder();
    private String word;

    public Encode(String word){
        this.word = word.toLowerCase();
    }

    public String EncodeWord() throws IOException {

        MorseDictionary morseDictionary = new MorseDictionary();

        for (  int i = 0 ; i < this.word.length(); i++){
            encodedWord.append(morseDictionary.getMorseDictionary().get(word.charAt(i)));
        }

        return encodedWord.toString();
    }

}
