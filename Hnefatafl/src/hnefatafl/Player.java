package hnefatafl;

import java.util.ArrayList;

abstract public class Player {
    private ArrayList<Piece> pieces = new ArrayList<>();
    private Color color;
    private int playTimeMillis;

    public Player(Color color) {
        this.color = color;
        this.playTimeMillis = 0;
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
    
    public int getPlaytime(){
        return playTimeMillis/1000;
    }
    
    //other methods
    public void addToTimer(int milSec){
        this.playTimeMillis = this.playTimeMillis + milSec;
    
    }

    //abstract methods
    abstract public boolean isAlive();
    abstract public String toString();
}