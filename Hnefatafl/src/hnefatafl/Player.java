package hnefatafl;

import java.util.ArrayList;

public class Player {
    private ArrayList<Piece> pieces = new ArrayList<>();
    private Color color;

    public Player(Color color) {
        this.color = color;
    }

    //setters
    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    //getters
    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public Color getColor() {
        return color;
    }
    //other methods

}