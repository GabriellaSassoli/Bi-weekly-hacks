package Morse;

import java.io.*;
import java.net.URL;
import java.util.*;

public class ReadWordsFromFile {

    //ATM if a morse word has more than one translation, just the last one has been save as value for that key"
    //have to find the way to save more than one or to get keys that have the same value from a dictionary
    private String fileName;
    private List<String> inputLine = new ArrayList<String>();


    public ReadWordsFromFile() throws IOException {
        this.fileName = "https://raw.githubusercontent.com/dolph/dictionary/master/enable1.txt";
        URL url = new URL(fileName);
        BufferedReader myReader = new BufferedReader(new InputStreamReader(url.openStream()));

        String line;
        while ((line = myReader.readLine()) != null) {
            inputLine.add(line);
        }
        myReader.close();
    }

    public List<String> getWords() {
        return this.inputLine;
    }
}

