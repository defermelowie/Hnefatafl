package hnefatafl;

import java.util.Iterator;

public class BlackPlayer extends Player {

    public BlackPlayer(Board board) {
        super(Color.BLACK, board);
    }

    //other methods
    public boolean isAlive() {
        boolean alive = true;
        Iterator<Piece> pieces = getPieces();
        while (pieces.hasNext()) {
            Piece p = pieces.next();
            if (p.isAlive()) {
                return true;
            }
        }
        return false;
    }

    //overridden methods
    @Override
    public String toString(){
        return "Type: BlackPlayer | Alive: " + this.isAlive();
    }
}
