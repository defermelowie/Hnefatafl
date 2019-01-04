package hnefatafl;

/**
 * Main game class
 *
 * @author Stef, Mika, Lowie
 */
public class Hnefatafl {
    private Board board;
    private WhitePlayer whitePlayer;
    private BlackPlayer blackPlayer;
    private Player currentPlayer;

    /**
     * Constructor for Hnefatafl (game)
     */
    public Hnefatafl() {
        this.board = new Board();
        this.whitePlayer = new WhitePlayer();
        this.whitePlayer.setPieces(board.getPiecesByColor(Color.WHITE));
        this.blackPlayer = new BlackPlayer();
        this.blackPlayer.setPieces((board.getPiecesByColor(Color.BLACK)));
        this.currentPlayer = whitePlayer;
    }

    //getters

    /**
     * Getter for the board that belongs to this game
     *
     * @return The board
     */
    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    //other methods
    public boolean selectPieceOn(int row, int column){
        if (board.getPieceOn(row, column) != null && board.getPieceOn(row,column).getColor() == currentPlayer.getColor()) {
            return board.selectPieceOn(row, column);
        } else {
            return false;
        }
    }

    public boolean moveSelectedPieceTo (int row, int column){
        return board.moveSelectedPieceTo(row, column);
    }

    public void checkForCapturedPieces (){
        board.checkCapturedPieces(currentPlayer.getColor());
    }

    public void endTurn(){
        currentPlayer.setPieces(board.getPiecesByColor(currentPlayer.getColor()));
        if (currentPlayer instanceof WhitePlayer){
            whitePlayer.updateTo(currentPlayer);
            currentPlayer = blackPlayer;
        } else {
            blackPlayer.updateTo(currentPlayer);
            currentPlayer = whitePlayer;
        }
    }
}
