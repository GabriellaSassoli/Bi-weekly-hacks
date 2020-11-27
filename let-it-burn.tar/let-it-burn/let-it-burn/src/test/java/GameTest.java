import cribbage.Board;
import cribbage.CharacterDisplay;
import cribbage.Game;
import cribbage.Location;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    public void newHotspotGivenAdjacentSmokeThenIgnites() {
        final String initialState = "" +
                "##### \n" +
                " SSS/ \n" +
                " SSS| \n" +
                " SSS_ \n" +
                "===== ";

        final String expected = "" +
                "##### \n" +
                " FFF/F\n" +
                " FFF| \n" +
                " FFF_F\n" +
                "===== ";

        runScenario(initialState, new Location(1, 1), expected);
    }

    @Test
    public void newHotspotGivenAdjacentOpenDoorThenSpreadsThrough() {
        final String initialState = "" +
                "   \n" +
                " / \n" +
                "   ";

        final String expected = "" +
                "   \n" +
                "S/S\n" +
                "   ";

        runScenario(initialState, new Location(0, 1), expected);
    }

    @Test
    public void newHotspotGivenNonAdjacentOpenDoorThenDoesNotSpreadThrough() {
        final String initialState = "" +
                "   \n" +
                " / \n" +
                "   ";

        final String expected = "" +
                "S  \n" +
                " / \n" +
                "   ";

        runScenario(initialState, new Location(0, 0), expected);
    }

    @Test
    @Disabled // Haven't implemented this but looks like it should be possible
    public void newHotspotGivenMultipleAdjacentOpenDoorsThenSpreadsThrough() {
        final String initialState = "" +
                "    \n" +
                " // \n" +
                "    ";

        final String expected = "" +
                "    \n" +
                "S//S\n" +
                "    ";

        runScenario(initialState, new Location(0, 1), expected);
    }

    private void runScenario(String initialState, Location hotspot, String expected) {
        // Given
        final Game game = new Game(Board.fromString(initialState));

        // When
        game.newHotspot(hotspot);

        // Then
        final String actual = new CharacterDisplay().toString(game.getBoard());
        assertThat(actual).isEqualTo(expected);
    }
}
