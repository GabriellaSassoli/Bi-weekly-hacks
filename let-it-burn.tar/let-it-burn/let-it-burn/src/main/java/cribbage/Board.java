//package cribbage;
//
//import com.google.common.collect.Lists;
//import com.google.common.collect.Maps;
//
//import java.util.List;
//import java.util.Map;
//
//public class Board {
//
//    private final int width;
//    private final int height;
//    private final Map<Location, Tile> locationToTileMap;
//
//    Board(int width, int height, Map<Location, Tile> tiles) {
//        this.width = width;
//        this.height = height;
//        this.locationToTileMap = tiles;
//    }
//
//    public int getWidth() {
//        return width;
//    }
//
//    public int getHeight() {
//        return height;
//    }
//
//    public List<Location> getLocations() {
//        return Lists.newArrayList(locationToTileMap.keySet());
//    }
//
//    public Tile getTile(Location location) {
//        return locationToTileMap.get(location);
//    }
//
//    public static Board fromString(String boardString) {
//        int height = boardString.split("\n").length;
//        int width = Lists.charactersOf(boardString.split("\n")[0]).size();
//
//        final Map<Location, Tile> cards = Maps.newHashMap();
//        int y = 0;
//        for (String line : boardString.split("\n")) {
//            int x = 0;
//            for (char symbol : Lists.charactersOf(line)) {
//                cards.put(new Location(x, y), Tile.fromSymbol(symbol));
//                x++;
//            }
//            y++;
//        }
//        return new Board(width, height, cards);
//    }
//
//    public Board setTile(Location location, Tile tile) {
//        locationToTileMap.put(location, tile);
//        return this;
//    }
//}
