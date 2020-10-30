package Morse;

import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class DictionaryTest {
    private String filename = "https://raw.githubusercontent.com/dolph/dictionary/master/enable1.txt";

    @Test
    public void testletterA() throws IOException {
        //given
        Dictionary morseDictionary = new Dictionary();
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
        File file = new File(this.filename);
        //when
        Dictionary morseDictionary = new Dictionary();
        morseDictionary.WordMorseDictionary(file);
        Map<String, String> wordMorse = morseDictionary.getWordMorseDictionary();

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
    public void testWordNumber() throws IOException {
        //given
        File file = new File(this.filename);
        //when
        Dictionary morseDictionary = new Dictionary();
        morseDictionary.WordMorseDictionary(file);
        Map<String, String> wordMorse = morseDictionary.getWordMorseDictionary();

        //then
        assertEquals(172823,wordMorse.size());

    }
    @Test
    public void testGetMorseWord() throws IOException {
        //given
        File file = new File(this.filename);

        //when
        Dictionary morseDictionary = new Dictionary();
        morseDictionary.MorseWordDictionary(file);
        Map<String, List<String>> morseWord = morseDictionary.getMorseWordDictionary();
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
