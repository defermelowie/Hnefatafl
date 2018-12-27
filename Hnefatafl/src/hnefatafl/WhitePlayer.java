package hnefatafl;

import java.util.ArrayList;

public class WhitePlayer extends Player {

    public WhitePlayer() {
    }

    public boolean isAlive() {
        for (Piece p : this.pieces){
            if (p instanceof King){
                return p.isAlive();
            }
        }
        return false;
    }
}
