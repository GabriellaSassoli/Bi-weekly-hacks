package Morse;


import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MorseDictionary {
    private Map<Character, String> morseDictionary = new HashMap<Character, String>();
    private String[] morseLetters = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-","-.--", "--..", " "};
    private char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '};
    private Map<String, String> wordMorse = new HashMap<String, String>();
    private Map<String, List<String>> morseWord = new HashMap<String, List<String>>();


    public MorseDictionary() throws IOException {

        if (this.morseLetters.length == this.letters.length) {
            for (int i = 0; i <this.morseLetters.length; i++){
                this.morseDictionary.put(this.letters[i], this.morseLetters[i]);
            }
        }
    }

    public char[] getLetters() {
        return letters;
    }

    public String[] getMorseLetters() {
        return morseLetters;
    }

    public Map<Character, String> getMorseDictionary() {
        return this.morseDictionary;
    }

    public Map<String, String> getWordMorse(ReadWordsFromFile words) throws IOException {

        List<String> line = words.getWords();

        for (int i = 0; i < line.size(); i++) {
            Encode encodedword = new Encode(line.get(i));
            String encodedWord = encodedword.EncodeWord();
            this.wordMorse.put(line.get(i), encodedWord);
        }

        return this.wordMorse;
    }

    public Map<String, List<String>> getMorseWord(ReadWordsFromFile words) throws IOException {

        List<String> line = words.getWords();

        for (int i = 0; i < line.size(); i++) {
            String word = line.get(i);
            Encode encodedword = new Encode(word);
            String encodedWord = encodedword.EncodeWord();

            if (this.morseWord.containsKey(encodedWord)) {
                this.morseWord.get(encodedWord).add(word);
            } else {
                this.morseWord.put(encodedWord, new ArrayList<String>());
                this.morseWord.get(encodedWord).add(word);
            }
            //this.morseWord.put(encodedword.EncodeWord(),inputLine);
//            System.out.println(word + encodedWord);

        }

//        System.out.println(morseWord);
        return this.morseWord;
    }



}
