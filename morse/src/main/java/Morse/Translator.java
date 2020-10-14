package Morse;

import java.io.IOException;

public class Translator {
    private String encodedWord;
    private String word;

    public Translator(String word){
        this.word = word.toLowerCase();
    }

//    public String Decode() throws IOException {
//
//        MorseDictionary morseDictionary = new MorseDictionary();
//        String[] morseLetters = morseDictionary.getMorseLetters();
////        Map<String, String> dictionary = morseDictionary.getMorseDictionary();
//        List<String> decodedWords;
//        int lengthDecodedWord= 0;
//
////        for (int i = 0; i < morseLetters.length; i++){
////            while (lengthDecodedWord < encodedWord.length()){
////                for (int j = 0; j < morseLetters.length; j++){
//////                    if(dictionary.get(j) == )
//////
//////                lengthDecodedWord = lengthDecodedWord + length morse letter
////            }
////        }
//
//        return "Hello Word";
//        //        return decodedWord;
//    }


    public String Encode() throws IOException {
        StringBuilder encodedWord = new StringBuilder();
        Dictionary morseDictionary = new Dictionary();

        for (  int i = 0 ; i < this.word.length(); i++){
            encodedWord.append(morseDictionary.getMorseDictionary().get(word.charAt(i)));
        }

        return encodedWord.toString();
    }
}
