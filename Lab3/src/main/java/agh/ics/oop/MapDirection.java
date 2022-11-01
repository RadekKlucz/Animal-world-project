package agh.ics.oop;

enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    private int x;
    private int y;

    public String toString() {
        return switch (this) {
            case NORTH -> "Północ";
            case SOUTH -> "Południe";
            case EAST -> "Wschód";
            case WEST -> "Zachód";
        };
    }

    public MapDirection next() {
        return switch (this) {
            case EAST -> WEST;
            default -> this;
        };
    }

    public MapDirection previous() {
        return switch (this) {
            case EAST -> NORTH;
            default -> this;
        };
    }

    public int[] toUnitVector() {
        switch (this) {
            case NORTH -> {
                int[] vectorN = {this.x = 0, this.y = 1};
                return vectorN;
            }
            case SOUTH -> {
                int[] vectorS = {0, -1};
                return vectorS;
            }
            case EAST -> {
                return new int[]{1, 0};
            }
            case WEST -> {
                return new int[]{-1, 0};
            }
        }
        return null;
    }
}
