package hnefatafl;

import java.util.Iterator;

public class BlackPlayer extends Player {

    /**
     * Constructor for BlackPlayer
     */
    public BlackPlayer() {
        super(Color.BLACK);
    }

    //other methods
    /**
     * Kills the player if he is dead
     *
     * @param playerPieces The pieces of this player
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
    public String toString(){
        return "Type: BlackPlayer | Alive: " + super.isAlive();
    }
}
