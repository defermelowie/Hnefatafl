package hnefatafl;

import java.util.Iterator;

abstract public class Player {
    private Board board;
    private Color color;
    private int playTimeMillis;

    public Player(Color color, Board board) {
        this.color = color;
        this.board = board;
        this.playTimeMillis = 0;
    }

    //getters
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

    public Iterator<Piece> getPieces(){
        return board.getPiecesByColor(this.color);
    }

    //abstract methods
    abstract public boolean isAlive();
    abstract public String toString();
}