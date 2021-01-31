package cribbage;

public class Hand {
        String[] hand = new String[5];
        Card card;

        public Hand(String[] hand) {
            this.hand = hand;
        }

        //## call cards from here and create an array of cards object to return to main
        @Override
        public String toString() {
            StringBuffer value = new StringBuffer();
            for (String item : hand) {
                value.append(item);
            }
            return value.toString();
        }

        public String[] getCards() {
            return hand;
        }



}
