package agh.ics.oop;

import java.util.Objects;

class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(%d, %d)".formatted(x, y);
    }

    public boolean precedes(Vector2d other) {
        return this.x <= other.x && this.y <= other.y;
    }

    public boolean follows(Vector2d other) {
        return this.x >= other.x && this.y >= other.y;
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(this.x + other.x, this.y + other.y);
    }

    public Vector2d subtract(Vector2d other) {
        return new Vector2d(this.x - other.y, this.y - other.y);
    }

    public Vector2d upperRight(Vector2d other) {
        return new Vector2d(Math.max(this.x, other.x), Math.max(this.y, other.y));
    }

    public Vector2d lowerLeft(Vector2d other) {
        return new Vector2d(Math.min(this.x, other.x), Math.min(this.y, other.y));
    }

    public Vector2d opposite() {
        return new Vector2d(- this.x, - this.y);
    }

    public boolean equals(Vector2d other) {
        return Objects.equals(this.x, other.x) && Objects.equals(this.y, other.y);
    }


    enum MapDirection {
        NORTH,
        SOUTH,
        WEST,
        EAST;

        private int x;
        private int y;

        public String toString() {
            switch (this) {
                case NORTH:
                    return "Północ";
                case SOUTH:
                    return "Południe";
                case EAST:
                    return "Wschód";
                case WEST:
                    return "Zachód";
            }
            return null;
        }

        public MapDirection next() {
            if (this == EAST) {
                return WEST;
            } else {
                return null;
            }
        }

        public MapDirection previous() {
            if (this == EAST) {
                return NORTH;
            } else {
                return null;
            }
        }

        public int[] toUnitVector() {
            switch (this) {
                case NORTH:
                    int[] vectorN = {this.x = 0, this.y = 1};
                    return vectorN;
                case SOUTH:
                    int[] vectorS = {0, -1};
                    return vectorS;
                case EAST:
                    int[] vectorE = {1, 0};
                    return vectorE;
                case WEST:
                    int[] vectorW = {-1, 0};
                    return vectorW;
            }
            return null;
        }
    }
}
