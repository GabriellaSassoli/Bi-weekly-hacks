package Morse;

import org.junit.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MorseDictionaryTest {

    @Test
    public void testletterA() throws IOException {
        //given
        MorseDictionary morseDictionary = new MorseDictionary();
       //when
        //then
        System.out.println(morseDictionary.getMorseDictionary().get('a'));
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

        //then
        assertEquals(sos,wordMorse.get("sos"));
        assertEquals(daily, wordMorse.get("daily"));
        assertEquals(programmer, wordMorse.get("programmer"));
        assertEquals(bits, wordMorse.get("bits"));
        assertEquals(three, wordMorse.get("three"));


    }

    @Test
    public void testGetMorseWord(){
        //to do
    }

    @Test
    public void otherTest(){
        //to do
    }
}
