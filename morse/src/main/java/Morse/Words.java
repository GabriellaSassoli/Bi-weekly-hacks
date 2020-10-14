package Morse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Words {
    private int numberOfWords;
    Dictionary morseDictionary = new Dictionary();
    File words;
    Map<String, List<String>> morseWordDictionary;
    Map <String, String> wordMorseDictionary;


    public Words(String filename) throws IOException {
        this.words = new File(filename);
        morseDictionary.MorseWordDictionary(this.words);
        morseDictionary.WordMorseDictionary(this.words);
        this.morseWordDictionary = morseDictionary.getMorseWordDictionary();
        this.wordMorseDictionary = morseDictionary.getWordMorseDictionary();
    }

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

    public List<String> getWordsContaining(String uniqueElement){
        List<String> uniqueWords = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : this.morseWordDictionary.entrySet()) {

            if (entry.getKey().contains(uniqueElement)){
                    uniqueWords = entry.getValue();
            }

        }
        return uniqueWords;

    }

    public List<String> getBalancedWord(int numberOfWordLetters){
        List<String> balancedWords = new ArrayList<>();
        int numberOfDots = 0;
        int numberOfDashes = 0;

        for (Map.Entry<String, String> entry : this.wordMorseDictionary.entrySet()) {

            String morse = entry.getValue();

            for(int i= 0; i < morse.length(); i ++){
                if(morse.charAt(i) == '.'){
                    numberOfDots++;
                }else{
                    numberOfDashes++;
                }
            }

            if (numberOfDashes == numberOfDots && entry.getKey().length() == numberOfWordLetters){
                balancedWords.add(entry.getKey());
            }

            numberOfDashes = 0;
            numberOfDots = 0;
        }

        return balancedWords;
    }
}
