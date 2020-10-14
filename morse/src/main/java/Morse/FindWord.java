package Morse;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindWord {
    private int numberOfWords;
    MorseDictionary morseDictionary = new MorseDictionary();
    ReadWordsFromFile words = new ReadWordsFromFile();
    Map<String, List<String>> morseWordDictionary = morseDictionary.getMorseWord(words);


    public FindWord() throws IOException {}

    public ArrayList<String> getMorseWord(int numberOfWords) throws IOException {

        this.numberOfWords = numberOfWords;
        ArrayList<String> morseWordList = new ArrayList<String>();

        System.out.println("The morse word are:\n " );
        for (Map.Entry<String, List<String>> entry : this.morseWordDictionary.entrySet()) {
            //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

            if(entry.getValue().size() == numberOfWords){
                morseWordList.add(entry.getKey());
                System.out.println(entry.getKey() + ": " +  entry.getValue());
            }
        }

        return morseWordList;
    }

    public List<String> getUniqueWord(String uniqueElement){
        List<String> uniqueWords = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : this.morseWordDictionary.entrySet()) {

            if (entry.getKey().contains(uniqueElement)){
                    uniqueWords = entry.getValue();
            }

        }
        return uniqueWords;

    }
}
