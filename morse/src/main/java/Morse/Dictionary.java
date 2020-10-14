package Morse;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
    private Map<Character, String> morseDictionary = new HashMap<Character, String>();
    private String[] morseLetters = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-","-.--", "--..", " "};
    private char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '};
    private Map<String, String> wordMorse = new HashMap<String, String>();
    private Map<String, List<String>> morseWord = new HashMap<String, List<String>>();


    public Dictionary() throws IOException {

        if (this.morseLetters.length == this.letters.length) {
            for (int i = 0; i <this.morseLetters.length; i++){
                this.morseDictionary.put(this.letters[i], this.morseLetters[i]);
            }
        }
    }

//    public char[] getLetters() {
//        return letters;
//    }
//
//    public String[] getMorseLetters() {
//        return morseLetters;
//    }

    public Map<Character, String> getMorseDictionary() {
        return this.morseDictionary;
    }

    public void WordMorseDictionary(File words) throws IOException {

        List<String> line = words.getWords();

        for (String word : line) {
            Translator encodedword = new Translator(word);
            String encodedWord = encodedword.Encode();
            this.wordMorse.put(word, encodedWord);
        }

    }

    public Map<String, String> getWordMorseDictionary(){
        return this.wordMorse;
    }

    public void MorseWordDictionary(File words) throws IOException {
        List<String> line = words.getWords();

        for (String word : line) {
            Translator encodedword = new Translator(word);
            String encodedWord = encodedword.Encode();

            if (this.morseWord.containsKey(encodedWord)) {
                this.morseWord.get(encodedWord).add(word);
            } else {
                this.morseWord.put(encodedWord, new ArrayList<String>());
                this.morseWord.get(encodedWord).add(word);
            }

        }

    }

    public Map<String, List<String>> getMorseWordDictionary()  {
        return this.morseWord;
    }

}
