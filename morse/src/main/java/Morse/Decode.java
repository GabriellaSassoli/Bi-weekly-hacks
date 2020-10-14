package Morse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Decode{
    private String encodedWord;


    public Decode(String encodedWord){
        this.encodedWord = encodedWord;
    }

    public String getEncodedWord() {
        return encodedWord;
    }

    public String DecodedWord() throws IOException {

        MorseDictionary morseDictionary = new MorseDictionary();
        String[] morseLetters = morseDictionary.getMorseLetters();
//        Map<String, String> dictionary = morseDictionary.getMorseDictionary();
        List<String> decodedWords;
        int lengthDecodedWord= 0;

//        for (int i = 0; i < morseLetters.length; i++){
//            while (lengthDecodedWord < encodedWord.length()){
//                for (int j = 0; j < morseLetters.length; j++){
////                    if(dictionary.get(j) == )
////
////                lengthDecodedWord = lengthDecodedWord + length morse letter
//            }
//        }






        return "Hello Word";
        //        return decodedWord;
    }
}
