import cribbage.Card;
import cribbage.Hand;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestCard {

    @Test
    public void testCard() {
        //case
        Card card = new Card("A",'C');
        //then
        int value = card.getValue();
        char suite = card.getSuite();
        String rank = card.getRank();

        assertThat(value).isEqualTo(1);
        assertThat(suite).isEqualTo('C');
        assertThat(rank).isEqualTo("A");

    }

    @Test
    public void testCard_1() {
        //case
        Card card = new Card("5",'D');
        //then
        int value = card.getValue();
        char suite = card.getSuite();
        String rank = card.getRank();

        assertThat(value).isEqualTo(5);
        assertThat(suite).isEqualTo('D');
        assertThat(rank).isEqualTo("5");

    }
}
