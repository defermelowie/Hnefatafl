package hnefatafl;

import java.util.ArrayList;

/**
 * @author Stef, Mika, Lowie
 */
public class Board {
    private int whitePawnStartCoordinates[][] = {
            {3,3},{3,4},{3,5},
            {4,3},      {4,5},
            {5,3},{5,4},{5,5}
    };
    private int whiteKingStartCoordinate[] = {4, 4};
    private int blackPawnStartCoordinates[][] = {
            {3,0},{4,0},{5,0},{4,1},
            {0,3},{0,4},{0,5},{1,4},
            {3,8},{4,8},{5,8},{4,7},
            {8,3},{8,4},{8,5},{7,4}
    };

    private ArrayList<Piece> pieces = new ArrayList<>();
    private Piece selectedPiece;

    public Board() {
        for (int i = 0; i < 8; i++) {
            pieces.add(new Pawn(whitePawnStartCoordinates[i], Color.WHITE));
        }
        pieces.add(new King(whiteKingStartCoordinate));
        for (int i = 0; i < 16; i++) {
            pieces.add(new Pawn(blackPawnStartCoordinates[i], Color.BLACK));
        }
        selectedPiece = null;
    }

    //getters
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

    public Piece getPieceOn(int row, int column){
        for (Piece p : pieces){
            if (p.getRow() == row && p.getColumn() == column){
                return p;
            }
        }
        return null;
    }

    public Piece getSelectedPiece(){
        return selectedPiece;
    }

    //other methods
    public boolean isPieceSelected(){
        return (selectedPiece != null);
    }

    public boolean selectPieceOn(int row, int column){
        boolean succes = false;
        selectedPiece = this.getPieceOn(row, column);
            if (selectedPiece != null) {
                succes = true;
            }
        return succes;
    }

    public boolean moveSelectedPieceTo(int row, int column){
        boolean succes = false;
        if (selectedPiece != null && isPathEmpty(selectedPiece.getRow(), selectedPiece.getColumn(), row, column) && getPieceOn(row, column) == null){
            succes = getPieceOn(selectedPiece.getRow(),selectedPiece.getColumn()).moveTo(row, column);
        }
        if (succes == true){
            selectedPiece = null;
        }
        return succes;
    }

    public void unSelectPiece() {
        selectedPiece = null;
    }

    private boolean isPathEmpty(int startRow, int startColumn, int endRow, int endColumn){
        for (int i = Math.min(startRow, endRow)+1; i <= Math.max(startRow, endRow)-1; i++){
            if (getPieceOn(i, startColumn) != null){
                return false;
            }
        }
        for (int j = Math.min(startColumn, endColumn)+1; j <= Math.max(startColumn, endColumn)-1; j++){
            if (getPieceOn(startRow, j) != null){
                return false;
            }
        }
        return true;
    }
}
