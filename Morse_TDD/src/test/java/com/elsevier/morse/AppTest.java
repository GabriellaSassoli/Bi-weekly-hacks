package com.elsevier.morse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class AppTest {
    @Mock
    private Console console;

//    private morseDictionary morsedictionary;
    private App app;


    @Test public void
    test_morse_word(){
        app= new App(console);
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
