package hnefatafl;

public class WhitePlayer extends Player {

    public WhitePlayer(Board board) {
        super(Color.WHITE, board);
    }

    //other methods
    public boolean isAlive() {
        for (Piece p : this.getPieces()) {
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
