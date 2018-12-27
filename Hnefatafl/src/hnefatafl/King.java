package hnefatafl;

/**
 * class for King piece
 *
 * @author Stef, Mika, Lowie
 */
public class King extends Piece {

    /**
     * constructor for King
     *
     * @param row    Row on the board for the new pawn
     * @param column Column on the board for the new pawn
     */
    public King(int row, int column) {
        super(row, column, Color.WHITE);   //color of the king is always white
    }

    /**
     * Constructor for pawn
     *
     * @param coordinates Array with {row, column}
     */
    public King(int coordinates[]) {
        super(coordinates, Color.WHITE);
    }
}
