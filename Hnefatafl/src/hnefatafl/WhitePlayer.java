package hnefatafl;

import java.util.Iterator;

public class WhitePlayer extends Player {

    /**
     * Constructor for WhitePlayer
     */
    public WhitePlayer() {
        super(Color.WHITE);
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
            if (p.getType() == Type.KING && !p.isAlive()) {
                super.kill();
            }
        }
    }

    //overridden methods

    /**
     * Method to get a formatted string
     *
     * @return A String with type and alive data
     */
    @Override
    public String toString() {
        return "Type: WhitePlayer | Alive: " + super.isAlive();
    }
}
