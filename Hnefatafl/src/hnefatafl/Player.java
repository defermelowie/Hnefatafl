package hnefatafl;

import java.util.Iterator;

/**
 * abstract class for a player who's playing the game
 *
 * @author Stef, Mika, Lowie
 */
abstract public class Player {
    private Color color;
    private int playTimeMillis;
    private boolean alive;

    //Constructors
    /**
     * Constructor for Player
     * @param color color of the player's pieces
     */
    public Player(Color color) {
        this.color = color;
        this.alive = true;
        this.playTimeMillis = 0;
    }

    //getters
    
    /**
     * Getter for the color of the player
     *
     * @return the color of the player 
     */
    public Color getColor() {
        return color;
    }

    /**
     * Getter for the time the game has lasted 
     *
     * @return the time the game has lasted in seconds
     */
    public int getPlaytime(){
        return playTimeMillis/1000;
    }
    
    
    /**
     * Getter to check if the player is alive
     *
     * @return true if the player is alive, false if the player is death
     */
    public boolean isAlive(){
        return alive;
    }

    //setters
    /**
     * setter to set the maximum playtime of the game
     * 
     * @param playTime maximumtime in miliseconden you want the game to last
     */
    public void setPlayTime(int playTime) {
        this.playTimeMillis = playTime;
    }

    //other methods
    
    /**
     * method to add time to the timer
     * 
     * @param milSec the time in miliseconden you want to add to the timer
     */
    public void addToTimer(int milSec){
        this.playTimeMillis = this.playTimeMillis + milSec;
    }

    /**
     * method to kill a piece
     * 
     */
    public void kill(){
        alive = false;
    }

    //abstract methods
    /**
     * abstract method to check if player is death
     * 
     * @param playerPieces
     */
    abstract public void checkDeath(Iterator<Piece> playerPieces);
    
    
    abstract public String toString();
}