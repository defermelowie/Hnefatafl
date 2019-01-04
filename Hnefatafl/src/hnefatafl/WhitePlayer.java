package hnefatafl;

public class WhitePlayer extends Player {

    public WhitePlayer() {
        super(Color.WHITE);
    }

    //other methods
    public boolean isAlive() {
        for (Piece p : this.getPieces()) {
            if (p instanceof King) {
                return p.isAlive();
            }
        }
        return false;
    }

    public boolean updateTo(Player player) {
        if (player instanceof WhitePlayer) {
            this.setPieces(player.getPieces());
            return true;
        } else {
            return false;
        }
    }

    //overridden methods
    @Override
    public String toString(){
        return "Type: WhitePlayer | Alive: " + this.isAlive();
    }
}
