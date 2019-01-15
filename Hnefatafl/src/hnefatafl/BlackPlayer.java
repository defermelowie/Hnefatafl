package hnefatafl;

import java.util.Iterator;

public class BlackPlayer extends Player {

    public BlackPlayer() {
        super(Color.BLACK);
    }

    //other methods
    public void checkDeath(Iterator<Piece> playerPieces) {
        System.out.println("checked back death");
        while (playerPieces.hasNext()) {
            Piece p = playerPieces.next();
            if (p.isAlive()) {
                return;
            }
        }
        super.kill();
    }

    //overridden methods
    @Override
    public String toString(){
        return "Type: BlackPlayer | Alive: " + super.isAlive();
    }
}
