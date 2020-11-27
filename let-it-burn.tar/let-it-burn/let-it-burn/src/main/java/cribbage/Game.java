//package cribbage;
//
//public final class Game {
//
//    private final Board board;
//
//    private enum Direction {
//        NORTH,
//        EAST,
//        SOUTH,
//        WEST
//    }
//
//    public Game(Board board) {
//        this.board = board;
//    }
//
//    public void newHotspot(Location location) {
//        developSmokeAt(location);
//        spreadSmokeThroughConnectingSpaces();
//        igniteSmokeNextToFires();
//    }
//
//    public Board getBoard() {
//        return board;
//    }
//
//    private void developSmokeAt(Location location) {
//        final Tile tile = board.getTile(location);
//
//        if (tile != null)
//            switch (tile) {
//                case SMOKE:
//                    board.setTile(location, Tile.FIRE);
//                    break;
//
//                case FIRE:
//                case WALL:
//                    // No action
//                    break;
//
//                case CLOSED_DOOR:
//                case OPEN_DOOR:
//                case DAMAGED_WALL:
//                    throw new IllegalStateException("Illegal attempt to apply smoke to " + tile + " at location " + location);
//
//                case OPEN_SPACE:
//                    board.setTile(location, Tile.SMOKE);
//                    break;
//
//                default:
//                    throw new RuntimeException("Unknown tile " + tile);
//            }
//    }
//
//    private void spreadSmokeThroughConnectingSpaces() {
//        boolean updated;
//        do {
//            updated = false;
//            for (Location location : board.getLocations()) {
//                final Tile tile = board.getTile(location);
//                if (tile == Tile.SMOKE) {
//                    if (spreadSmokeThrough(location)) {
//                        updated = true;
//                    }
//                }
//            }
//        } while (updated);
//    }
//
//    private boolean spreadSmokeThrough(Location location) {
//        boolean updated = false;
//        for (Direction direction : Direction.values()) {
//            final Location neighbouringLocation = getNeighbouringLocation(location, direction);
//            final Tile neighbour = board.getTile(neighbouringLocation);
//            if (neighbour == Tile.BROKEN_WALL_OR_DOOR || neighbour == Tile.OPEN_DOOR) {
//                final Location connectedLocation = getNeighbouringLocation(neighbouringLocation, direction);
//                if (board.getTile(connectedLocation) == Tile.OPEN_SPACE) {
//                    board.setTile(connectedLocation, Tile.SMOKE);
//                    updated = true;
//                }
//            }
//        }
//        return updated;
//    }
//
//    private void igniteSmokeNextToFires() {
//        boolean updated;
//        do {
//            updated = false;
//            for (Location location : board.getLocations()) {
//                if (board.getTile(location) == Tile.FIRE) {
//                    if (igniteNeighbouringSmoke(location)) {
//                        updated = true;
//                    }
//                }
//            }
//        } while (updated);
//    }
//
//    private boolean igniteNeighbouringSmoke(Location location) {
//        boolean updated = false;
//        for (Direction direction : Direction.values()) {
//            if (igniteInDirection(location, direction)) {
//                updated = true;
//            }
//        }
//        return updated;
//    }
//
//    private boolean igniteInDirection(Location location, Direction direction) {
//        boolean updated = false;
//
//        final Location neighbouringLocation = getNeighbouringLocation(location, direction);
//        final Tile neighbour = board.getTile(neighbouringLocation);
//
//        if (neighbour != null) {
//            switch (neighbour) {
//                case SMOKE:
//                    board.setTile(neighbouringLocation, Tile.FIRE);
//                    updated = true;
//                    break;
//
//                case FIRE:
//                case WALL:
//                case CLOSED_DOOR:
//                case DAMAGED_WALL:
//                case OPEN_SPACE:
//                    // No change
//                    break;
//
//                case OPEN_DOOR:
//                case BROKEN_WALL_OR_DOOR:
//                    updated = igniteInDirection(neighbouringLocation, direction);
//                    break;
//
//                default:
//                    throw new RuntimeException("Unknown tile " + neighbour);
//            }
//        }
//        return updated;
//    }
//
//    private Location getNeighbouringLocation(Location location, Direction direction) {
//        switch (direction) {
//            case NORTH:
//                return new Location(location.getX(), location.getY() - 1);
//            case EAST:
//                return new Location(location.getX() + 1, location.getY());
//            case SOUTH:
//                return new Location(location.getX(), location.getY() + 1);
//            case WEST:
//                return new Location(location.getX() - 1, location.getY());
//            default:
//                throw new RuntimeException("Unknown direction " + direction);
//        }
//    }
//}
