//package cribbage;
//
//public class CharacterDisplay {
//
//    public String toString(Board board) {
//        final StringBuilder builder = new StringBuilder();
//        for (int y = 0; y < board.getHeight(); y++) {
//            for (int x = 0; x < board.getWidth(); x++) {
//                builder.append(board.getTile(new Location(x, y)).toSymbol());
//            }
//            builder.append(("\n"));
//        }
//        return builder.deleteCharAt(builder.lastIndexOf("\n")).toString();
//    }
//}
