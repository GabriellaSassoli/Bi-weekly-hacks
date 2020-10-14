/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Morse;

import java.io.IOException;
import java.util.Scanner;

public class App {



    public static void main(String[] args) throws IOException {
        String word;
        Scanner in = new Scanner(System.in);
        int choice;
        Words findWord = new Words("https://raw.githubusercontent.com/dolph/dictionary/master/enable1.txt");
       // Map<String, String> wordMorse = new HashMap<String, String>();


        System.out.println("Type:\n1: If you want to encode a word; \n2: If you want the 1st challenge; \n3: If you want to find a morse word with a specific pattern\n4:To find the balanced words");
        choice = Integer.parseInt(in.nextLine());

        if (choice == 1) {

            System.out.println("Type word to encode: ");
            word = in.nextLine();
            System.out.println("You typed: " + word);
            Translator translator = new Translator(word);

            System.out.println("smorse( " + word + " ) => " + translator.Encode());
        }

        else if(choice == 2) {
            System.out.print("Number 2\n");

            //wordMorse = morseDictionary.getWordMorse(words);
            int numberOfWords = 0;

            System.out.println("Type how many words a morse word should corrispond to: ");
            if(in.hasNextInt()) {
                numberOfWords = in.nextInt();
                System.out.println("The morse word are/is " + findWord.getMorseWord(numberOfWords));
            }
            else{
                System.out.println("Sorry you didn't insert a number");
            }

        }
        else if(choice == 3) {
            System.out.print("Number 3\n");

            String pattern;
            System.out.println("Type pattern to match: ");
            pattern = in.next();
            System.out.println(pattern);

            System.out.println("The morse word are/is " + findWord.getWordsContaining(pattern));
        }
        else if(choice == 4){
            System.out.println("Number 4");
            int numberOfLetters = 0;
            System.out.println("Type number of letters of the word that has to be balanced: ");
            if(in.hasNextInt()) {
                numberOfLetters = in.nextInt();
                System.out.println("You have typed " + numberOfLetters);
                System.out.println("The morse word are/is " + findWord.getBalancedWord(numberOfLetters));
            }
            else{
                System.out.println("Sorry you didn't insert a number");
            }

        }

        else {System.out.println("Sorry, but your choice is incorrect");}
    }

}
