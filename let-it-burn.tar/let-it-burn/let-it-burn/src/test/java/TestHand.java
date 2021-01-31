import cribbage.Hand;
import cribbage.Points;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestHand {

    @Test
    public void testHand_1() {
        //case
        Hand hand = new Hand(new String[]{"AC","JC","AC","10D","8C"});
        // when
        String[] handString = hand.getCards();
        String[] string = new String[]{"AC", "JC", "AC", "10D", "8C"};
        //then
        assertThat(handString).isEqualTo(new String[]{"AC", "JC", "AC", "10D", "8C"});
    }

    @Test
    public void testHand_2() {
        //case
        Hand hand = new Hand(new String[]{"AC","JC","AC","10D","8C"});
        // when
        String[] handString = hand.getCards();
        String[] string = new String[]{"AC", "JC", "AC", "10D", "8C"};
        //then
        assertThat(handString).isNotEqualTo(new String[]{"AC", "JC", "AD", "10D", "8C"});
    }
}
