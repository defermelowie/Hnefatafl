package hnefatafl;

public class BlackPlayer extends Player {

    public BlackPlayer(Board board) {
        super(Color.BLACK, board);
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

    //overridden methods
    @Override
    public String toString(){
        return "Type: BlackPlayer | Alive: " + this.isAlive();
    }
}
