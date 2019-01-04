package hnefatafl;

public enum Color {
    WHITE {
        public Color opposite(){
            return BLACK;
        }
    },
    BLACK {
        public Color opposite(){
            return WHITE;
        }
    };

    public Color opposite(){
        return this;
    }
}
