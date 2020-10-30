package Morse;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class FileTest {

    @Test
    public void testReadingFile() throws IOException {
        //given
        String fileName = "file:///C:/Users/Sassolig/Studying%20Projects/Bi-weekly-hack-exercises/Morse/src/main/java/Morse/testFile.txt";

        //when
        File file = new File(fileName);
        int size = file.getWords().size();
        //then
        assertEquals(3, size = file.getWords().size());

    }

    @Test
    public void testWordsInFile() throws IOException {
        //given
        String fileName = "file:///C:/Users/Sassolig/Studying%20Projects/Bi-weekly-hack-exercises/Morse/src/main/java/Morse/testFile.txt";

        //when
        File file = new File(fileName);
        List<String> words = file.getWords();

        //then
        assertTrue(words.contains("hello"));
        assertTrue(words.contains("test"));
        assertTrue(words.contains("sos"));

    }


}
