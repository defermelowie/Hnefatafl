package hnefatafl;

public class BlackPlayer extends Player {

    public BlackPlayer() {
        this.color = Color.BLACK;
    }

    //other methods
    public boolean isAlive() {
        boolean alive = true;
        for (Piece p : pieces) {
            if (p.isAlive() == true) {
                return true;
            }
        }
        return false;
    }

    public boolean updateTo(Player player) {
        if (player instanceof BlackPlayer) {
            this.pieces = player.getPieces();
            return true;
        } else {
            return false;
        }
    }
}
