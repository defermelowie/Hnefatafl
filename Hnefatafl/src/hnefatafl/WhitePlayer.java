package hnefatafl;

public class WhitePlayer extends Player {

    public WhitePlayer() {
        this.color = Color.WHITE;
    }

    //other methods
    public boolean isAlive() {
        for (Piece p : this.pieces) {
            if (p instanceof King) {
                return p.isAlive();
            }
        }
        return false;
    }

    public boolean updateTo(Player player) {
        if (player instanceof WhitePlayer) {
            this.pieces = player.getPieces();
            return true;
        } else {
            return false;
        }
    }
}
