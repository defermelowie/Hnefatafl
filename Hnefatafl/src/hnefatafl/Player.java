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

<<<<<<< HEAD
    /**
     * Constructor for the abstract player class
     *
     * @param color The color of the player
=======
    //Constructors
    /**
     * Constructor for Player
     * @param color color of the player's pieces
>>>>>>> NoBoardMemberInPlayer
     */
    public Player(Color color) {
        this.color = color;
        this.alive = true;
        this.playTimeMillis = 0;
    }

    //getters
<<<<<<< HEAD

    /**
     * Getter for the color
     *
     * @return
=======
    
    /**
     * Getter for the color of the player
     *
     * @return the color of the player 
>>>>>>> NoBoardMemberInPlayer
     */
    public Color getColor() {
        return color;
    }

    /**
<<<<<<< HEAD
     * Getter for playTime
     *
     * @return The time this player has played
     */
    public int getPlayTime() {
        return playTimeMillis / 1000;
    }

    /**
     * Getter for alive
     *
     * @return True if the player is alive, false otherwise
     */
    public boolean isAlive() {
=======
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
>>>>>>> NoBoardMemberInPlayer
        return alive;
    }

    //setters
<<<<<<< HEAD

=======
    /**
     * setter to set the maximum playtime of the game
     * 
     * @param playTime maximumtime in miliseconden you want the game to last
     */
>>>>>>> NoBoardMemberInPlayer
    public void setPlayTime(int playTime) {
        this.playTimeMillis = playTime;
    }


    //other methods
<<<<<<< HEAD

    /**
     * Adds some amount to the player's timer
     *
     * @param milSec The amount to add
     */
    public void addToTimer(int milSec) {
=======
    
    /**
     * method to add time to the timer
     * 
     * @param milSec the time in miliseconden you want to add to the timer
     */
    public void addToTimer(int milSec){
>>>>>>> NoBoardMemberInPlayer
        this.playTimeMillis = this.playTimeMillis + milSec;
    }

    /**
<<<<<<< HEAD
     * Sets alive to false
     */
    public void kill() {
=======
     * method to kill a piece
     * 
     */
    public void kill(){
>>>>>>> NoBoardMemberInPlayer
        alive = false;
    }

    //abstract methods
<<<<<<< HEAD

    /**
     * Kills the player if he is dead
     *
     * @param playerPieces The pieces of this player
     */
    abstract public void checkDeath(Iterator<Piece> playerPieces);

    /**
     * Method to get a formatted string
     *
     * @return A String with type and alive data
     */
=======
    /**
     * abstract method to check if player is death
     * 
     * @param playerPieces
     */
    abstract public void checkDeath(Iterator<Piece> playerPieces);
    
    
>>>>>>> NoBoardMemberInPlayer
    abstract public String toString();
}