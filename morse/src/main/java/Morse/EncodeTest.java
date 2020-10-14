package Morse;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class EncodeTest {
    @Test public void testEncode() throws IOException {
        //given
        Encode encodesos = new Encode("sos");
        Encode encodedaily = new Encode("daily");
        Encode encodeprogrammer = new Encode("programmer");
        Encode encodebits = new Encode("bits");
        Encode encodethree = new Encode("three");

        //when
        //then
        assertEquals("...---...",encodesos.EncodeWord() );
        assertEquals("-...-...-..-.--",encodedaily.EncodeWord() );
        assertEquals(".--..-.-----..-..-----..-.",encodeprogrammer.EncodeWord() );
        assertEquals("-.....-...",encodebits.EncodeWord() );
        assertEquals("-.....-...",encodethree.EncodeWord() );

    }

    @Test public void testEncodeCapitals() throws IOException {
        //given
        Encode encode = new Encode("SOS");
        //when
        //then
        assertEquals("...---...",encode.EncodeWord() );

    }

    @Test public void testWrongAnswer() throws IOException {
        //given
        Encode encode = new Encode("SOS");
        //when
        //then
        assertNotEquals(".--..-.-----..-..-----..-.",encode.EncodeWord() );

    }
}
