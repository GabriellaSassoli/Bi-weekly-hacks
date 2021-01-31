package cribbage;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public final class Application {


    public static void main(String[] args) {

//This input will need to read from screen
        // String[] handString = new String[5]{"5D","QS","JC","KH","AC"};
        Hand hand = new Hand(new String[]{"5D","QS","JC","KH","AC"});
        //Hand hand = new Hand(new String[]{"8C","AD","10C","6H","7S"});
        //Hand hand = new Hand(new String[]{"AC","6D","5C","10C","8C"});
        Points points = new Points(hand);
        System.out.println(hand);
        System.out.println("The score is: " + points.getPoints());

    }
}

