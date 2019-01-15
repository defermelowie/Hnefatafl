package hnefatafl;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class for a board on which the game is played
 *
 * @author Stef, Mika, Lowie
 */
public class Board {
    private ArrayList<Piece> pieces = new ArrayList<>();    //holds al the pieces on the board
    private Piece selectedPiece;    //the currently selected piece

    /**
     * Constructor for board class
     */
    public Board() {
        int[][] whitePawnStartCoordinates = {   //holds the start coordinates of the white pawns
                {3, 3}, {3, 4}, {3, 5},
                {4, 3}, {4, 5},
                {5, 3}, {5, 4}, {5, 5}
        };
        int[] whiteKingStartCoordinate = {4, 4};    //holds the start coordinate of the king
        int[][] blackPawnStartCoordinates = {   //holds the start coordinates of the black pawns
                {3, 0}, {4, 0}, {5, 0}, {4, 1},
                {0, 3}, {0, 4}, {0, 5}, {1, 4},
                {3, 8}, {4, 8}, {5, 8}, {4, 7},
                {8, 3}, {8, 4}, {8, 5}, {7, 4}
        };
        int[][] barrierStartCoordinates = {   //holds the start coordinates of the barrier
                {-1, 1}, {-1, 2}, {-1, 6}, {-1, 7},
                {1, 9}, {2, 9}, {6, 9}, {7, 9},
                {1, -1}, {2, -1}, {6, -1}, {7, -1},
                {9, 1}, {9, 2}, {9, 6}, {9, 7}
        };
        int[][] CornerCoordinates = {
                {0, 0}, {8, 0}, {0, 8}, {8, 8}
        };
        for (int[] whitePawnStartCoordinate : whitePawnStartCoordinates) {
            pieces.add(new Piece(whitePawnStartCoordinate, Color.WHITE, Type.PAWN));
        }
        pieces.add(new Piece(whiteKingStartCoordinate, Color.WHITE, Type.KING));
        for (int[] blackPawnStartCoordinate : blackPawnStartCoordinates) {
            pieces.add(new Piece(blackPawnStartCoordinate, Color.BLACK, Type.PAWN));
        }
        for (int[] barrierStartCoordinate : barrierStartCoordinates) {
            pieces.add(new Piece(barrierStartCoordinate, null, Type.HARDBARRIER));
        }
        for (int[] cornerCoordinate : CornerCoordinates) {
            pieces.add(new Piece(cornerCoordinate, null, Type.SOFTBARRIER));
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
     * Gets all the pieces with a certain color
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
     * Gets the piece with certain coordinates
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
     * @return The selected piece
     */
    public Piece getSelectedPiece() {
        return selectedPiece;
    }

    //other methods

    /**
     * Method to check if there is a piece selected
     *
     * @return True if there is a piece selected
     */
    public boolean isPieceSelected() {
        return (selectedPiece != null);
    }

    /**
     * Method to select a piece
     *
     * @param row    The row of the piece to select
     * @param column The column of the piece to select
     * @return True if successful
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
     * @return True if successful (false if illegal move)
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
     * Checks if the white king has reached the corner
     *
     * @return True is the white king has reached the corner
     */
    public boolean isWhiteKingOnCorner() {
        int[][] CornerCoordinates = {
                {0, 0}, {8, 0}, {0, 8}, {8, 8}
        };
        for (int[] e : CornerCoordinates) {
            int row = e[0];
            int column = e[1];
            for (Piece p : pieces) {
                if (p.getType() == Type.KING && p.getRow() == row && p.getColumn() == column) {
                    return true;
                }
            }

        }
        return false;
    }

    /**
     * Places a hard barrier piece on a specific tile
     *
     * @param row    The row to place the barrier on
     * @param column The column to place the barrier on
     */
    public void placeBarrier(int row, int column) {
        pieces.add(new Piece(row, column, null, Type.HARDBARRIER));
    }

    /**
     * Method to deselect the currently selected piece
     */
    public void deSelectPiece() {
        selectedPiece = null;
    }

    /**
     * Checks if the path between two fields is obstructed by a piece(s)
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

    /**
     * Kills the captured pieces of the player that hasn't just played
     *
     * @param lastPlayedColor The color of the player that has played last
     */
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
                }
                if (pieceLeft != null && pieceRight != null) {
                    captured = pieceLeft.getColor() != p.getColor() && pieceLeft.canKill() &&
                            pieceRight.getColor() != p.getColor() && pieceRight.canKill();
                }
            }
            if (captured) {
                p.kill();
            }
        }
    }

    /**
     * Places necessary hard barriers around the board
     */
    public void setBarriers() {
        int[][] HorizontalbarriersToSet = {
                {-1, 3}, {-1, 4}, {-1, 5},
                {9, 3}, {9, 4}, {9, 5},
        };
        int[][] VerticalbarriersToSet = {
                {3, 9}, {4, 9}, {5, 9},
                {3, -1}, {4, -1}, {5, -1}
        };
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

    /**
     * Fills the bord with pieces of a certain color
     *
     * @param color The color of the pieces to fill the board with
     */
    public void fillWithPieces(Color color) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                pieces.add(new Piece(i, j, color, Type.PAWN));
            }
        }
    }
}


