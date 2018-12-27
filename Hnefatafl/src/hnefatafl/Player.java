package hnefatafl;

import java.util.ArrayList;

public class Player {
    protected ArrayList<Piece> pieces = new ArrayList<>();

    public Player() {
    }

    //setters
    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    //getters
    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    //other methods
    public boolean updateTo(Player player) {
        return false; //TODO
    }

}