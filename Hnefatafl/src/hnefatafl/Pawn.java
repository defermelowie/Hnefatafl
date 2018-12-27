package hnefatafl;

/**
 * class for Pawn piece
 *
 * @author Stef, Mika, Lowie
 */
public class Pawn extends Piece {

    /**
     * Constructor for pawn
     *
     * @param row    Row on the board for the new pawn
     * @param column Column on the board for the new pawn
     * @param color  true if White, false if Black
     */
    public Pawn(int row, int column, Color color) {
        super(row, column, color);
    }

    /**
     * Constructor for pawn
     *
     * @param coordinates Array with {row, column}
     * @param color       true if White, false if Black
     */
    public Pawn(int coordinates[], Color color) {
        super(coordinates, color);
    }
}
