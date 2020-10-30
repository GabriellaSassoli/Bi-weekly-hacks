package Morse;

import java.io.IOException;
import java.util.*;

public class Words {
    private int numberOfWords;
    Dictionary morseDictionary = new Dictionary();
    File words;
    Map<String, List<String>> morseWordDictionary;
    Map<String, String> wordMorseDictionary;


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

        System.out.println("The morse word are:\n ");
        for (Map.Entry<String, List<String>> entry : this.morseWordDictionary.entrySet()) {
            //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

            if (entry.getValue().size() == numberOfWords) {
                morseWordList.add(entry.getKey());
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }

        return morseWordList;
    }

    public List<String> getWordsContaining(String uniqueElement) {
        List<String> uniqueWords = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : this.morseWordDictionary.entrySet()) {

            if (entry.getKey().contains(uniqueElement)) {
                uniqueWords = entry.getValue();
            }

        }
        return uniqueWords;

    }

    public List<String> getBalancedWord(int numberOfWordLetters) {
        List<String> balancedWords = new ArrayList<>();
        int numberOfDots = 0;
        int numberOfDashes = 0;

        for (Map.Entry<String, String> entry : this.wordMorseDictionary.entrySet()) {

            String morse = entry.getValue();

            for (int i = 0; i < morse.length(); i++) {
                if (morse.charAt(i) == '.') {
                    numberOfDots++;
                } else {
                    numberOfDashes++;
                }
            }

            if (numberOfDashes == numberOfDots && entry.getKey().length() == numberOfWordLetters) {
                balancedWords.add(entry.getKey());
            }

            numberOfDashes = 0;
            numberOfDots = 0;
        }

        return balancedWords;
    }

    public List<String> getPalindromeMorseWord(int numbersOfLetters) {
        List<String> palindromeWords = new ArrayList<>();

        for (Map.Entry<String, String> entry : this.wordMorseDictionary.entrySet()) {
            String word = entry.getKey();
            String morseWord = entry.getValue();

            if (morseWord.equals(new StringBuffer(morseWord).reverse().toString()) && word.length() == numbersOfLetters) {
                palindromeWords.add(word);
                System.out.println("The word " + word + ", that has " + numbersOfLetters + " letters, is palindrome in morse code: " + morseWord);
            }

        }
        return palindromeWords;
    }

    public Collection getUniqueSequence(int numberOfCharacters) {
        ArrayList<String> allSequences = new ArrayList<>();
        ArrayList<String> usedSequences = new ArrayList();
        UniqueWords uniqueWords = new UniqueWords();

        // finding the morse word that have been used
        for (Map.Entry<String, List<String>> entry : this.morseWordDictionary.entrySet()) {
            Integer morseLength = entry.getKey().length();
           if(morseLength.equals(numberOfCharacters)){
                usedSequences.add(entry.getKey());
           }
        }
        // finding all the possible morse word with n characters
        char[] set = { '-', '.' };
        int k = 13;
        allSequences = uniqueWords.printAllKLengthRec(set, "", set.length, k);
        System.out.println(allSequences);
        System.out.println(allSequences.size());

//        for (int i = 0; i < allSequences.size(); i++) {
//            boolean contenido = false;
//            for(int j = 0; j < usedSequences.size(); j++)
//                if(contenido = usedSequences.contains(allSequences.get(i))) break;
//            if(!contenido) System.out.println(iterations13Chars.get(i) + " is not contained in a word");
//        }

        List<String> common = new ArrayList<>(allSequences);
        common.retainAll(usedSequences);

        List<String> diff = new ArrayList<>();
        for(String element : allSequences)
            if(!common.contains(element))
                diff.add(element);

        System.out.println(diff);
        System.out.println(usedSequences);
        System.out.println(usedSequences.size());
        return diff;

    }
}
