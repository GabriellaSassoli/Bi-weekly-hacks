package com.elsevier.morse;
import org.junit.Test;
import org.mockito.Mock;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;



public class AppTest {
    @Mock
    private Console console;

    private morseDictionary morsedictionary;
    private App app;
    //App app = new App(console);

    @Test public void
    test_morse_word(){
        //case
        app.encodedWord("...---...");
        app.decodedWord();

        //when
        app.printStatement();

        // then
        verify(console).printLine("smorse(\"sos\") => \"...---...\"");
//        verify(console).printLine("smorse(\"daily\") => \"-...-...-..-.--\"");
//        verify(console).printLine("smorse(\"programmer\") => \".--..-.-----..-..-----..-.\"");
//        assertThat(console).isEqualTo("smorse(\"bits\") => \"-.....-..."\");
//        assertThat(console).isEqualTo("smorse(\"three\") => \"-.....-...\"");

    }

}
