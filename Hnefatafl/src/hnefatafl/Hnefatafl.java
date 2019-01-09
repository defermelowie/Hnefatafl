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

    public void killCapturedPieces(){
        board.killCapturedPieces(currentPlayer.getColor());
    }
    
    public void setBarriers(){
        board.setBarriers();
    }
    
    public void updateBoard(){
        killCapturedPieces();
        setBarriers();
    }

    public void endTurn(){
        //System.out.println("Endturn is called");
        currentPlayer.setPieces(board.getPiecesByColor(currentPlayer.getColor()));
        if (currentPlayer instanceof WhitePlayer){
            whitePlayer.updateTo(currentPlayer);
            currentPlayer = blackPlayer;
        } else {
            blackPlayer.updateTo(currentPlayer);
            currentPlayer = whitePlayer;
        }
    }
    
    public boolean isGameFinished(){
        //System.out.println("checked for gamewon");
        if (blackPlayer.isAlive() == false || board.isWhiteKingOnCorner()==true){
            System.out.println("This Game has ended: White player wins");
            board.fillBoardWhitPieces(Color.WHITE);
            
            return true;
        }
        else if (whitePlayer.isAlive() == false){
            System.out.println("This Game has ended: Black player wins");
            board.fillBoardWhitPieces(Color.BLACK);
            return true;
        }
        return false;
    }
}
