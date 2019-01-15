package hnefatafl;

import java.util.Iterator;

abstract public class Player {
    private Color color;
    private int playTimeMillis;
    private boolean alive;

    /**
     * Constructor for the abstract player class
     *
     * @param color The color of the player
     */
    public Player(Color color) {
        this.color = color;
        this.alive = true;
        this.playTimeMillis = 0;
    }

    //getters

    /**
     * Getter for the color
     *
     * @return
     */
    public Color getColor() {
        return color;
    }

    /**
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
        return alive;
    }

    //setters

    /**
     * Setter for playTime
     *
     * @param playTime The new time this player has played
     */
    public void setPlayTime(int playTime) {
        this.playTimeMillis = playTime;
    }

    //other methods

    /**
     * Adds some amount to the player's timer
     *
     * @param milSec The amount to add
     */
    public void addToTimer(int milSec) {
        this.playTimeMillis = this.playTimeMillis + milSec;
    }

    /**
     * Sets alive to false
     */
    public void kill() {
        alive = false;
    }

    //abstract methods

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
    abstract public String toString();
}