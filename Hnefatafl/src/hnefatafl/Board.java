package hnefatafl;


import java.util.ArrayList;
import java.util.Iterator;

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
    private int[][] blackPawnStartCoordinates = {   //holds the start coordinates of the black pawns
            {3, 0}, {4, 0}, {5, 0}, {4, 1},
            {0, 3}, {0, 4}, {0, 5}, {1, 4},
            {3, 8}, {4, 8}, {5, 8}, {4, 7},
            {8, 3}, {8, 4}, {8, 5}, {7, 4}
    };
    private int[][] barrierStartCoordinates = {   //holds the start coordinates of the barrier
            {-1, 1}, {-1, 2}, {-1, 6}, {-1, 7},
            {1, 9}, {2, 9}, {6, 9}, {7, 9},
            {1, -1}, {2, -1}, {6, -1}, {7, -1},
            {9, 1}, {9, 2}, {9, 6}, {9, 7}
    };
    private int[][] CornerCoordinates = {
            {0, 0}, {8, 0}, {0, 8}, {8, 8}
    };
    private int[][] HorizontalbarriersToSet = {
            {-1, 3}, {-1, 4}, {-1, 5},
            {9, 3}, {9, 4}, {9, 5},
    };
    private int[][] VerticalbarriersToSet = {
            {3, 9}, {4, 9}, {5, 9},
            {3, -1}, {4, -1}, {5, -1}
    };

    private ArrayList<Piece> pieces = new ArrayList<>();    //holds al the pieces on the board
    private Piece selectedPiece;    //holds a copy of the currently selected piece

    //constructor
    /**
     * Constructor for Board
     */
    public Board() {
        for (int i = 0; i < whitePawnStartCoordinates.length; i++) {
            pieces.add(new Piece(whitePawnStartCoordinates[i], Color.WHITE, Type.PAWN));
        }
        pieces.add(new Piece(whiteKingStartCoordinate, Color.WHITE, Type.KING));
        for (int i = 0; i < blackPawnStartCoordinates.length; i++) {
            pieces.add(new Piece(blackPawnStartCoordinates[i], Color.BLACK, Type.PAWN));
        }
        for (int i = 0; i < barrierStartCoordinates.length; i++) {
            pieces.add(new Piece(barrierStartCoordinates[i], null, Type.HARDBARRIER));
        }
        for (int i = 0; i < CornerCoordinates.length; i++) {
            pieces.add(new Piece(CornerCoordinates[i], null, Type.SOFTBARRIER));
        }
        selectedPiece = null;
    }


    //getters
    /**
     * Getter for all the pieces on the board
     *
     * @return All the pieces on the board
     */
    public Iterator<Piece> getPieces() {
        return pieces.iterator();
    }

    /**
     * Getter for the pieces with a certain color
     *
     * @param color Color of the pieces to return
     * @return All the pieces on the board with a color specified by the color parameter
     */
    public Iterator<Piece> getPiecesByColor(Color color) {
        ArrayList<Piece> pieces = new ArrayList<>();
        for (Piece p : this.pieces) {
            if (p.getColor() == color) {
                pieces.add(p);
            }
        }
        return pieces.iterator();
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
     * @return true if there is a piece selected
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
        boolean success = false;
        if (selectedPiece.getType() == Type.KING && isPathEmpty(selectedPiece.getRow(), selectedPiece.getColumn(), row, column) && (getPieceOn(row, column) == null || getPieceOn(row, column) == selectedPiece || getPieceOn(row, column).getType() == Type.SOFTBARRIER)) {
            success = getPieceOn(selectedPiece.getRow(), selectedPiece.getColumn()).moveTo(row, column);
        } else if (selectedPiece != null && isPathEmpty(selectedPiece.getRow(), selectedPiece.getColumn(), row, column) && (getPieceOn(row, column) == null || getPieceOn(row, column) == selectedPiece)) {
            success = getPieceOn(selectedPiece.getRow(), selectedPiece.getColumn()).moveTo(row, column);
        }
        if (success) {
            selectedPiece = null;
        }
        return success;
    }

    /**
     * Method to check if the king is on one of the corners
     *
     * 
     * @return true if king is on one of the corners, else false
     */
    public boolean isWhiteKingOnCorner() {
        for (int[] e : CornerCoordinates) {
            int row = e[0];
            int column = e[1];
            if (this.getKing().getRow() == row && this.getKing().getColumn() == column) {
                return true;
            }
        }
        return false;
    }

/**
     * Getter for the king
     *
     * 
     * @return the king, else return null
     */
    public Piece getKing() {
        for (Piece p : pieces) {
            if (p.getType() == Type.KING) {
                return p;
            }
        }
        return null;
    }

    public void placeBarrier(int row, int column) {
        pieces.add(new Piece(row, column, null, Type.HARDBARRIER));
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

    public void killCapturedPieces(Color lastPlayedColor) {
        Iterator<Piece> pieces = getPiecesByColor(lastPlayedColor.opposite());
        while (pieces.hasNext()) {
            Piece p = pieces.next();
            int rowP = p.getRow();
            int columnP = p.getColumn();
            boolean captured = false;
            Piece pieceAbove = getPieceOn(rowP - 1, columnP);
            Piece pieceUnder = getPieceOn(rowP + 1, columnP);
            Piece pieceLeft = getPieceOn(rowP, columnP - 1);
            Piece pieceRight = getPieceOn(rowP, columnP + 1);
            if (p.getType() == Type.KING) {
                if (pieceAbove != null && pieceUnder != null && pieceLeft != null && pieceRight != null) {
                    captured = pieceAbove.getColor() != p.getColor() && pieceAbove.canKill() &&
                            pieceUnder.getColor() != p.getColor() && pieceUnder.canKill() &&
                            pieceLeft.getColor() != p.getColor() && pieceLeft.canKill() &&
                            pieceRight.getColor() != p.getColor() && pieceRight.canKill();
                }
            } else {
                if (pieceAbove != null && pieceUnder != null) {
                    captured = pieceAbove.getColor() != p.getColor() && pieceAbove.canKill() &&
                            pieceUnder.getColor() != p.getColor() && pieceUnder.canKill();
                } else if (pieceLeft != null && pieceRight != null) {
                    captured = pieceLeft.getColor() != p.getColor() && pieceLeft.canKill() &&
                            pieceRight.getColor() != p.getColor() && pieceRight.canKill();
                }
            }
            if (captured) {
                p.kill();
            }
        }
    }

    public void setBarriers() {
        for (int[] c : HorizontalbarriersToSet) {
            int row = c[0];
            int column = c[1];
            if (this.getPieceOn(row + 1, column) == null && this.getPieceOn(row - 1, column) == null) { //boven en onder
                placeBarrier(c[0], c[1]);
                ;
            }
        }
        for (int[] d : VerticalbarriersToSet) {
            int row = d[0];
            int column = d[1];
            if (this.getPieceOn(row, column + 1) == null && this.getPieceOn(row, column - 1) == null) { //links en rechts
                placeBarrier(d[0], d[1]);
            }
        }
    }

    public void fillWithPieces(Color color) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                pieces.add(new Piece(i, j, color, Type.PAWN));
            }
        }
    }
}


