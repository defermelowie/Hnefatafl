package hnefatafl;

/**
 * @author mikaz
 */
public class Hnefatafl {
    private Board board;
    private boolean pieceIsSelected;
    private Piece selectedPiece;
    private WhitePlayer whitePlayer;
    private BlackPlayer blackPlayer;
    private Player CurrentPlayer;

    public Hnefatafl() {
        this.board = new Board();
        this.pieceIsSelected = false;
        this.selectedPiece = null;
        this.whitePlayer = new WhitePlayer();
        this.whitePlayer.setPieces(board.getPiecesByColor(Color.WHITE));
        this.blackPlayer = new BlackPlayer();
        this.blackPlayer.setPieces((board.getPiecesByColor(Color.BLACK)));
    }

    //getters
    public Board getBoard() {
        return board;
    }

    public Player getWhitePlayer() {
        return whitePlayer;
    }

    public Player getBlackPlayer() {
        return blackPlayer;
    }

    public boolean isAPieceSelected() {
        return pieceIsSelected;
    }

    public Piece getSelectedPiece() {
        return selectedPiece;
    }

    //other methods
    public boolean selectPiece(int row, int column) {
        boolean succes = false;
        if (!pieceIsSelected) {
            selectedPiece = board.getPieceOn(row, column);
            if (selectedPiece != null) {
                pieceIsSelected = true;
                succes = true;
            }
        }
        return succes;
    }

    public boolean moveSelectedPieceTo(int row, int column) {
        boolean succes = false;
        if (pieceIsSelected && board.getPieceOn(row, column) == null) {
            succes = board.getPieceOn(selectedPiece.getRow(), selectedPiece.getColumn()).moveTo(row, column);
            if (succes == true) {
                pieceIsSelected = false;
                selectedPiece = null;
            }
        }
        return succes;
    }

    public void unSelectPiece(){
        pieceIsSelected = false;
        selectedPiece = null;
    }
}
