//package cribbage;
//
//import java.util.Arrays;
//import java.util.Map;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//
//public enum Tile {
//
//    SMOKE('S'),
//    FIRE('F'),
//    WALL('#'),
//    CLOSED_DOOR('|'),
//    OPEN_DOOR('/'),
//    DAMAGED_WALL('='),
//    BROKEN_WALL_OR_DOOR('_'),
//    DUCK('Q'),
//    OPEN_SPACE(' ');
//
//    private final Character symbol;
//
//    private static final Map<Character, Tile> symbolToEntity =
//            Arrays.stream(Tile.values())
//                    .collect(Collectors.toMap(x -> x.symbol, Function.identity()));
//
//    Tile(Character symbol) {
//        this.symbol = symbol;
//    }
//
//    public Character toSymbol() {
//        return symbol;
//    }
//
//    public static Tile fromSymbol(Character symbol) {
//        return symbolToEntity.get(symbol);
//    }
//}
