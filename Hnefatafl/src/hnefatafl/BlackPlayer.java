package hnefatafl;

public class BlackPlayer extends Player {

    public BlackPlayer() {
    }

    public boolean isAlive() {
        boolean alive = true;
        for (Piece p : pieces) {
            if (p.isAlive() == true) {
                return true;
            }
        }
        return false;
    }
}
