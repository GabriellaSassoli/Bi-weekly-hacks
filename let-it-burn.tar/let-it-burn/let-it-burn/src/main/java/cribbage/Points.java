package cribbage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Points {


        Hand hand;
        List<Integer> cardValues = new ArrayList<>();
        List<String> cardRank = new ArrayList<>();
        List<Character> cardSuits = new ArrayList<>();

        public Points(Hand hand) {
            this.hand = hand;

            for (String card : hand.getCards()) {
                Card cards = new Card(card.substring(0, card.length() - 1), card.charAt(card.length() - 1));
                cardValues.add(cards.getValue());
                cardRank.add(cards.getRank());
                cardSuits.add(cards.getSuite());
            }

        }

        private int sumto15(int i, int val) {
            if(i >= cardValues.size()) return 0;
            int score = 0;
            score += sumto15(i + 1, val);
            val += cardValues.get(i);
            if(val == 15) score += 2;
            score += sumto15(i + 1, val);
            return score;
        }

        public int upTo15() {

            int cardsAddUp = 0;

            cardsAddUp += sumto15(0, 0);
                //System.out.println("end of function: " + cardsAddUp);

//                for (int j = i + 1; j < cardValues.size(); j++) {
//                    current_sum += cardValues.get(j);
//                    System.out.println("current sum " + current_sum);
//                    System.out.println(cardValues.get(j));
//                    if (current_sum == 15) {
//                        System.out.println("Equals 15");
//                        cardsAddUp += 1;
//                    }
//                    else if (current_sum > 15) {
//                        current_sum -= cardValues.get(j);
//                        System.out.println("current sum " + current_sum);
//                    }

                    //System.out.println("END");

//                }

            return cardsAddUp ; //*2
        }

        //    public int Runs(){
//
//            int streak = 1;
//            int best = 1;
//            int i;
//
//            System.out.println(cardRank.size());
//            for(i = 0 ; i < cardRank.size(); i++)
//               // System.out.printf("Values %s, %i ",cardValues, cardValues.get(i));
//                System.out.println("inside function runs: " +  cardRank.get(i) +  " " + cardRank.get(i + 1) );
////                System.out.println(cardValues.get(i));
////                System.out.println(cardValues.get(i + 1 ));
//                System.out.println("printing");
//
//                for (String rank : cardRank) {
//
//                }
//                streak +=
//                if(cardRank.get(i) == )) {
//                    streak++;
//                    best = streak > best ? streak : best;
//                    System.out.println(best);
//                }
//                else streak = 1;
//
//            return best > 2 ? best : 0;
//    }
//
        public AtomicReference<Integer> Pairs(){

            AtomicReference<Integer> points= new AtomicReference<>(0);
            Map<Object, Long> map = cardRank.stream()
                    .collect(  Collectors.groupingBy(c -> c , Collectors.counting())) ;

            map.forEach((k,v) -> {
                if (v == 2) {
                    points.updateAndGet(v1 -> v1 + 2);
                }
                if (v == 3) {
                    points.updateAndGet(v2 -> v2 + 6);
                }
                if (v == 4) {
                    points.updateAndGet(v2 -> v2 + 12);
                }
            });

            return points;
        }

        public AtomicReference<Integer> Flushes() {

            AtomicReference<Integer> points = new AtomicReference<>(0);
            List<Character> cardUpSuits = new ArrayList<>(cardSuits);
            cardUpSuits.remove(cardUpSuits.size() - 1);
            Map<Object ,Long > map = cardUpSuits.stream()
                    .collect(  Collectors.groupingBy(c ->c , Collectors.counting())         ) ;

            map.forEach((k,v) -> {
                if(v == 4){
                    if(k.equals(cardSuits.get(cardSuits.size() - 1))){points.updateAndGet(v1 -> 5);}
                    else{ points.updateAndGet(v1 -> 4);}
                }
            });
//            System.out.println(cardSuits);
            return points;
        }

        public int Nobs(){
            int points = 0;
            for (int i = 0; i < cardRank.size(); i++) {
                if (cardRank.get(i).equals("J")){
                    if(cardSuits.get(i).equals(cardSuits.get(cardSuits.size() - 1))){ points += 1;}
                }
            }
            return points;
        }

        public int getPoints(){
           int  points  = 0;
           points = upTo15() + Integer.parseInt(Pairs().toString()) + Integer.parseInt(Flushes().toString()) + Nobs();//+ Runs +
           return points;
        }


}
