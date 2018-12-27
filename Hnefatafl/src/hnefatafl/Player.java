package hnefatafl;

import java.util.ArrayList;

public class Player {
    protected ArrayList<Piece> pieces = new ArrayList<>();
    protected Color color;

    public Player() {
    }

    //setters
    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    public Color getColor() {
        return color;
    }

    //getters
    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    //other methods

}