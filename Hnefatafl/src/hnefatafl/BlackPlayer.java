package hnefatafl;

import java.util.Iterator;
/**
 * Class for the black player
 *
 * @author Stef, Mika, Lowie
 */
public class BlackPlayer extends Player {

    /**
     * Constructor for BlackPlayer
     */
    public BlackPlayer() {
        super(Color.BLACK);
    }

    //other methods
     /**
     * Method to check if player is death
     *
     * @param playerPieces
     */
    public void checkDeath(Iterator<Piece> playerPieces) {
        while (playerPieces.hasNext()) {
            Piece p = playerPieces.next();
            if (p.isAlive()) {
                return;
            }
        }
        super.kill();
    }

    //overridden methods

    /**
     * Method to get a formatted string
     *
     * @return A String with type and alive data
     */
    @Override

     /**
     * Method that print's out if the black player is still alive or not
     *
     *@return Type: BlackPlayer | Alive: true if the player is alive, else false
     */
    public String toString(){
        return "Type: BlackPlayer | Alive: " + super.isAlive();
    }
}
