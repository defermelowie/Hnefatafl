package hnefatafl;

import java.util.Iterator;

public class WhitePlayer extends Player {

    public WhitePlayer(Board board) {
        super(Color.WHITE, board);
    }

    //other methods
    public boolean isAlive() {
        Iterator<Piece> pieces = super.getPieces();
        while (pieces.hasNext()) {
            Piece p = pieces.next();
            if (p.getType()==Type.KING) {
                return p.isAlive();
            }
        }
        return false;
    }

    //overridden methods
    @Override
    public String toString(){
        return "Type: WhitePlayer | Alive: " + this.isAlive();
    }
}
