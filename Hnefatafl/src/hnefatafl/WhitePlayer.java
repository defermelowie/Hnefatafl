package hnefatafl;

import java.util.Iterator;

public class WhitePlayer extends Player {

    public WhitePlayer() {
        super(Color.WHITE);
    }

    //other methods
    public void checkDeath(Iterator<Piece> playerPieces) {
        System.out.println("checked white death");
        while (playerPieces.hasNext()) {
            Piece p = playerPieces.next();
            if (p.getType() == Type.KING && !p.isAlive()) {
                super.kill();
            }
        }
    }

    //overridden methods
    @Override
    public String toString() {
        return "Type: WhitePlayer | Alive: " + super.isAlive();
    }
}
