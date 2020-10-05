package Morse;

import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FindWordTest {

    @Test
    public void testMorseWord13() throws IOException {
        //given
        FindWord findWord = new FindWord();
        ReadWordsFromFile file = new ReadWordsFromFile();
        MorseDictionary morseDictionary = new MorseDictionary();
        Map<String, List<String>> morseWord= morseDictionary.getMorseWord(file);

        //when
        int numberOfWords = 13;
        int actualNumberOfWords = findWord.getMorseWord(numberOfWords).size();

        //then
        assertEquals(1, actualNumberOfWords);

    }

    @Test
    public void testMorseWordWrong() throws IOException {
        //given
        FindWord findWord = new FindWord();
        ReadWordsFromFile file = new ReadWordsFromFile();
        MorseDictionary morseDictionary = new MorseDictionary();
        Map<String, List<String>> morseWord= morseDictionary.getMorseWord(file);

        //when
        int numberOfWords = 13;
        int actualNumberOfWords = findWord.getMorseWord(numberOfWords).size();

        //then
        assertNotEquals(13, actualNumberOfWords);

    }

    @Test
    public void testMorseWord10() throws IOException {
        //given
        FindWord findWord = new FindWord();
        ReadWordsFromFile file = new ReadWordsFromFile();
        MorseDictionary morseDictionary = new MorseDictionary();
        Map<String, List<String>> morseWord= morseDictionary.getMorseWord(file);

        //when
        int numberOfWords = 10;
        int actualNumberOfWords = findWord.getMorseWord(numberOfWords).size();

        //then
        assertEquals(8, actualNumberOfWords);

    }
}
