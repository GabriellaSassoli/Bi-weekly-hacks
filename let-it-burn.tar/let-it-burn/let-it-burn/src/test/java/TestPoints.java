
import cribbage.Hand;
import cribbage.Points;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;


public class TestPoints {

    @Test
    public void testUpTo15_1() {
        //case
        Hand hand = new Hand(new String[]{"5D","QS","JC","KH","AC"});
        Points points = new Points(hand);
        // when
        int point = points.upTo15();
        //then
        assertThat(point).isEqualTo(6);
    }

    @Test
    public void testUpTo15_2() {
        //case
        Hand hand = new Hand(new String[]{"8C","AD","10C","6H","7S"});
        Points points = new Points(hand);
        // when
        int point = points.upTo15();
        //then
        assertThat(point).isEqualTo(4);
    }

    @Test
    public void testUpTo15_3() {
        //case
        Hand hand = new Hand(new String[]{"AC","6D","5C","10C","8C"});
        Points points = new Points(hand);
        // when
        int point = points.upTo15();
        //then
        assertThat(point).isEqualTo(4);
    }


    @Test
    public void testUpTo15_4() {
        //case
        Hand hand = new Hand(new String[]{"AC","6D","5C","10C","8C"});
        Points points = new Points(hand);
        // when
        int point = points.upTo15();
        //then
        assertThat(point).isNotEqualTo(6);
    }

    @Test
    public void testUpTo15_5() {
        //case
        Hand hand = new Hand(new String[]{"8C","AD","10C","6H","7S"});
        Points points = new Points(hand);
        // when
        int point = points.upTo15();
        //then
        assertThat(point).isNotEqualTo(2);
    }

//    @Test
//    public void testUpTo15_6() {
//        //case
//        Hand hand = new Hand(new String[]{"AC","6D","5C","10C","8C"});
//        Points points = new Points(hand);
//        // when
//        int point = points.upTo15();
//        //then
//        assertThat(point).isNotEqualTo(2);
//    }

    @Test
    public void testPairs_1() {
        //case
        Hand hand = new Hand(new String[]{"AC","AD","5C","10C","8C"});
        Points points = new Points(hand);
        // when
        String pairs = points.Pairs().toString();
        //then
        assertThat(pairs).isEqualTo("2");
    }

    @Test
    public void testPairs_2() {
        //case
        Hand hand = new Hand(new String[]{"AC","AD","AC","10C","8C"});
        Points points = new Points(hand);
        // when
        String pairs = points.Pairs().toString();
        //then
        assertThat(pairs).isEqualTo("6");
    }

    @Test
    public void testPairs_3() {
        //case
        Hand hand = new Hand(new String[]{"AC","AD","AC","10C","AC"});
        Points points = new Points(hand);
        // when
        String pairs = points.Pairs().toString();
        //then
        assertThat(pairs).isEqualTo("12");
    }

    @Test
    public void testPairs_4() {
        //case
        Hand hand = new Hand(new String[]{"AC","AD","AC","10C","AC"});
        Points points = new Points(hand);
        // when
        String pairs = points.Pairs().toString();
        //then
        assertThat(pairs).isNotEqualTo("6");
    }
    @Test
    public void testPairs_5() {
        //case
        Hand hand = new Hand(new String[]{"AC","8D","AC","10C","8C"});
        Points points = new Points(hand);
        // when
        String pairs = points.Pairs().toString();
        //then
        assertThat(pairs).isEqualTo("4");
    }

    @Test
    public void testFlushes_1() {
        //case
        Hand hand = new Hand(new String[]{"AC","8C","AC","10C","8C"});
        Points points = new Points(hand);
        // when
        String pairs = points.Flushes().toString();
        //then
        assertThat(pairs).isEqualTo("5");
    }

    @Test
    public void testFlushes_2() {
        //case
        Hand hand = new Hand(new String[]{"AC","8C","AC","10C","8D"});
        Points points = new Points(hand);
        // when
        String pairs = points.Flushes().toString();
        //then
        assertThat(pairs).isEqualTo("4");
    }

    @Test
    public void testFlushes() {
        //case
        Hand hand = new Hand(new String[]{"AC","8C","AC","10D","8C"});
        Points points = new Points(hand);
        // when
        String pairs = points.Flushes().toString();
        //then
        assertThat(pairs).isEqualTo("0");
    }

    @Test
    public void testNobs_1() {
        //case
        Hand hand = new Hand(new String[]{"AC","JC","AC","10D","8C"});
        Points points = new Points(hand);
        // when
        int pairs = points.Nobs();
        //then
        assertThat(pairs).isEqualTo(1);
    }

    @Test
    public void testNobs_2() {
        //case
        Hand hand = new Hand(new String[]{"AC","JC","JC","10D","8C"});
        Points points = new Points(hand);
        // when
        int pairs = points.Nobs();
        //then
        assertThat(pairs).isEqualTo(2);
    }

    @Test
    public void testNobs_3() {
        //case
        Hand hand = new Hand(new String[]{"AC","JC","JD","10D","8C"});
        Points points = new Points(hand);
        // when
        int pairs = points.Nobs();
        //then
        assertThat(pairs).isEqualTo(1);
    }
}

//    @Test
//    public void newHotspotGivenAdjacentOpenDoorThenSpreadsThrough() {
//
//    }
//
//    @Test
//    public void newHotspotGivenNonAdjacentOpenDoorThenDoesNotSpreadThrough() {
//
//    }
//
//    @Test
//    @Disabled // Haven't implemented this but looks like it should be possible
//    public void newHotspotGivenMultipleAdjacentOpenDoorsThenSpreadsThrough() {
//        final String initialState = "" +
//                "    \n" +
//                " // \n" +
//                "    ";
//
//        final String expected = "" +
//                "    \n" +
//                "S//S\n" +
//                "    ";
//
//        runScenario(initialState, new Location(0, 1), expected);
//    }
//
//
//    }
//}
