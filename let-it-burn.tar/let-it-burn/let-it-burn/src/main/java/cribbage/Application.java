package cribbage;

import com.google.common.collect.Lists;

import java.lang.reflect.Array;
import java.util.List;

class Hand {
    String[] hand = new String[5];

    Hand(String[] hand) {
        this.hand = hand;
        System.out.println(hand);
    }
## call cards from here and create an array of cards object to return to main
    @Override
    public String toString() {
        return "Hand" + hand + '\'' + '}';
    }

}

class Card{
    String rank = new String();
    String suite = new String();

    Card( String rank, String suite){
        this.rank = rank;
        this.suite = suite;
    }

    public String getRank() {
        return rank;
    }

    public String getSuite() {
        return suite;
    }
}

class Points{

    Hand hand;

    Points(get the cards object){
        this.hand = hand;
    }

    public int upTo15{
        return number of points for this funcion
    }

    public int Runs{
        return point for runs
    }

    public int Pairs{
        return pairs
    }

    public int Flushes{
        return points Flushes
    }

    public int Nobs{
        return points nobs
    }

    public int getPoints{
       int  points  = 0;
       points = upTo15 + Runs + pairs + flushes + nobs
    }
}

public final class Application {


    public static void main(String[] args) {

//This input will need to read from screen
       // String[] handString = new String[5]{"5D","QS","JC","KH","AC"};
        Hand hand = new Hand(new String[]{"5D","QS","JC","KH","AC"});


        System.out.println("Done");
    }
}
