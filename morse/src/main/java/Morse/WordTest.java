package Morse;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class WordTest {
    private String filename = "https://raw.githubusercontent.com/dolph/dictionary/master/enable1.txt";
    @Test
    public void testMorseWord13() throws IOException {
        //given
        Words findWord = new Words(this.filename);

        //when
        int numberOfWords = 13;
        int actualNumberOfWords = findWord.getMorseWord(numberOfWords).size();

        //then
        assertEquals(1, actualNumberOfWords);

    }

    @Test
    public void testMorseWordWrong() throws IOException {
        //given
        Words findWord = new Words(this.filename);

        //when
        int numberOfWords = 13;
        int actualNumberOfWords = findWord.getMorseWord(numberOfWords).size();

        //then
        assertNotEquals(13, actualNumberOfWords);

    }

    @Test
    public void testMorseWord10() throws IOException {

        //given
        Words findWord = new Words(this.filename);

        //when
        int numberOfWords = 10;
        int actualNumberOfWords = findWord.getMorseWord(numberOfWords).size();

        //then
        assertEquals(8, actualNumberOfWords);

    }

    @Test
    public void testGetWordsContaining() throws IOException {
        //given
        Words findWord = new Words(this.filename);

        //when
        String characters = "---------------";
        int actualNumberOfWords = findWord.getWordsContaining(characters).size();

        //then
        assertEquals(1, actualNumberOfWords);

    }

    @Test
    public void testGetWordsContaining2() throws IOException {
        //given
        Words findWord = new Words(this.filename);

        //when
        String characters = "--------------";

        //then
        assertTrue(findWord.getWordsContaining(characters).contains("autotomous"));

    }

    @Test
    public void testGetBalancedWordContains() throws IOException {
        //given
        Words findWord = new Words(this.filename);

        //when
        int numberOfLetters = 21;

        //then
        assertTrue(findWord.getBalancedWord(numberOfLetters).contains("counterdemonstrations"));

    }

    @Test
    public void testGetBalancedWordSize() throws IOException {
        //given
        Words findWord = new Words(this.filename);

        //when
        int numberOfLetters = 21;

        //then
        assertEquals(2,findWord.getBalancedWord(numberOfLetters).size());

    }

    @Test
    public void testGetPalindromeMorseWord() throws IOException {
        //given
        Words findWord = new Words(this.filename);

        //when
        int numberOfLetters = 12;

        //then
        assertTrue(findWord.getPalindromeMorseWord(numberOfLetters).contains("protectorate"));
    }

    @Test
    public void testGetPalindromeMorseWord13() throws IOException {
        //given
        Words findWord = new Words(this.filename);

        //when
        int numberOfLetters = 13;

        //then
        assertEquals(1,findWord.getPalindromeMorseWord(numberOfLetters).size());
    }

    @Test
    public void testGetUniqueSequence() throws IOException {
        //given
        Words findWord = new Words(this.filename);
        int numberOfCharacters = 13;

        //then
        assertEquals(5,findWord.getUniqueSequence(numberOfCharacters).size());
    }

    @Test
    public void testGetUniqueSequenceWord() throws IOException {
        //given
        Words findWord = new Words(this.filename);
        int numberOfCharacters = 13;

        //then
        assertTrue(findWord.getUniqueSequence(numberOfCharacters).contains("--.---.---.--"));
    }
}
