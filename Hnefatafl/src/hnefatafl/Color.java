package hnefatafl;

/**
 * Enum color defines the color that things can have
 */
public enum Color {
    WHITE {
        /**
         * returns opposite color
         * @return black if color is white
         */
        public Color opposite() {
            return BLACK;
        }
    },
    BLACK {
        /**
         * returns opposite color
         * @return white if color is white
         */
        public Color opposite() {
            return WHITE;
        }
    };
    abstract public Color opposite();
}
