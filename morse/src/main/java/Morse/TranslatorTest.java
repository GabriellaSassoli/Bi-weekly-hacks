package Morse;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class TranslatorTest {
    @Test public void testEncode() throws IOException {
        //given
        Translator encodesos = new Translator("sos");
        Translator encodedaily = new Translator("daily");
        Translator encodeprogrammer = new Translator("programmer");
        Translator encodebits = new Translator("bits");
        Translator encodethree = new Translator("three");

        //when
        //then
        assertEquals("...---...",encodesos.Encode() );
        assertEquals("-...-...-..-.--",encodedaily.Encode() );
        assertEquals(".--..-.-----..-..-----..-.",encodeprogrammer.Encode() );
        assertEquals("-.....-...",encodebits.Encode() );
        assertEquals("-.....-...",encodethree.Encode() );

    }

    @Test public void testEncodeCapitals() throws IOException {
        //given
        Translator encode = new Translator("SOS");
        //when
        //then
        assertEquals("...---...",encode.Encode() );

    }

    @Test public void testWrongAnswer() throws IOException {
        //given
        Translator encode = new Translator("SOS");
        //when
        //then
        assertNotEquals(".--..-.-----..-..-----..-.",encode.Encode() );

    }
}
