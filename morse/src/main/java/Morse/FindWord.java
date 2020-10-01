package Morse;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindWord {
    private int numberOfWords;


    public FindWord(){}

    public ArrayList<String> getMorseWord(int numberOfWords, Map<String, List<String>> morseWordDictionary) throws IOException {
        this.numberOfWords = numberOfWords;
        ArrayList<String> morseWord = new ArrayList<String>();

        for (Map.Entry<String, List<String>> entry : morseWordDictionary.entrySet()) {
            //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

            if(entry.getValue().size() == numberOfWords){
                morseWord.add(entry.getKey());
            }
        }

        System.out.println("The morse word is " + morseWord);

        return morseWord;
    }
}
