package hnefatafl;

public class BlackPlayer extends Player {

    public BlackPlayer() {
        super(Color.BLACK);
    }

    //other methods
    public boolean isAlive() {
        boolean alive = true;
        for (Piece p : getPieces()) {
            if (p.isAlive() == true) {
                return true;
            }
        }
        return false;
    }

    public boolean updateTo(Player player) {
        if (player instanceof BlackPlayer) {
            this.setPieces(player.getPieces());
            return true;
        } else {
            return false;
        }
    }
}
