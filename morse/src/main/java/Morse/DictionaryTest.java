package Morse;

import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class MorseDictionaryTest {

    @Test
    public void testletterA() throws IOException {
        //given
        MorseDictionary morseDictionary = new MorseDictionary();
       //when
        //then
        assertEquals(".-", morseDictionary.getMorseDictionary().get('a') );
        assertEquals( "-..", morseDictionary.getMorseDictionary().get('d'));
        assertEquals("....",morseDictionary.getMorseDictionary().get('h'));
        assertEquals(".--.",morseDictionary.getMorseDictionary().get('p'));

    }

    @Test
    public void testGetWordMorse() throws IOException {
        //given
        ReadWordsFromFile file = new ReadWordsFromFile();
        //when
        MorseDictionary morseDictionary = new MorseDictionary();
        Map<String, String> wordMorse = morseDictionary.getWordMorse(file);
        String sos = "...---..."; //sos
        String daily = "-...-...-..-.--";
        String programmer = ".--..-.-----..-..-----..-.";
        String bits = "-.....-...";
        String three = "-.....-...";
        String autonomous = ".-..--------------..-...";

        //then
        assertEquals(sos,wordMorse.get("sos"));
        assertEquals(daily, wordMorse.get("daily"));
        assertEquals(programmer, wordMorse.get("programmer"));
        assertEquals(bits, wordMorse.get("bits"));
        assertEquals(three, wordMorse.get("three"));
        assertNotEquals(three, wordMorse.get("sos"));
        assertEquals(autonomous,wordMorse.get("autotomous"));

    }

    @Test
    public void testGetMorseWord() throws IOException {
        //given
        ReadWordsFromFile file = new ReadWordsFromFile();

        //when
        MorseDictionary morseDictionary = new MorseDictionary();
        Map<String, List<String>> morseWord = morseDictionary.getMorseWord(file);
   ;

        //then
        assertTrue(morseWord.get("...---...").contains("sos"));
        assertTrue( morseWord.get("-...-...-..-.--").contains("daily"));
        assertTrue(morseWord.get(".--..-.-----..-..-----..-.").contains("programmer"));
        assertTrue(morseWord.get("-.....-...").contains("bits"));
        assertTrue(morseWord.get("-.....-...").contains("three"));
    }

//    @Test
//    public void otherTest(){
//        //to do
//    }
}
