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
     * checks if player is death
     *
     * @param playerPieces
     */
    public void checkDeath(Iterator<Piece> playerPieces) {      //kills de zwarte speler als al zijn stukken dood zijn
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
     * gets a formatted string
     *
     * @return A String with type and alive data
     */
    @Override
    public String toString() {
        return "Type: BlackPlayer | Alive: " + super.isAlive();
    }
}
