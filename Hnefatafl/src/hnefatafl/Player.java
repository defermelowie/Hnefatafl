package hnefatafl;

import java.util.Iterator;

abstract public class Player {
    private Color color;
    private int playTimeMillis;
    private boolean alive;

    //Constructors
    public Player(Color color) {
        this.color = color;
        this.alive = true;
        this.playTimeMillis = 0;
    }

    //getters
    public Color getColor() {
        return color;
    }

    public int getPlaytime(){
        return playTimeMillis/1000;
    }

    public boolean isAlive(){
        return alive;
    }

    //setters
    public void setPlayTime(int playTime) {
        this.playTimeMillis = playTime;
    }

    //other methods
    public void addToTimer(int milSec){
        this.playTimeMillis = this.playTimeMillis + milSec;
    }

    public void kill(){
        alive = false;
    }

    //abstract methods
    abstract public void checkDeath(Iterator<Piece> playerPieces);
    abstract public String toString();
}