package Morse;

import java.util.ArrayList;

public class UniqueWords {
    public static ArrayList<String> iterations13Chars = new ArrayList<>();

//    public ArrayList<String> printAllKLength(char[] set, int k) {
//        int n = set.length;
//        printAllKLengthRec(set, "", n, k);
    //    return;
//    }

    public ArrayList<String> printAllKLengthRec(char[] set, String prefix, int n, int k) {
        //System.out.println("Inside function");
        if (k == 0) {
            iterations13Chars.add(prefix);
            return this.iterations13Chars;
        }

        for (int i = 0; i < n; ++i) {
            String newPrefix = prefix + set[i];
            printAllKLengthRec(set, newPrefix, n, k - 1);
        }

        return this.iterations13Chars;
    }
}
