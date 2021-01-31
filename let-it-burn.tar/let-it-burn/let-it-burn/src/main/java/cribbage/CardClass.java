package cribbage;

import java.util.*;

public class CardClass implements Comparable<CardClass> {

    public static final List<String> RANKS = java.util.Arrays.asList(new String[] { "A","2","3","4" ,"5" ,"6" ,"7" ,"8" ,"9" ,"10" ,"J" ,"Q" ,"K" });
   // public static final String[] SUITS = {"S","D","C","H"};

    Map<String, Integer> RANK  = new TreeMap<String, Integer>() {{
        put("A", 1);
        put("2", 2);
        put("3", 3);
        put("4", 4);
        put("5", 5);
        put("6", 6);
        put("7", 7);
        put("8", 8);
        put("9", 9);
        put("10",10);
        put("J", 10);
        put("Q", 10);
        put("K", 10);
    }};

    private String rank;
    private String suit;

    public CardClass(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public boolean equals(CardClass that) {
        return this.rank == that.rank && this.suit == that.suit;
    }

    @Override
    public int compareTo(CardClass that) {

        if(RANKS.indexOf(this.rank) < RANKS.indexOf(that.rank)) {
            return -1;
        }
        if(RANKS.indexOf(this.rank) > RANKS.indexOf(that.rank)) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return this.rank + " " + this.suit;
    }
    public static void main(String[] args) {
        List<CardClass> ss = new ArrayList<>();
        ss.add(new CardClass("A","S"));
        ss.add(new CardClass("4","C"));
        ss.add(new CardClass("2","H"));
        ss.add(new CardClass("A","D"));

        Collections.sort(ss);
        System.out.println(ss);


        CardClass first = new CardClass("K","S");
        CardClass second = new CardClass("Q","S");

        if(first > second) {}

    }

}
