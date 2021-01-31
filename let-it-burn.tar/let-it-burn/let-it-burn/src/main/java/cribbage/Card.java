package cribbage;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Card {

        private int value = 0;
        private String rank;
        private Character suite;
        private Map<String, Integer> values = new HashMap<String, Integer>(){{
            put("A", 1);
            put("2", 2);
            put("3", 3);
            put("4", 4);
            put("5", 5);
            put("6", 6);
            put("7", 7);
            put("8", 8);
            put("9", 9);
            put("10", 10);
            put("J", 10);
            put("Q", 10);
            put("K", 10);
        }};

        public Card(String rank, Character suite){
            this.rank = rank;
            this.value = values.get(rank);
            this.suite = suite;
        }

        public int getValue() {
            return value;
        }

        public Character getSuite() {
            return suite;
        }

        public String getRank() { return rank; }


        public int compareTo(cribbage.Card that) {

            if (this.rank == that.getRank()) {
                return 1;
            }
            return 0;
        }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Card card = (Card) o;
//        if("Q".equals(this.suite) && "J".equals(card.suite) ) {
//            return
//        }
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(value, rank, suite, values);
//    }
}
