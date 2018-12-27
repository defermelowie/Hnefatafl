package hnefatafl;

import java.util.ArrayList;

/**
 * @author mikaz
 */
public class Board {
    private ArrayList<Piece> pieces = new ArrayList<>();
    private int whitePawnStartCoordinates[][] = {
            {6, 4}, {6, 5}, {6, 6},
            {5, 4}, {5, 6},
            {4, 4}, {4, 5}, {4, 6}
    };
    private int whiteKingStartCoordinate[] = {5, 5,};
    private int blackPawnStartCoordinates[][] = {
            {1, 4}, {1, 5}, {1, 6}, {2, 5},
            {4, 1}, {5, 1}, {6, 1}, {5, 2},
            {9, 4}, {9, 5}, {9, 6}, {8, 5},
            {4, 9}, {5, 9}, {6, 9}, {5, 8},
    };

    public Board() {

        for (int i = 0; i < 8; i++) {
            pieces.add(new Pawn(whitePawnStartCoordinates[i], Color.WHITE));
        }
        pieces.add(new King(whiteKingStartCoordinate));
        for (int i = 0; i < 16; i++) {
            pieces.add(new Pawn(blackPawnStartCoordinates[i], Color.BLACK));
        }
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public ArrayList<Piece> getPiecesByColor(Color color) {
        ArrayList<Piece> pieces = new ArrayList<>();
        for (Piece p : this.pieces) {
            if (p.getColor() == color) {
                pieces.add(p);
            }
        }
        return pieces;
    }
}
