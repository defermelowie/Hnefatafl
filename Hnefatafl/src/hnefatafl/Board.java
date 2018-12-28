package hnefatafl;

import java.util.ArrayList;

/**
 * Class for a board on which the game is played
 *
 * @author Stef, Mika, Lowie
 */
public class Board {
    private int[][] whitePawnStartCoordinates = {   //holds the start coordinates of the white pawns
            {3, 3}, {3, 4}, {3, 5},
            {4, 3}, {4, 5},
            {5, 3}, {5, 4}, {5, 5}
    };
    private int[] whiteKingStartCoordinate = {4, 4};    //holds the start coordinate of the king
    private int[][] blackPawnStartCoordinates = {   //holds the start coordinates of the white pawns
            {3, 0}, {4, 0}, {5, 0}, {4, 1},
            {0, 3}, {0, 4}, {0, 5}, {1, 4},
            {3, 8}, {4, 8}, {5, 8}, {4, 7},
            {8, 3}, {8, 4}, {8, 5}, {7, 4}
    };

    private ArrayList<Piece> pieces = new ArrayList<>();    //holds al the pieces on the board
    private Piece selectedPiece;    //holds a copy of the currently selected piece

    /**
     * Constructor for Board
     */
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

    /**
     * Getter for all the pieces on the board
     *
     * @return All the pieces on the board
     */
    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    /**
     * Getter for the pieces with a certain color
     *
     * @param color Color of the pieces to return
     * @return All the pieces on the board with a color specified by the color parameter
     */
    public ArrayList<Piece> getPiecesByColor(Color color) {
        ArrayList<Piece> pieces = new ArrayList<>();
        for (Piece p : this.pieces) {
            if (p.getColor() == color) {
                pieces.add(p);
            }
        }
        return pieces;
    }

    /**
     * Getter for a piece with a certain coordinate
     *
     * @param row    Row-coordinate of piece
     * @param column Column-coordinate of piece
     * @return The piece with the coordinates specified by the parameters, returns null if there is none
     */
    public Piece getPieceOn(int row, int column) {
        for (Piece p : pieces) {
            if (p.getRow() == row && p.getColumn() == column) {
                return p;
            }
        }
        return null;
    }

    /**
     * Getter for the selected piece
     *
     * @return A copy of the selected piece
     */
    public Piece getSelectedPiece() {
        return selectedPiece;
    }

    //other methods

    /**
     * Method to check if there is a piece selected
     *
     * @return true if there i a piece selected
     */
    public boolean isPieceSelected() {
        return (selectedPiece != null);
    }

    /**
     * Method to select a piece
     *
     * @param row    The row of the piece to select
     * @param column The column of the piece to select
     * @return true  if successful
     */
    public boolean selectPieceOn(int row, int column) {
        boolean succes = false;
        selectedPiece = this.getPieceOn(row, column);
        if (selectedPiece != null) {
            succes = true;
        }
        return succes;
    }

    /**
     * Method to move the selected piece to another field
     *
     * @param row    Row to move the piece to
     * @param column Column to move the piece to
     * @return true if successful (false if illegal move)
     */
    public boolean moveSelectedPieceTo(int row, int column) {
        boolean succes = false;
        if (selectedPiece != null && isPathEmpty(selectedPiece.getRow(), selectedPiece.getColumn(), row, column) && getPieceOn(row, column) == null) {
            succes = getPieceOn(selectedPiece.getRow(), selectedPiece.getColumn()).moveTo(row, column);
            if (succes == true) {
                selectedPiece = null;
            }
        }
        return succes;
    }

    /**
     * Method to deselect the currently selected piece
     */
    public void DeSelectPiece() {
        selectedPiece = null;
    }

    /**
     * Private method to check if the path between two fields is obstructed by a piece(s)
     *
     * @param startRow    Row-coordinate of the start field
     * @param startColumn Column-coordinate of the start field
     * @param endRow      Row-coordinate of the end field
     * @param endColumn   Column-coordinate of the end field
     * @return true if not obstructed (false if there is a piece in the path)
     */
    private boolean isPathEmpty(int startRow, int startColumn, int endRow, int endColumn) {
        for (int i = Math.min(startRow, endRow) + 1; i <= Math.max(startRow, endRow) - 1; i++) {
            if (getPieceOn(i, startColumn) != null) {
                return false;
            }
        }
        for (int j = Math.min(startColumn, endColumn) + 1; j <= Math.max(startColumn, endColumn) - 1; j++) {
            if (getPieceOn(startRow, j) != null) {
                return false;
            }
        }
        return true;
    }
}
