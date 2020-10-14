package Morse;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class FindWordTest {

    @Test
    public void testMorseWord13() throws IOException {
        //given
        FindWord findWord = new FindWord();

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

        //when
        int numberOfWords = 10;
        int actualNumberOfWords = findWord.getMorseWord(numberOfWords).size();

        //then
        assertEquals(8, actualNumberOfWords);

    }

    @Test
    public void testGetWordsContaining() throws IOException {
        //given
        FindWord findWord = new FindWord();

        //when
        String characters = "---------------";
        int actualNumberOfWords = findWord.getWordsContaining(characters).size();

        //then
        assertEquals(1, actualNumberOfWords);

    }

    @Test
    public void testGetWordsContaining2() throws IOException {
        //given
        FindWord findWord = new FindWord();

        //when
        String characters = "--------------";

        //then
        assertTrue(findWord.getWordsContaining(characters).contains("autotomous"));

    }

    @Test
    public void testGetBalancedWordContains() throws IOException {
        //given
        FindWord findWord = new FindWord();

        //when
        int numberOfLetters = 21;

        //then
        assertTrue(findWord.getBalancedWord(numberOfLetters).contains("counterdemonstrations"));

    }

    @Test
    public void testGetBalancedWordSize() throws IOException {
        //given
        FindWord findWord = new FindWord();

        //when
        int numberOfLetters = 21;

        //then
        assertEquals(2,findWord.getBalancedWord(numberOfLetters).size());

    }
}
