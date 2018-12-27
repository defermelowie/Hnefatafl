package hnefatafl;

import java.util.ArrayList;

/**
 * @author mikaz
 */
public class Board {
    private ArrayList<Piece> pieces = new ArrayList<>();
    private int whitePawnStartCoordinates[][] = {
            {3,3},
            {4,3},
            {5,3},
            {5,4},
            {5,5},
            {4,5},
            {3,5},
            {3,4}
    };
    private int whiteKingStartCoordinate[] = {4, 4};
    private int blackPawnStartCoordinates[][] = {
            {3,0},{4,0},{5,0},{4,1},
            {0,3},{0,4},{0,5},{1,4},
            {3,8},{4,8},{5,8},{4,7},
            {8,3},{8,4},{8,5},{7,4}
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
