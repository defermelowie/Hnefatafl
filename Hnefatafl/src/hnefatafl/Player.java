package hnefatafl;

import java.util.ArrayList;

/**
 * @author mikaz
 */
public class Player {
    private Color color;
    private ArrayList<Piece> pieces = new ArrayList<>();

    /**
     * Constructor for player
     *
     * @param color true if White, false if Black
     */
    public Player(Color color) {
        this.color = color;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    public boolean isAlive() {
        for (Piece p : pieces) {
            if (p.isAlive() == true) {
                return true;
            }
        }
        return false;
    }
}
