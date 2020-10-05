package com.elsevier.morse;

public class Console {

    private String decoded;
    private String encoded;

    public Console(String decoded, String encoded){
        this.decoded = decoded;
        this.encoded = encoded;
    }
    public void printLine(String s){
        ///to put the decoded word whith the right method
        System.out.format("smorse(%s) => %s", decoded, encoded);
    }
}
